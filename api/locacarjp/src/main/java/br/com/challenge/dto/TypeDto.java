package br.com.challenge.dto;

import java.time.LocalDateTime;

import br.com.challenge.locacarjp.model.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class TypeDto {

	private Long id;
	private String fuel;
	private String type;
	private String motorPower;
	private String exchange;
	private String door;
	private String color;
	
	public TypeDto(Type Type) {
		super();
		this.id =  Type.getId();
		this.fuel =  Type.getFuel();
		this.type =  Type.getType();
		this.motorPower = Type.getMotorPower();
		this.exchange = Type.getExchange();
		this.door = Type.getDoor();
		this.color = Type.getColor();
	}
}
