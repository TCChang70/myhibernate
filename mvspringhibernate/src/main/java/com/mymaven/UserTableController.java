package com.mymaven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import model.UserTable;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Controller
public class UserTableController {
	List<UserTable> list = new ArrayList<>();

	@RequestMapping("/userform")
	public ModelAndView showform() {
		// command is a reserved request attribute name, now use <form> tag to show
		// object data
		return new ModelAndView("userform", "command", new UserTable());
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") UserTable user) {
		save2Hibernate(user);		
		list.add(user);
		return new ModelAndView("redirect:/viewuser");// will redirect to viewemp request mapping
	}

	public void save2Hibernate(UserTable u) {
		Configuration configObj = new Configuration();
		configObj.addClass(model.UserTable.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session sessionObj = null;
		// Creating Hibernate SessionFactory Instance
		try {
			sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
			sessionObj.beginTransaction();
			sessionObj.save(u);
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();

		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}

	}

	@RequestMapping("/viewuser")
	public ModelAndView viewemp() {
		// write the code to get all employees from DAO
		// here, we are writing manual code of list for easy understanding

		return new ModelAndView("viewuser", "list", list);
	}
}
