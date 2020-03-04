package pl.unity.ulab1.shopping.application;

import java.util.UUID;

/**
 * @author lsutula
 */
public class AddProductToCartCommand {
	private UUID cartID;
	private UUID productID;
	private int productQuantity;

	public UUID cartID() {
		return cartID;
	}

	public void setCartID(UUID cartID) {
		this.cartID = cartID;
	}

	public UUID productID() {
		return productID;
	}

	public void setProductID(UUID productID) {
		this.productID = productID;
	}

	public int productQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
