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

	@Override
	public Optional<Cart> findCart(CartID cartID) {
		return Optional.empty();
	}
}
