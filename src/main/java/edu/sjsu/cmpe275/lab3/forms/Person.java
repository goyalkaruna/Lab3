package edu.sjsu.cmpe275.lab3.forms;

import java.util.List;

public class Person {
	 private int id;
	    private String firstname;
	    private String lastname;
	    private String email;
	    private String description;
	    private Address address;
	    private Organization org;
	    private List<Person> friends;
	
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public Organization getOrg() {
			return org;
		}
		public void setOrg(Organization org) {
			this.org = org;
		}
		public List<Person> getFriends() {
			return friends;
		}
		public void setFriends(List<Person> friends) {
			this.friends = friends;
		}
	    
	    
}
