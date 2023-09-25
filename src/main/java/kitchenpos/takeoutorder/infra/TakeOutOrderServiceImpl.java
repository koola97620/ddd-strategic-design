package kitchenpos.takeoutorder.infra;


import kitchenpos.common.OrderStatus;
import kitchenpos.common.OrderType;
import kitchenpos.takeoutorder.application.TakeOutOrderService;
import kitchenpos.takeoutorder.application.dto.*;
import kitchenpos.takeoutorder.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TakeOutOrderServiceImpl implements TakeOutOrderService {
    private final TakeOutOrderRepository orderRepository;
    private final TakeOutMenuRepository menuRepository;

    public TakeOutOrderServiceImpl(
            final TakeOutOrderRepository orderRepository,
            final TakeOutMenuRepository menuRepository
    ) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    @Transactional
    public TakeOutOrderResponse create(final TakeOutOrderRequest request) {
        final OrderType type = request.getType();
        if (Objects.isNull(type)) {
            throw new IllegalArgumentException();
        }
        final List<TakeOutOrderLineItemRequest> orderLineItemRequests = request.getTakeOutOrderLineItemRequests();
        if (Objects.isNull(orderLineItemRequests) || orderLineItemRequests.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final List<TakeOutMenu> menus = menuRepository.findAllByIdIn(
                orderLineItemRequests.stream()
                        .map(TakeOutOrderLineItemRequest::getMenuId)
                        .collect(Collectors.toList())
        );
        if (menus.size() != orderLineItemRequests.size()) {
            throw new IllegalArgumentException();
        }
        final List<TakeOutOrderLineItem> orderLineItems = new ArrayList<>();
        for (final TakeOutOrderLineItemRequest orderLineItemRequest : orderLineItemRequests) {
            final long quantity = orderLineItemRequest.getQuantity();
            if (quantity < 0) {
                throw new IllegalArgumentException();
            }
            final TakeOutMenu menu = menuRepository.findById(orderLineItemRequest.getMenuId())
                    .orElseThrow(NoSuchElementException::new);
            if (!menu.isDisplayed()) {
                throw new IllegalStateException();
            }
            if (menu.getPrice().compareTo(orderLineItemRequest.getPrice()) != 0) {
                throw new IllegalArgumentException();
            }
            final TakeOutOrderLineItem orderLineItem = new TakeOutOrderLineItem();
            orderLineItem.setMenu(menu);
            orderLineItem.setQuantity(quantity);
            orderLineItems.add(orderLineItem);
        }
        TakeOutOrder order = new TakeOutOrder();
        order.setId(UUID.randomUUID());
        order.setType(type);
        order.setStatus(OrderStatus.WAITING);
        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderLineItems(orderLineItems);
        TakeOutOrder savedOrder = orderRepository.save(order);
        return createTakeOutOrderResponse(savedOrder);
    }

    @Override
    @Transactional
    public OrderStatusResponse accept(final UUID orderId) {
        final TakeOutOrder order = orderRepository.findById(orderId)
                .orElseThrow(NoSuchElementException::new);
        if (order.getStatus() != OrderStatus.WAITING) {
            throw new IllegalStateException();
        }
        order.setStatus(OrderStatus.ACCEPTED);
        return OrderStatusResponse.create(order.getId(), order.getStatus());
    }

    @Override
    @Transactional
    public OrderStatusResponse serve(final UUID orderId) {
        final TakeOutOrder order = orderRepository.findById(orderId)
                .orElseThrow(NoSuchElementException::new);
        if (order.getStatus() != OrderStatus.ACCEPTED) {
            throw new IllegalStateException();
        }
        order.setStatus(OrderStatus.SERVED);
        return OrderStatusResponse.create(order.getId(), order.getStatus());
    }

    @Override
    @Transactional
    public OrderStatusResponse complete(final UUID orderId) {
        final TakeOutOrder order = orderRepository.findById(orderId)
                .orElseThrow(NoSuchElementException::new);
        final OrderType type = order.getType();
        final OrderStatus status = order.getStatus();
        if (status != OrderStatus.SERVED) {
            throw new IllegalStateException();
        }
        order.setStatus(OrderStatus.COMPLETED);
        return OrderStatusResponse.create(order.getId(), order.getStatus());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TakeOutOrderResponse> findAll() {
        List<TakeOutOrder> takeOutOrders = orderRepository.findAll();
        return takeOutOrders.stream()
                .map(this::createTakeOutOrderResponse)
                .collect(Collectors.toList());
    }

    private TakeOutOrderResponse createTakeOutOrderResponse(TakeOutOrder savedOrder) {
        return TakeOutOrderResponse.create(
                savedOrder.getId(),
                savedOrder.getType(),
                savedOrder.getStatus(),
                savedOrder.getOrderDateTime(),
                createEatInOrderLineItemResponse(savedOrder.getOrderLineItems())
        );
    }

    private List<TakeOutOrderLineItemResponse> createEatInOrderLineItemResponse(List<TakeOutOrderLineItem> orderLineItems) {
        return orderLineItems.stream()
                .map(m -> TakeOutOrderLineItemResponse.create(m.getSeq(), m.getMenuId(), m.getQuantity()))
                .collect(Collectors.toList());
    }
}
