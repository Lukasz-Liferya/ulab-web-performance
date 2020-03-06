package pl.unity.ulab1.shopping.domain;

/**
 * @author lsutula
 */
public interface CartRepository {
	Cart loadSnapshot(CartID cartID, int i);
}
