package br.com.challenge.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.challenge.locacarjp.model.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RentDto {
	
	private Long id;
	private LocalDateTime rentalDate;
	private LocalDateTime rentalDue;
	private LocalDateTime returnDate;
	private double value;
	private ClientDto client;
	private CarDto car;
	
	public static Page<RentDto> converter(Page<Rent> rents) {
		return rents.map(RentDto::new);
	}


	public RentDto(Rent rent) {
		this.id = rent.getId();
		this.rentalDate = rent.getRentalDate();
		this.rentalDue = rent.getRentalDue();
		this.value = rent.getValue();
		this.client = new ClientDto(rent.getClient()); 
		this.car = new CarDto(rent.getCar());
	}
}
