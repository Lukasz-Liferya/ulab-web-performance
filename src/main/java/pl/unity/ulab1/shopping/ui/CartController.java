package pl.unity.ulab1.shopping.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import pl.unity.ulab1.shopping.application.command.AddProductToCartCommand;
import pl.unity.ulab1.shopping.application.command.CartService;
import pl.unity.ulab1.shopping.application.query.CartDTO;
import pl.unity.ulab1.shopping.application.query.CartQueryService;
import pl.unity.ulab1.shopping.domain.exception.ProductLimitReachedException;
import pl.unity.ulab1.shopping.domain.sourcing.CartEventStore;
import pl.unity.ulab1.shopping.domain.sourcing.EventStream;

/**
 * @author lsutula
 */
@Controller
public class CartController {

	private CartService cartService;

	@Autowired
	private CartQueryService cartQueryService;

	//This autowired is only for presentation. We cannot do this in real systems
	@Autowired
	private CartEventStore cartEventStore;



	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping(value = "/cart/allcarts")
	public ResponseEntity<List<CartDTO>> getAllProducts(){
		return new ResponseEntity<List<CartDTO>>(cartQueryService.allCart(), HttpStatus.OK);
	}

	//We cannot expose event streams via controller. I do this only form presentation.
	@GetMapping(value = "/cart/alleventstreams")
	public ResponseEntity<List<String>> getAllEventStreams() throws JsonProcessingException {
		List<EventStream> eventStreams = cartEventStore.loadEventStreams();
		ArrayList<String> streamsList = new ArrayList<>();
		return new ResponseEntity<List<String>>(streamsList, HttpStatus.OK);
	}

	@GetMapping(value = "/cart/products")
	public ResponseEntity<String> getAllProducts(@RequestParam UUID cartID){
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@PostMapping(value = "/cart/addProduct")
	public ResponseEntity<String> addProduct(@RequestParam UUID cartID, @RequestParam UUID productID, int productQuantity, int snapshotVersion){

		AddProductToCartCommand addProductToCartCommand = new AddProductToCartCommand(cartID, productID, productQuantity, snapshotVersion);
		try {
			cartService.addProductToCart(addProductToCartCommand);
		} catch (ProductLimitReachedException e) {
			e.printStackTrace();
		}
		//DLA UPROSZCZENIA
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
