package pl.unity.ulab1.shopping.domain.eventbus.event;

import lombok.Getter;
import pl.unity.ulab1.shopping.domain.ProductID;

/**
 * @author lsutula
 */
@Getter
public class ProductAddedToCart {

	private ProductID productID;
	private int productQuantity;

	public ProductAddedToCart(ProductID productID, int productQuantity) {
		this.productID = productID;
		this.productQuantity = productQuantity;
	}

	public ProductID productID() {
		return productID;
	}

	public int productQuantity() {
		return productQuantity;
	}
}
