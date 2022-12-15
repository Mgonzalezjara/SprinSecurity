package cl.edutecno.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.edutecno.dto.DetalleDTO;

@Controller
public class HomeController {
	
	
	@GetMapping("/user")
	public ModelAndView home(HttpSession httpSession){
		
		ModelAndView modelAndView = new ModelAndView("user/home-user");
		
		modelAndView.addObject("detalle", new DetalleDTO());
		modelAndView.addObject("valores", httpSession.getAttribute("valores"));
		return modelAndView;
		}
	
	@PostMapping("/users")
	public RedirectView home (HttpSession httpSession, @ModelAttribute DetalleDTO detalleDTO) {
		
		List<DetalleDTO> valores = new ArrayList<DetalleDTO>();
		
		if (httpSession.getAttribute("valores") != null) {
			valores.addAll((List<DetalleDTO>) httpSession.getAttribute("valores"));
			
			
			
		}
		
		valores.add(detalleDTO);
		httpSession.setAttribute("valores", valores);
		return new RedirectView ("/user");
		
		
		
		
	}
	
//	
//	@GetMapping("/")// metodo de prueba
//	public ModelAndView home(){
//		
//		ModelAndView modelAndView = new ModelAndView("user/home");
//		
//		return modelAndView;
//		
	

}
