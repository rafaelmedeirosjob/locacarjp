package br.com.challenge.locacarjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.locacarjp.model.Rent;

public interface RentRepository  extends JpaRepository<Rent, Long>{

}
