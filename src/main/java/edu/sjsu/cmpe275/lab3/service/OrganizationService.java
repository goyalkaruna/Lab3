package edu.sjsu.cmpe275.lab3.service;

import edu.sjsu.cmpe275.lab3.dao.OrganizationDao;
import edu.sjsu.cmpe275.lab3.forms.Organization;

public class OrganizationService {
  
	OrganizationDao dao = new OrganizationDao() {
		
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
		
		public int deleteOrg(Long Id) {
			int value = dao.deleteOrg(Id);
			return value;
			
		}
	};
	
}
