package pl.unity.ulab1.shopping.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

/**
 * @author lsutula
 */
@Entity
@Getter
public class Buyer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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
