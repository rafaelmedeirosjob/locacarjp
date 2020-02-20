package br.com.challenge.locacarjp.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.challenge.dto.RentDto;
import br.com.challenge.locacarjp.model.Address;
import br.com.challenge.locacarjp.model.Car;
import br.com.challenge.locacarjp.model.Client;
import br.com.challenge.locacarjp.model.Rent;
import br.com.challenge.locacarjp.model.Type;
import br.com.challenge.locacarjp.repository.AddressRepository;
import br.com.challenge.locacarjp.repository.CarRepository;
import br.com.challenge.locacarjp.repository.ClientRepository;
import br.com.challenge.locacarjp.repository.RentRepository;
import br.com.challenge.locacarjp.repository.TypeRepository;
import br.com.challenge.locacarjp.request.CreateRentRequest;

@RestController
@RequestMapping("/rents")
public class RentController {
	@Autowired
	private RentRepository rentRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private ClientRepository clientRepository;

	//usando paginação
	@GetMapping
	public ResponseEntity<Page<RentDto>> list(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		Page<Rent> rents = rentRepository.findAll(paginacao);
			return ResponseEntity.ok().body(RentDto.converter(rents));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<RentDto> create(@RequestBody @Valid CreateRentRequest request, UriComponentsBuilder uriBuilder) {
		Address address = new Address(request.getStreet(),request.getNumber(), request.getCity());
		addressRepository.save(address);
		Client client = new Client(request.getNameClient(),request.getCpf(), address);
		clientRepository.save(client);
		Type type = new Type(request.getFuel(), request.getType(), request.getMotorPower(), request.getExchange(), request.getDoor(), request.getColor());
		typeRepository.save(type);
		Car car = new Car(request.getModel(), request.getVehiclePlate(),request.getKm(),type);
		carRepository.save(car);
		Rent rent = new Rent(request.getRentalDate(),request.getRentalDue(),client,car);
		rentRepository.save(rent);
		URI uri = uriBuilder.path("/rents/{id}").buildAndExpand(rent.getId()).toUri();
		return ResponseEntity.created(uri).body(new RentDto(rent));
	}
	
	@PutMapping("cancelled/{id}")
	@Transactional
	public ResponseEntity<String> cancel(@PathVariable Long id){
		Optional<Rent> optional = rentRepository.findById(id);
		if(optional.isPresent()) {
			Rent rent = rentRepository.getOne(id);
			rent.setCanceled(true);
			return ResponseEntity.ok("Reserva cancelada com sucesso");
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PutMapping("devolution/{id}")
	@Transactional
	public ResponseEntity<String> devolution(@PathVariable Long id){
		Optional<Rent> optional = rentRepository.findById(id);
		if(optional.isPresent()) {
			Rent rent = rentRepository.getOne(id);
			rent.setCanceled(true);
			rent.setReturnDate(LocalDateTime.now());
			return ResponseEntity.ok("Carro devolvido com sucesso");
		}
		return ResponseEntity.notFound().build();	
	}
	
}
