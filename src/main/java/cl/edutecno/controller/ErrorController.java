package cl.edutecno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	
	@GetMapping("/recurso-prohibido")
	public ModelAndView recursoProhibido() {
		
		ModelAndView modelAndView = new ModelAndView("/error/403");
		return modelAndView;
		
	}@GetMapping("/error")
	public ModelAndView NotFound() {
		
		ModelAndView modelAndView = new ModelAndView("/error/404");
		return modelAndView;
		
	}
}
