package kitchenpos.takeoutorder.application.dto;

import kitchenpos.common.OrderStatus;
import kitchenpos.common.OrderType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TakeOutOrderResponse {
    private UUID id;
    private OrderType type;
    private OrderStatus status;
    private LocalDateTime orderDateTime;
    private List<TakeOutOrderLineItemResponse> takeOutOrderLineItems;

    public TakeOutOrderResponse(UUID id, OrderType type, OrderStatus status, LocalDateTime orderDateTime, List<TakeOutOrderLineItemResponse> takeOutOrderLineItems) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.orderDateTime = orderDateTime;
        this.takeOutOrderLineItems = takeOutOrderLineItems;
    }

    public static TakeOutOrderResponse create(UUID id, OrderType type, OrderStatus status, LocalDateTime orderDateTime, List<TakeOutOrderLineItemResponse> takeOrderLineItemResponse) {
        return new TakeOutOrderResponse(id, type, status, orderDateTime, takeOrderLineItemResponse);
    }

    public UUID getId() {
        return id;
    }

    public OrderType getType() {
        return type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public List<TakeOutOrderLineItemResponse> getTakeOutOrderLineItems() {
        return takeOutOrderLineItems;
    }
}
