package pl.unity.ulab1.shopping.application.command;

import java.util.UUID;

import pl.unity.ulab1.shopping.domain.Buyer;

/**
 * @author lsutula
 */
public class AddProductToCartCommand {
	private UUID cartID;
	private UUID productID;
	private int productQuantity;
	private int snapshotVersion;
	private Buyer buyer;

	public AddProductToCartCommand(UUID cartID, UUID productID, int productQuantity, int snapshotVersion) {
		this.cartID = cartID;
		this.productID = productID;
		this.productQuantity = productQuantity;
		this.snapshotVersion = snapshotVersion;
	}

	public int snapshotVersion() {
		return snapshotVersion;
	}

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

	public Buyer buyer() {
		return buyer;
	}
}
