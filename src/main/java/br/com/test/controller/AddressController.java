package br.com.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.test.domain.Address;
import br.com.test.repository.AddressRepository;
import br.com.test.service.CepService;

/**
 * A Controller to expose the Address CRUD
 * 
 * @author icastilho
 */
@RestController
@RequestMapping(value = "/address", consumes = "application/json", produces = "application/json")
public class AddressController {

	@Autowired
	private AddressRepository repo;
	@Autowired
	private CepService cepService;

	/**
	 * Find All Address
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Address> getAll() {
		return repo.findAll();
	}

	/**
	 * Find One Address by Id
	 * 
	 * @param id
	 * @return Address object in json
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Address getAddress(@PathVariable String id) {
		return repo.findOne(id);
	}

	/**
	 * Create Address
	 * 
	 * @param address
	 * @return Address object in json
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Address create(@Valid @RequestBody Address address) throws Exception {
		//Validate Cep
		Address cep = cepService.get(address.getCep());
		if (cep == null) {
			throw new Exception(CepService.CEP_INVALID);
		}

		return repo.save(address);
	}

	/**
	 * Delete Address
	 * 
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
		repo.delete(id);
	}

	/**
	 * Update Address
	 * 
	 * @param id
	 * @param address
	 * @return Address object in json
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Address update(@PathVariable String id,
			@Valid @RequestBody Address address) throws Exception {
		Address update = repo.findOne(id);
		
		//Validate Cep
		Address cep = cepService.get(address.getCep());
		if (cep == null) {
			throw new Exception(CepService.CEP_INVALID);
		}

		update.setCep(address.getCep());
		update.setCity(address.getCity());
		update.setComplement(address.getComplement());
		update.setNeighborhood(address.getNeighborhood());
		update.setNumber(address.getNumber());
		update.setState(address.getState());
		update.setStreet(address.getStreet());
		return repo.save(update);
	}

}
