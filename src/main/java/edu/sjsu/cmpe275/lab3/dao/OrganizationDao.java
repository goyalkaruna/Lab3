<<<<<<< HEAD
package edu.sjsu.cmpe275.lab3.dao;

import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;

public interface OrganizationDao {
   
	 public void insertOrg(Organization org);
	  public void updateOrg(Organization org);
	  public void deleteOrg(Long Id);
	  public Organization findbyOrgId(Long Id);
}
=======
package edu.sjsu.cmpe275.lab3.dao;

import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;

public interface OrganizationDao {
   
	 public boolean insertOrg(Organization org);
	  public int updateOrg(Organization org);
	  public int deleteOrg(Long Id);
	  public Organization findbyOrgId(Long Id);
}
>>>>>>> 32882d8581e2479483a8cfc19ba2853a3a1cf1c3
