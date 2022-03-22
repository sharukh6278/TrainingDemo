package com.example.demo.entity_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@Autowired
	Dao dao;
	@ResponseBody
	@RequestMapping("/save")
	public Object save() {
		Employee43 e1=new Employee43("srk");
		dao.save(e1);
		return "done";
	}
	
	
	@ResponseBody
	@RequestMapping("/remove")
	public Object remove() {
		dao.remove();
		return "done";
	}
}
