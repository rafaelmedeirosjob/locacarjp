package br.com.challenge.locacarjp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Car {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private String vehiclePlate;
	private double km;
	
	@OneToOne
	private Type type;
	public Car(String model, String vehiclePlate,double km, Type type) {
		super();
		this.model = model;
		this.vehiclePlate = vehiclePlate;
		this.km = km;
		this.type = type;
	}
	
}
