package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
	
	@Test
	public void testGetModuleDetails() {
		Main fe = new Main();

		String actualResponse = fe.getModuleDetails();
		String expectedResponse = "Main";

		assertEquals ( expectedResponse, actualResponse ); 
	}

}
