package edu.sjsu.cmpe275.lab3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import edu.sjsu.cmpe275.lab3.dao.JdbcOrgDao;
import edu.sjsu.cmpe275.lab3.dao.JdbcPersonDao;
import edu.sjsu.cmpe275.lab3.dao.OrganizationDao;
import edu.sjsu.cmpe275.lab3.dao.PersonDao;
import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;
import edu.sjsu.cmpe275.lab3.service.OrganizationService;
import edu.sjsu.cmpe275.lab3.service.PersonService;

@Controller
@RequestMapping("/")
public class AllController {

	PersonDao pd = new JdbcPersonDao();
	OrganizationDao od = new JdbcOrgDao();
	OrganizationService os;
	PersonService ps;
	
	@Autowired
	public AllController(OrganizationService os, PersonService ps){
		
		this.os = os;
		this.ps = ps;
	}
	
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public String getPerson(@PathVariable("id") String id, Model model){
		
		Person person = pd.findbyPersonId(Long.parseLong(id));
		if(person != null){
			
			model.addAttribute("person", person);
			return "person";
		}
		else{
			
			return "404";
		}
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String createPerson(@ModelAttribute Person person, Model model){
		
		boolean tmp = pd.insertPerson(person);
		if(tmp){
			
			model.addAttribute("person", person);
			return "person";
		}

		else{return "400";}
	}
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute Person person, @PathVariable("id") String id, Model model){
		
		int tmp = pd.updatePerson(person);
		
		if(tmp == 200){
			
			model.addAttribute("person", person);
			return "person";
		}
		else if(tmp == 400){
			
			return "400";
		}
		else{return "404";}
	}
	
	@RequestMapping(value = "/person/{id}",  method = RequestMethod.DELETE)
	   public String deleteOnePerson(@PathVariable("id") String id, Model model){
		
		Person tmp = pd.deletePerson(Long.parseLong(id));
		if(tmp != null){
			
			model.addAttribute("person", tmp);
			return "person";
		}
		else{
			
			return "404";
		}
	}
	
	
	
	@RequestMapping(value = "/org/{id}", method = RequestMethod.GET)
	public String getOrg(@PathVariable("id") String id, Model model){
		
		Organization tmp = od.findbyOrgId(Long.parseLong(id));
		if(tmp != null){
			
			model.addAttribute("org", tmp);
			return "org";
		}
		else{return "404";}
	}
	
	@RequestMapping(value = "/org", method = RequestMethod.POST)
	public String createOrg(@ModelAttribute Organization org, Model model){
		
		boolean tmp = od.insertOrg(org);
		if(tmp){
			
			model.addAttribute("org", org);
			return "org";
		}
		else{return "400";}
	}
	
	@RequestMapping(value = "/org/{id}", method = RequestMethod.POST)
	public String updateOrg(@ModelAttribute Organization org, @PathVariable("id") String id, Model model){
		
		int tmp = od.updateOrg(org);
		
		if(tmp == 200){
			
			model.addAttribute("org", org);
			return "org";
		}
		else if(tmp == 400){
			
			return "400";
		}
		else{return "404";}
	}
	
	@RequestMapping(value = "/org/{id}",  method = RequestMethod.DELETE)
	   public String deleteOneOrg(@PathVariable("id") String id, Model model){
		
		int tmp = od.deleteOrg(Long.parseLong(id));
		
		if(tmp == 200){
			
			Organization o = od.findbyOrgId(Long.parseLong(id));
			model.addAttribute("org", o);
			return "org";
		}
		else if(tmp == 400){return "400";}
		else{return "404";}
	}
	
	@RequestMapping(value = "/friend/{id1}/{id2}",  method = RequestMethod.PUT)
	public String addFriend(@PathVariable("id1") String id1, @PathVariable("id2") String id2, Model model){
		
		
	}
	
	@RequestMapping(value = "/friend/{id1}/{id2}",  method = RequestMethod.DELETE)
	public String rmFriend(@PathVariable("id1") String id1, @PathVariable("id2") String id2, Model model){
		
		
	}
}
