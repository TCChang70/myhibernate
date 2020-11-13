package com.mymaven;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import model.MyEmployee;

@Controller
public class EmployeeController {
     static List<MyEmployee> list = new ArrayList<MyEmployee>();
     static{
         list.add(new MyEmployee(1, "rahul", 35000f, "S.Engineer"));
        list.add(new MyEmployee(2, "aditya", 25000f, "IT Manager"));
        list.add(new MyEmployee(3, "sachin", 55000f, "Care Taker"));
     }
    @RequestMapping("/empform")
    public ModelAndView showform() {
        //command is a reserved request attribute name, now use <form> tag to show object data  
        return new ModelAndView("empform", "command", new MyEmployee());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") MyEmployee emp) {
        //write code to save emp object  
        //here, we are displaying emp object to prove emp has data  
        list.add(new MyEmployee( list.size()+1,emp.getName(),emp.getSalary(),emp.getDesignation()));
        System.out.println(emp.getName() + " " + emp.getSalary() + " " + emp.getDesignation());

        //return new ModelAndView("empform","command",emp);//will display object data  
        return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping  
    }

    @RequestMapping("/viewemp")
    public ModelAndView viewemp() {
        //write the code to get all employees from DAO  
        //here, we are writing manual code of list for easy understanding      

        return new ModelAndView("viewemp", "list", list);
    }
}
