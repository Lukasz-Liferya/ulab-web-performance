package pl.unity.ulab1.shopping.infrastructure.hibernate.command;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import pl.unity.ulab1.shopping.domain.Cart;
import pl.unity.ulab1.shopping.domain.CartID;
import pl.unity.ulab1.shopping.domain.CartRepository;

/**
 * @author lsutula
 */
@Repository
public class HibernateCartRepository implements CartRepository {
	public Cart getCart(CartID cartID) {
		return null;
	}

	Optional<Cart> findCart(CartID cartID) {
		return Optional.empty();
	}

	@Override
	public Cart loadSnapshot(CartID cartID, int i) {
		return null;
	}

	@Override
	public Cart loadNewestSnapshot(CartID cartID) {
		return null;
	}
}
