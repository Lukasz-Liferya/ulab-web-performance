package pl.unity.ulab1.shopping.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author lsutula
 */
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = "SELECT c FROM Cart c WHERE c.id = ?1 AND c.version = ?2")
	Cart loadSnapshot(CartID cartID, int version);

	@Query(value = "SELECT c FROM Cart c WHERE c.id = ?1")
	Cart loadNewestSnapshot(CartID cartID);
}
