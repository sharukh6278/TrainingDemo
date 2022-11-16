package org.com;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	public WelcomeController(){
		System.out.println("WelcomeController is init");
	}
	@RequestMapping("/login")
	public ModelAndView get(ModelAndView v,HttpServletRequest httpServletRequest) {
		String email=httpServletRequest.getParameter("email").toString();
		String password=httpServletRequest.getParameter("password").toString();
		v.setViewName("hello");//this will treat as helo.jsp InternalResurceiewResolver Take care of it
		v.addObject("message", "your email :"+email+" , and password : "+password);
		System.out.println("get() is executing");
		return v;
	}
	
	//ModelAndView
	//Model
	//ModelMap

}
