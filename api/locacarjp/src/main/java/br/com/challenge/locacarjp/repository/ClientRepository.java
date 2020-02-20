package br.com.challenge.locacarjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.locacarjp.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
