package pl.unity.ulab1.shopping.domain;

import java.util.Optional;

/**
 * @author lsutula
 */
public interface CartRepository {
	Cart getCart(CartID cartID);

	Optional<Cart> findCart(CartID cartID);
}
