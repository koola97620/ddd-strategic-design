package kitchenpos.takeoutorder.ui;


import kitchenpos.takeoutorder.application.TakeOutOrderService;
import kitchenpos.takeoutorder.application.dto.OrderStatusResponse;
import kitchenpos.takeoutorder.application.dto.TakeOutOrderRequest;
import kitchenpos.takeoutorder.application.dto.TakeOutOrderResponse;
import kitchenpos.takeoutorder.infra.TakeOutOrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/orders/takeout")
@RestController
public class TakeOutOrderRestController {
    private final TakeOutOrderService orderService;

    public TakeOutOrderRestController(final TakeOutOrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<TakeOutOrderResponse> create(@RequestBody final TakeOutOrderRequest request) {
        final TakeOutOrderResponse response = orderService.create(request);
        return ResponseEntity.created(URI.create("/api/orders/" + response.getId()))
                .body(response);
    }

    @PutMapping("/{orderId}/accept")
    public ResponseEntity<OrderStatusResponse> accept(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(orderService.accept(orderId));
    }

    @PutMapping("/{orderId}/serve")
    public ResponseEntity<OrderStatusResponse> serve(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(orderService.serve(orderId));
    }

    @PutMapping("/{orderId}/complete")
    public ResponseEntity<OrderStatusResponse> complete(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(orderService.complete(orderId));
    }

    @GetMapping
    public ResponseEntity<List<TakeOutOrderResponse>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }
}
