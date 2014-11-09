package edu.sjsu.cmpe275.lab3.service;

import edu.sjsu.cmpe275.lab3.dao.JdbcAddressDao;
import edu.sjsu.cmpe275.lab3.dao.JdbcOrgDao;
import edu.sjsu.cmpe275.lab3.dao.JdbcPersonDao;
import edu.sjsu.cmpe275.lab3.forms.Address;
import edu.sjsu.cmpe275.lab3.forms.Person;

public class PersonService {
   
    JdbcPersonDao dao = new JdbcPersonDao();
    JdbcAddressDao addDao = new JdbcAddressDao();
    JdbcOrgDao orgDao = new JdbcOrgDao();
	public Person getProfile(int userId) {
		
		Person person = dao.findbyPersonId(userId);
		
		if(person==null){return null;}
		else{return person;}
	}

	
	public boolean storePerson(Person pro) {
        boolean success = false;
		boolean value = dao.insertPerson(pro);
		boolean addValue =addDao.insertAddress(pro.getAddress());
		boolean orgValue = orgDao.insertOrg(pro.getOrg());
		System.out.println("Person Stored");
		if (value==true && addValue==true && orgValue==true){
			success = true;
		}else
			success = false;
		return success;
		
	}

	public Person deletePerson(int userId){
		Person person = dao.findbyPersonId(userId);
		int v= dao.deletePerson(userId);
		if (v==200){
			return person;}
			else
				return null;	
	}
	
   public int updatePerson(Person person){
	  int value= dao.updatePerson(person);
	  return value;
   }
   
   public int addFriendship(int id1, int id2){
	   
	   
	   
	   return 404;
   }
}
