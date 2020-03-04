package pl.unity.ulab1.shopping.domain;

/**
 * @author lsutula
 */
public class ProductQuantity {
	private int value;

	public ProductQuantity() {
		this.value = 0;
	}

	public ProductQuantity(int quantity) {
		this.value = quantity;
	}

	public ProductQuantity addProductQuantity(int quantity){
		return new ProductQuantity(this.value + quantity);
	}

}
