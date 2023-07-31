package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrontendTest {
	
	@Test
	public void testGetModuleDetails() {
		Frontend fe = new Frontend();

		String actualResponse = fe.getModuleDetails();
		String expectedResponse = "Frontend";

		assertEquals ( expectedResponse, actualResponse ); 
	}

}
