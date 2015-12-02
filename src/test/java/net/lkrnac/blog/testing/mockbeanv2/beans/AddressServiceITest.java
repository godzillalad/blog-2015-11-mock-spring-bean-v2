package net.lkrnac.blog.testing.mockbeanv2.beans;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.lkrnac.blog.testing.mockbeanv2.SimpleApplication;

@ActiveProfiles("AddressService-test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SimpleApplication.class)
public class AddressServiceITest {
	@Autowired
	private AddressService addressService;

	@Autowired
	private AddressDao addressDao;

	@Before 
	public void resetMock() {   
		reset(addressDao);  
	}
 
	@Test
	public void testGetAddressForUser() {
		// GIVEN
		when(addressDao.readAddress("john")).thenReturn("5 Bright Corner");

		// WHEN 
		String actualAddress = addressService.getAddressForUser("john");
  
		// THEN   
		Assert.assertEquals("5 Bright Corner", actualAddress);
	}
}
