package kitchenpos.takeoutorder.application.dto;

import kitchenpos.common.OrderType;

import java.util.List;

public class TakeOutOrderRequest {
    private OrderType type;
    private List<TakeOutOrderLineItemRequest> takeOutOrderLineItemRequests;

    public TakeOutOrderRequest(OrderType orderType, List<TakeOutOrderLineItemRequest> orderLineItems) {
        type = orderType;
        takeOutOrderLineItemRequests = orderLineItems;
    }

    public static TakeOutOrderRequest create(OrderType orderType, List<TakeOutOrderLineItemRequest> orderLineItems) {
        return new TakeOutOrderRequest(orderType, orderLineItems);
    }


    public OrderType getType() {
        return type;
    }

    public List<TakeOutOrderLineItemRequest> getTakeOutOrderLineItemRequests() {
        return takeOutOrderLineItemRequests;
    }
}
