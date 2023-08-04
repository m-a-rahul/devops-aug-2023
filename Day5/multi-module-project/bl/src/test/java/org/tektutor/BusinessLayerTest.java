package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BusinessLayerTest {
	
	@Test
	public void testGetModuleDetails() {
		BusinessLayer fe = new BusinessLayer();

		String actualResponse = fe.getModuleDetails();
		String expectedResponse = "BusinessLayer";

		assertEquals ( expectedResponse, actualResponse ); 
	}

}
