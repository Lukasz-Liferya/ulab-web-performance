package pl.unity.ulab1.shopping.infrastructure.hibernate.query;

import java.util.UUID;

import org.springframework.stereotype.Service;

import pl.unity.ulab1.shopping.application.query.CartDTO;
import pl.unity.ulab1.shopping.application.query.CartQueryService;

/**
 * @author lsutula
 */
@Service
public class HibernateCartQueryService  implements CartQueryService {
	@Override
	public CartDTO getCart(UUID id) {
		//TODO tu dodajmey nasz ulubiony ORM DSL natywne zapytanie itp
		return null;
	}
}
