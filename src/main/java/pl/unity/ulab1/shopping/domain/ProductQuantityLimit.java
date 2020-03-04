package pl.unity.ulab1.shopping.domain;

/**
 * @author lsutula
 */
public class ProductQuantityLimit {
	private int value;
	private int limit = 100;

	public ProductQuantityLimit() {
		this.value = 0;
	}

	private ProductQuantityLimit(int i) {
		this.value = 0;
	}

	public ProductQuantityLimit addProductQuantity(int quantity){
		return new ProductQuantityLimit(this.value + quantity);
	}

	public boolean isLimitReached(int productQuantity) {
		return this.value + productQuantity > limit;
	}
}
