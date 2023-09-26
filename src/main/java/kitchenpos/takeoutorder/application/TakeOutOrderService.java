package kitchenpos.takeoutorder.application;

import kitchenpos.takeoutorder.application.dto.OrderStatusResponse;
import kitchenpos.takeoutorder.application.dto.TakeOutOrderRequest;
import kitchenpos.takeoutorder.application.dto.TakeOutOrderResponse;

import java.util.List;
import java.util.UUID;

public interface TakeOutOrderService {
    TakeOutOrderResponse create(final TakeOutOrderRequest request);
    OrderStatusResponse accept(final UUID orderId);
    OrderStatusResponse serve(final UUID orderId);
    OrderStatusResponse complete(final UUID orderId);
    List<TakeOutOrderResponse> findAll();
}
