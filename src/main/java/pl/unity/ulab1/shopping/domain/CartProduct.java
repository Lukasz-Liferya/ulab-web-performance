package pl.unity.ulab1.shopping.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lsutula
 */
public class CartProduct {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

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
