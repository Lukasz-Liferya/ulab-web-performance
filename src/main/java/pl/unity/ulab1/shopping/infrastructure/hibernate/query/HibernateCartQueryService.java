package pl.unity.ulab1.shopping.infrastructure.hibernate.query;

import java.util.UUID;

import pl.unity.ulab1.shopping.application.query.CartDTO;
import pl.unity.ulab1.shopping.application.query.CartQueryService;

/**
 * @author lsutula
 */
public class HibernateCartQueryService  implements CartQueryService {
	@Override
	public CartDTO getCart(UUID id) {
		//TODO tu dodajmey nasz ulubiony ORM DSL natywne zapytanie itp
		return null;
	}
}
