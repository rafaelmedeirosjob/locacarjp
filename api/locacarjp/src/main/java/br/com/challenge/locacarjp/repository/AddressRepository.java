package br.com.challenge.locacarjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.locacarjp.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
