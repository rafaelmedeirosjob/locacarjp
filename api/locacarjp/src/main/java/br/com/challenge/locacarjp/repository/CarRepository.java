package br.com.challenge.locacarjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.locacarjp.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
