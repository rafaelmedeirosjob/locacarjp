package br.com.challenge.locacarjp.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.challenge.locacarjp.model.Address;
import br.com.challenge.locacarjp.model.Rent;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateRentRequest {

	//Rent
	@NotNull @NotEmpty
	private String rentalDate;
	@NotNull @NotEmpty
	private String rentalDue;
	@NotNull @NotEmpty
	private String value;
	
	//Client
	@NotNull @NotEmpty
	private String nameClient;
	@NotNull @NotEmpty
	private String cpf;
	
	//Address
	@NotNull @NotEmpty
	private String street;
	@NotNull @NotEmpty
	private String number;
	@NotNull @NotEmpty
	private String city;
	
	//Car
	@NotNull @NotEmpty
	private String model;
	@NotNull @NotEmpty
	private String vehiclePlate;
	@NotNull @NotEmpty 
	private String km;
	
	//Type
	@NotNull @NotEmpty
	private String fuel;
	@NotNull @NotEmpty
	private String type;
	@NotNull @NotEmpty
	private String motorPower;
	@NotNull @NotEmpty
	private String exchange;
	@NotNull @NotEmpty
	private String door;
	@NotNull @NotEmpty
	private String color;
}
