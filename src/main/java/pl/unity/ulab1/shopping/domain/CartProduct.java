package pl.unity.ulab1.shopping.domain;

import javax.persistence.Entity;

/**
 * @author lsutula
 */
@Entity
class CartProduct {
	private ProductID productID;
	private int quantity;

	public CartProduct(ProductID productID, int quantity) {
		assert quantity > 0;
		assert productID !=null;

		this.productID = productID;
		this.quantity = quantity;
	}

	public boolean isProductIDEquals(ProductID productID){
		return this.productID.equals(productID);
	}

	public void addQuantity(int quantity){
		this.quantity =+ quantity;
	}
}
