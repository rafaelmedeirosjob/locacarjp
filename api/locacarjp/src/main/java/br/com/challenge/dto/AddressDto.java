package br.com.challenge.dto;

import java.time.LocalDateTime;

import br.com.challenge.locacarjp.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AddressDto {

	private Long id;
	private String street;
	private int number;
	private String city;
	
	public AddressDto(Address address) {
		super();
		this.id =  address.getId();
		this.street =  address.getStreet();
		this.number =  address.getNumber();
		this.city = address.getCity();;
	}
}
