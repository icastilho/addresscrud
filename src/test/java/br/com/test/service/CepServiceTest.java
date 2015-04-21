package br.com.test.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.test.domain.Address;

public class CepServiceTest {

	CepService service;
	
	@Before
	public void setUp(){
		service = new CepService();
	}
	
	public void testVergueiro() {
		Address result = service.get("01504001");
		Assert.assertNotNull(result);
		Assert.assertEquals("R. Vergueiro", result.getStreet());
	}
	

	@Test
	public void testInvalidLenthLarge() {
		Address result = service.get("043045614");
		Assert.assertNull(result);
	}
	@Test
	public void testInvalidLenthLess() {
		Address result = service.get("04304");
		Assert.assertNull(result);
	}
	
	@Test
	public void testFagundes() {
		Address result = service.get("04304000");
		Assert.assertNotNull(result);
		Assert.assertEquals("Av. Fagundes Filho", result.getStreet());
	}
	
	@Test
	public void testFagundesoCep1() {
		Address result = service.get("04304021");
		Assert.assertNotNull(result);
		Assert.assertEquals("Av. Fagundes Filho", result.getStreet());
	}
	@Test
	public void testFagundesCep2() {
		Address result = service.get("04304321");
		Assert.assertNotNull(result);
	}
}
