package pl.unity.ulab1.shopping.domain;

/**
 * @author lsutula
 */
public interface CartRepository {
	Cart getCart(CartID cartID);
}
