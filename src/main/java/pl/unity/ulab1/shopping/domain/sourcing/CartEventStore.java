package pl.unity.ulab1.shopping.domain.sourcing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pl.unity.ulab1.shopping.domain.CartID;

/**
 * @author lsutula
 */
public interface CartEventStore extends JpaRepository<EventStream, Long> {
	//TODO add queries

	@Query("SELECT es FROM EventStream es WHERE es.id = ?1")
	EventStream loadEventStream(CartID cartID);

	@Query("SELECT es FROM EventStream es")
	EventStream loadEventStreamAfterVersion(CartID cartID, int snapshotVersion);

	@Modifying
	@Query("UPDATE EventStream es SET es.cartEvents = ?3 WHERE es.id = ?1 AND es.version = ?2")
	void appendToStream(CartID cartID, int version, List<CartEvent> events);
}
