package cl.edutecno.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DefaultController {

	@GetMapping("/default")// metodo de prueba
	public ModelAndView defaultAfterLogin(HttpServletRequest request){
		
		if (request.isUserInRole("ADMIN")) {
			return  new ModelAndView ("redirect:/admin/"); //Tambien puede ser por RedirectView
			
			
		}
		
		return new ModelAndView ("redirect:/user/");
		
		
		
		
	}

}
