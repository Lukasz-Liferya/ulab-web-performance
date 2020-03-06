package pl.unity.ulab1.shopping.application.command;

import java.util.UUID;

/**
 * @author lsutula
 */
public class GetCartCommand {
	private UUID cartID;
	private  int snapshotVersion;

	public UUID cartID() {
		return cartID;
	}


	public void setCartID(UUID cartID) {
		this.cartID = cartID;
	}

	public int snapshotVersion() {
		return snapshotVersion;
	}
}
