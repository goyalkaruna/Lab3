package edu.sjsu.cmpe275.lab3.service;

import edu.sjsu.cmpe275.lab3.dao.JdbcPersonDao;
import edu.sjsu.cmpe275.lab3.forms.Person;

public class PersonService {
   
    JdbcPersonDao dao = new JdbcPersonDao();
    
	public Person getProfile(Long userId) {
		// TODO Auto-generated method stub
		Person person = dao.findbyPersonId(userId);
		if(person==null){return null;}
		else{return person;}
	}

	
	public boolean storePerson(Person pro) {
		// TODO Auto-generated method stub

		boolean value = dao.insertPerson(pro);
		System.out.println("Person Stored");
		return value;
	}

	public int deletePerson(Long userId){
		int v = dao.deletePerson(userId);
		return v;
	}
	
   public int updatePerson(Person person){
	  int value= dao.updatePerson(person);
	  return value;
   }
}
