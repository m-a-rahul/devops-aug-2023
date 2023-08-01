package org.tektutor;

public class BusinessLayer {

	public String getModuleDetails() {
		DataAccessLayer dal = new DataAccessLayer();
		System.out.println ( dal.getModuleDetails() );

		return "BusinessLayer";
	}

}
