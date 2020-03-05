package pl.unity.ulab1.shopping.domain;

import java.util.UUID;

import javax.persistence.Entity;

/**
 * @author lsutula
 */
@Entity
public class Buyer {
	private long  technicalID;
	private UUID businessID;
	private String name;
	private String surname;

	public Buyer() {
	}

	public Buyer(long technicalID, UUID businessID, String name, String surname) {
		this.technicalID = technicalID;
		this.businessID = businessID;
		this.name = name;
		this.surname = surname;
	}
}
