package kitchenpos.takeoutorder.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class TakeOutOrderLineItemRequest {
    private long quantity;
    private UUID menuId;
    private BigDecimal price;

    public TakeOutOrderLineItemRequest(long quantity, UUID menuId, BigDecimal price) {
        this.quantity = quantity;
        this.menuId = menuId;
        this.price = price;
    }

    public static TakeOutOrderLineItemRequest create(long quantity, UUID menuId, long price) {
        return new TakeOutOrderLineItemRequest(quantity, menuId, BigDecimal.valueOf(price));
    }

    public long getQuantity() {
        return quantity;
    }

    public UUID getMenuId() {
        return menuId;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
