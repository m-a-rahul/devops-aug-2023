package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class DataAccessLayerTest {
	
	@Test
	public void testGetModuleDetails() {
		DataAccessLayer fe = new DataAccessLayer();

		String actualResponse = fe.getModuleDetails();
		String expectedResponse = "DataAccessLayer";

		assertEquals ( expectedResponse, actualResponse ); 
	}

}
