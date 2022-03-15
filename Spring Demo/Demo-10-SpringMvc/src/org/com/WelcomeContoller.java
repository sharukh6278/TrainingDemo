package org.com;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeContoller {
	
	public WelcomeContoller() {
		System.out.println("welcome controller initilize");
	}
	@RequestMapping("/welcome1")
	public String welcome(Model model) {
		System.out.println("welcome contro");
		model.addAttribute("message", "message from welcome1");
		return "welcome";
	}
	@ResponseBody
	@RequestMapping("/w")
	public String welcome2() {
		System.out.println("welcome2 contro");
		return "index";
	}
	@RequestMapping(value="/welcome2")
    public ModelAndView test(HttpServletResponse response) throws IOException{
		System.out.println("test");
        ModelAndView mav = new ModelAndView("welcome","message","Welcome To Spring");
        return mav;
    }
		@RequestMapping("/hello")
	   public String printHello(ModelMap map) {
			map.addAttribute("message", "Hello Spring MVC Framework!");
	      System.out.println("Hello");
	      return "welcome";
	   }

}
