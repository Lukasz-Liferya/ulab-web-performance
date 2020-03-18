package pl.unity.ulab1.shopping.application.query;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.unity.ulab1.shopping.domain.Cart;

/**
 * @author lsutula
	*/
public interface CartQueryService extends JpaRepository<Cart, Long> {

	@Query("SELECT new pl.unity.ulab1.shopping.application.query.CartDTO(c.id.value) FROM Cart c WHERE c.id = ?1")
	CartDTO getCart(UUID id);

	@Query("SELECT new pl.unity.ulab1.shopping.application.query.CartDTO(c.id.value) FROM Cart c")
	List <CartDTO> allCart();
}
