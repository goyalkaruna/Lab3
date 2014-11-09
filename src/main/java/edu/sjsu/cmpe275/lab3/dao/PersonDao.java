package edu.sjsu.cmpe275.lab3.dao;

import edu.sjsu.cmpe275.lab3.forms.Person;

public interface PersonDao {

	  public boolean insertPerson(Person person);
	  public int updatePerson(Person person);
	  public int deletePerson(Long Id);
	  public Person findbyPersonId(Long Id);
}
