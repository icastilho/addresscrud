package br.com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.test.domain.Address;

public interface AddressRepository extends MongoRepository<Address, String>{

}
