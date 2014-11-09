package edu.sjsu.cmpe275.lab3.service;

import edu.sjsu.cmpe275.lab3.dao.JdbcOrgDao;
import edu.sjsu.cmpe275.lab3.dao.OrganizationDao;
import edu.sjsu.cmpe275.lab3.forms.Organization;

public class OrganizationService {
  
	OrganizationDao dao = new JdbcOrgDao();
		
		public int updateOrg(Organization org) {
			int value= dao.updateOrg(org);
			return value;
		}
		
		public boolean insertOrg(Organization org) {
			boolean value= dao.insertOrg(org);
			return value;
		}
		
		public Organization findbyOrgId(Long Id) {
			Organization org = dao.findbyOrgId(Id);
			
			return org;
		}
		
		public Organization deleteOrg(Long Id) {
			Organization org = dao.findbyOrgId(Id);
			int value = dao.deleteOrg(Id);
			if (value == 200){
				return org;
			}else
				return null;
		}	
}
