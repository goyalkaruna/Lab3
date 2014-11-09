package edu.sjsu.cmpe275.lab3.service;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cmpe275.lab3.dao.JdbcAddressDao;
import edu.sjsu.cmpe275.lab3.dao.JdbcOrgDao;
import edu.sjsu.cmpe275.lab3.dao.JdbcPersonDao;
import edu.sjsu.cmpe275.lab3.forms.Address;
import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;

public class PersonService {
   
    JdbcPersonDao dao = new JdbcPersonDao();
    JdbcAddressDao addDao = new JdbcAddressDao();
    JdbcOrgDao orgDao = new JdbcOrgDao();
	
    @SuppressWarnings("unchecked")
	public Person getProfile(int userId) {
		
		List<Object> list = new ArrayList<Object>();
		list = (List<Object>) dao.findbyPersonId(userId);
		Person person = (Person) list.get(0);
		Address address =(Address)list.get(1);
		Organization org =(Organization)list.get(2);
		address= addDao.findbyAddressId(address.getAdd_id());
		org = orgDao.findbyOrgId(org.getId());
		person.setAddress(address);
		person.setOrg(org);
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
		List<Object> list = new ArrayList<Object>();
		list = (List<Object>) dao.findbyPersonId(userId);
		Person person = (Person) list.get(0);
		Address address =(Address)list.get(1);
		Organization org =(Organization)list.get(2);
		address= addDao.findbyAddressId(address.getAdd_id());
		org = orgDao.findbyOrgId(org.getId());
		person.setAddress(address);
		person.setOrg(org);
		int v1= dao.deletePerson(userId);
		int v2 = addDao.deleteAddress(org.getId());
		int v3 = orgDao.deleteOrg(address.getAdd_id());
		if (v1==200 && v2==200 && v3==200){
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
