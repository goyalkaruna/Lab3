package edu.sjsu.cmpe275.lab3.dao;

import edu.sjsu.cmpe275.lab3.forms.Address;


public interface AddressDao {

	
	  public boolean insertAddress(Address address);
	  public int updateAddress(Address address);
	  public int deleteAddress( int Id);
	  public Address findbyAddressId(int Id);
}
