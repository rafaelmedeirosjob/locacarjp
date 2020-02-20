package br.com.challenge.dto;

import br.com.challenge.locacarjp.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class ClientDto {

	private Long id;
	private String name;
	private String cpf;
	private AddressDto address;
	
	public ClientDto(Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.address = new AddressDto(client.getAddress());
	}
}
