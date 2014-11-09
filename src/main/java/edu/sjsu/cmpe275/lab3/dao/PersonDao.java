package edu.sjsu.cmpe275.lab3.dao;

import java.util.List;

import edu.sjsu.cmpe275.lab3.forms.Person;

public interface PersonDao {

	  public boolean insertPerson(Person person);
	  public int updatePerson(Person person);
	  public int deletePerson(int Id);
	  public List<Object> findbyPersonId(int Id);
	  public int addFriendship(int id1,int id2);
	  public int removeFriendship(int id1, int id2);
}
