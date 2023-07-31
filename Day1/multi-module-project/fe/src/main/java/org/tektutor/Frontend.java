package org.tektutor;

public class Frontend {

	public String getModuleDetails() {

		BusinessLayer bl = new BusinessLayer();
		System.out.println ( bl.getModuleDetails() );

		return "Frontend";
	}

}
