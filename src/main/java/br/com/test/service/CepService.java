package br.com.test.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import br.com.test.domain.Address;

/**
 * Service to validate and search the CEP number
 * @author icastilho
 *
 */
@Service
public class CepService {
	
	public static String CEP_INVALID = "CEP invalido";
	
	public Address get(String cep) {
		cep = cep.replaceAll("[^0-9]", "");
		boolean isvalid = isValidate(cep);
		
		if(isvalid){
			return searchAddress(cep);
		}
		return null;
	}
	
	/**
	 * Search Address by CEP
	 * @param cep
	 * @return
	 */
	private Address searchAddress(String cep){
		System.out.println(cep);
		Address address = null;
		if(!cep.matches("0{8}")){
//			address = AddressService.search(cep); Call the service to search address
			address = search(cep);
			//if not find the address replace the last number and search again
			if(address==null){
				return searchAddress(replaceLastNumberToZero(cep));
			}
		}
		
		return address;
	}
	
	
	private  Address search(String cep){
		Address address = null;
		switch (cep) {
		case "01504001":
			address = new Address();
			address.setCep("01504001");
			address.setCity("São Paulo");
			address.setNeighborhood("Liberdade");
			address.setState("São Paulo");
			address.setStreet("R. Vergueiro");
			break;
		case "04117090":
			address = new Address();
			address.setCep("04117090");
			address.setCity("São Paulo");
			address.setNeighborhood("Vila Mariana");
			address.setState("São Paulo");
			address.setStreet("R. Francisco Cruz");
			break;
		case "04304000":
			address = new Address();
			address.setCep("04304000");
			address.setCity("São Paulo");
			address.setNeighborhood("Vila Monte Alegre");
			address.setState("São Paulo");
			address.setStreet("Av. Fagundes Filho");
			break;
		default:
			break;
		}
		return address;
	}
	
	/**
	 * Replace the last number different of ZERO by ZERO
	 * @param cep
	 * @return
	 */
	private String replaceLastNumberToZero(String cep){
		Pattern pattern = Pattern.compile("0");
		String[] split = pattern.split(cep);
		if(split.length == 0)
			return cep;
		
		String last = split[split.length-1];
		int index = cep.lastIndexOf(last)+last.length();
		String sub = cep.substring(0,index-1);
		return String.format("%-8s", sub).replace(' ', '0');
	}
		
	
	/**
	 * Verify if the CEP number is valid
	 * @param cep
	 * @return
	 */
	private boolean isValidate(String cep){
		boolean isvalid = false;
		 String pattern  = "\\d{8}";
        if(!cep.isEmpty()){
            if(cep.matches(pattern))
            	isvalid = true;
        }
        return isvalid;
	}
}
