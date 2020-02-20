package br.com.challenge.locacarjp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Rent {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime rentalDate;
	private LocalDateTime rentalDue;
	private LocalDateTime returnDate = null;
	private boolean isCanceled = false;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Car car;
	public Rent(LocalDateTime rentalDate, LocalDateTime rentalDue, Client client, Car car) {
		super();
		this.rentalDate = rentalDate;
		this.rentalDue = rentalDue;
		this.client = client;
		this.car = car;
	}
	
}
