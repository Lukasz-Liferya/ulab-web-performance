package pl.unity.ulab1.shopping.domain;

import pl.unity.ulab1.shopping.domain.eventbus.DomainEventBus;
import pl.unity.ulab1.shopping.domain.eventbus.event.ProductAddedToCart;
import pl.unity.ulab1.shopping.domain.exception.ProductLimitReachedException;

/**
 * @author lsutula
 */
public class Cart {

	private ProductQuantityLimit productQuantityLimit;


	public void addProduct(ProductID productID, int productQuantity, DomainEventBus eventBus) throws ProductLimitReachedException {
		if (this.productQuantityLimit.isLimitReached(productQuantity)){
			throw new ProductLimitReachedException();
		}

		eventBus.post(new ProductAddedToCart(productID, new ProductQuantity(productQuantity)));
	}
}
