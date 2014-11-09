package edu.sjsu.cmpe275.lab3.forms;

public class Address {
	    private int Add_id;
	    private String street;
	    private String city;
	    private String state;
	    private String zip;
		
	    
	    public int getAdd_id() {
			return Add_id;
		}
		public void setAdd_id(int add_id) {
			Add_id = add_id;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
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
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
	    
}
