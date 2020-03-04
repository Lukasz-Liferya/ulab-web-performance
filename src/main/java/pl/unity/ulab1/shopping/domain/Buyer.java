package pl.unity.ulab1.shopping.domain;

import java.util.UUID;

import javax.persistence.Entity;

/**
 * @author lsutula
 */
@Entity
public class Buyer {
	private long  technicalID;
	private UUID buisnessID;
	private String name;
	private String surname;

	public Buyer() {
	}

	public Buyer(long technicalID, UUID buisnessID, String name, String surname) {
		this.technicalID = technicalID;
		this.buisnessID = buisnessID;
		this.name = name;
		this.surname = surname;
	}
}
