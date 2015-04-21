package br.com.test.domain;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
@XmlRootElement
public class Address {

	@Id
	private String id;
	@NotNull
	private String street;
	@NotNull
	private Integer number;
	private String neighborhood;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String cep;
	private String complement;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
}
