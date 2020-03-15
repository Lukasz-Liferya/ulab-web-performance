package pl.unity.ulab1.shopping.infrastructure.hibernate;

import java.util.Optional;

import pl.unity.ulab1.shopping.domain.Cart;
import pl.unity.ulab1.shopping.domain.CartID;
import pl.unity.ulab1.shopping.domain.CartRepository;

/**
 * @author lsutula
 */
public class HibernateCartRepository implements CartRepository {
	public Cart getCart(CartID cartID) {
		return null;
	}

	@Override
	public Optional<Cart> findCart(CartID cartID) {
		return Optional.empty();
	}
}
