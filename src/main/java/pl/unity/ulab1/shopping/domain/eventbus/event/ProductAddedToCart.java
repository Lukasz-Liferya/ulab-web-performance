package pl.unity.ulab1.shopping.domain.eventbus.event;

import pl.unity.ulab1.shopping.domain.ProductID;
import pl.unity.ulab1.shopping.domain.ProductQuantity;

/**
 * @author lsutula
 */
public class ProductAddedToCart {
	private ProductID productID;
	private ProductQuantity productQuantity;

	public ProductAddedToCart(ProductID productID, ProductQuantity productQuantity) {
		this.productID = productID;
		this.productQuantity = productQuantity;
	}
}
