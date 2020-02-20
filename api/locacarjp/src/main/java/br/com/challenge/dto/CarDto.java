package br.com.challenge.dto;

import br.com.challenge.locacarjp.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CarDto {

	private Long id;
	private String model;
	private String vehiclePlate;
	private double km;
	private TypeDto type;
	public CarDto(Car car) {
		super();
		this.id =  car.getId();
		this.model =  car.getModel();
		this.vehiclePlate =  car.getVehiclePlate();
		this.km = car.getKm();
		this.type = new TypeDto(car.getType());
	}
}
