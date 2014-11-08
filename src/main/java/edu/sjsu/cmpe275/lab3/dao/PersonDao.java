package edu.sjsu.cmpe275.lab3.dao;

import edu.sjsu.cmpe275.lab3.forms.Person;

public interface PersonDao {

	  public void insertPerson(Person person);
	  public void updatePerson(Person person);
	  public void deletePerson(Long Id);
	  public Person findbyPersonId(Long Id);
}
