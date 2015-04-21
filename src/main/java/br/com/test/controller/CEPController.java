package br.com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.test.domain.Address;
import br.com.test.service.CepService;

/**
 * A Controller to expose the CEP search
 * @author icastilho
 *
 */
@RestController
@RequestMapping(value="/cep", consumes="application/json", produces="application/json")
public class CEPController {

	@Autowired
	private CepService service;
	
	
	/**
	 * Find CEP
	 * @param cep
	 * @return String address
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.GET,  value = "{cep}")
	public Address getAddress(@PathVariable String cep) throws Exception {
		Address address = service.get(cep);
		if (address == null) {
			throw new Exception(CepService.CEP_INVALID);
		}
		return address;
	}

	
}
