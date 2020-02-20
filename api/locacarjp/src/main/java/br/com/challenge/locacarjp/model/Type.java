package br.com.challenge.locacarjp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Type {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fuel;
	private String type;
	private String motorPower;
	private String exchange;
	private String door;
	private String color;
	public Type(String fuel, String type, String motorPower, String exchange, String door, String color) {
		super();
		this.fuel = fuel;
		this.type = type;
		this.motorPower = motorPower;
		this.exchange = exchange;
		this.door = door;
		this.color = color;
	}
	
}
