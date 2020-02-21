package br.com.challenge.locacarjp.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.locacarjp.model.Rent;

public interface RentRepository  extends JpaRepository<Rent, Long>{
	Page<Rent> findByRentalDateBeforeAndIsCanceledFalseAndReturnDateIsNull(LocalDateTime local, Pageable page);
	Page<Rent> findByRentalDateAfterAndIsCanceledFalse(LocalDateTime local, Pageable page);
}
