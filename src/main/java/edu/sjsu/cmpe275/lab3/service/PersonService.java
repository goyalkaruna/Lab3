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

	
	public void storePerson(Person pro) {
		// TODO Auto-generated method stub

		dao.insertPerson(pro);
		System.out.println("Person Stored");
	}

	
	

}
