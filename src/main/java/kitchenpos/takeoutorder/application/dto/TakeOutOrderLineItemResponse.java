package kitchenpos.takeoutorder.application.dto;

import java.util.UUID;

public class TakeOutOrderLineItemResponse {
    private Long seq;
    private UUID menuId;
    private long quantity;

    public TakeOutOrderLineItemResponse(Long seq, UUID menuId, long quantity) {
        this.seq = seq;
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public static TakeOutOrderLineItemResponse create(Long seq, UUID menuId, long quantity) {
        return new TakeOutOrderLineItemResponse(seq, menuId, quantity);
    }
}
