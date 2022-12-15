package cl.edutecno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@GetMapping("/admin")
	public ModelAndView home() {
		
		ModelAndView modelAndView = new ModelAndView("admin/home-admin");
		return modelAndView;
		
		
	}

}
