package pl.unity.ulab1.shopping.domain.eventbus.event;

import lombok.Getter;
import pl.unity.ulab1.shopping.domain.Buyer;
import pl.unity.ulab1.shopping.domain.ProductQuantityLimit;

/**
 * @author lsutula
 */
@Getter
public class CartCreatedEvent {
	private ProductQuantityLimit productQuantityLimit;
	private	Buyer buyer;
	private int snapshotVersion;

	public CartCreatedEvent() {
	}

	public CartCreatedEvent(ProductQuantityLimit productQuantityLimit, Buyer buyer, int snapshotVersion) {
		this.productQuantityLimit = productQuantityLimit;
		this.buyer  = buyer;
		this.snapshotVersion = snapshotVersion;
	}
}
