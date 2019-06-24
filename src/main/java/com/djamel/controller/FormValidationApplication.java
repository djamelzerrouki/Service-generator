package com.djamel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.djamel.entities.Service;
import com.djamel.repositories.RepoService;

 
@Controller
public class FormValidationApplication {
@Autowired 
RepoService repoService;





	
	
//################################## Get SERVICE ##################################""
@GetMapping("/Services")
public String showPage(Model model, @RequestParam(defaultValue = "0") int page){
	model.addAttribute("data", repoService.
			findAll(new PageRequest(page, 4)));
	model.addAttribute("currentPage", page);
 
	return "addservice";
	
	
}
	//################################## Save SERVICE ##################################""

	@RequestMapping(value="/updateService" ,method=RequestMethod.POST)
	public String saveEnploye(Model model, @Valid Service service, BindingResult result) {
		if (result.hasErrors()) return "redirect:Service";
		else {
 			repoService.save(service);
			return "redirect:Service";
			}
	}
	@GetMapping("/register")
	public String showForm(Model model,Service service) {

		model.addAttribute("reposervice", repoService.findAll());
 
		return "registerService";
	}
 

	@PostMapping("/saveService")
	public String addService(Model model,@ModelAttribute("service")  @Valid Service service, BindingResult result) {
		if (repoService.findByName(service.getName()).isPresent()) {
			result .rejectValue("name", "error.employe",
					"Nom de service déjà existé choisis d'autre nom !");
		}

		if (result.hasErrors()) {
		 
			return "registerService";

		}
		//else is not required here. If there are errors, it is returned before reaching here anyways.
		else {
 			repoService.save(service);
			model.addAttribute("message", "Registration successfully...");
			return "redirect:Services";}
	}

	//################################## Delete Service ##################################""

	@GetMapping("/deleteService")
	public String deleteEmploye(Integer id){
		repoService.deleteById(id); 
		return "redirect:Service";
	}
 
}
 