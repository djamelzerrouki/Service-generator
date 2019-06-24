package com.djamel.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djamel.entities.Employe;
import com.djamel.repositories.RepoEmploye;
import com.djamel.security.CustomUserDetailsService;

/**
 * @author Ramesh Fadatare
 *
 */
@Controller
public class HomeController
{
//	@Autowired
//	private MessageRepository messageRepository;
	@Autowired
	RepoEmploye red; 
	
	@GetMapping("/home")
	public String home(Model model)
	{
//		model.addAttribute("msgs", messageRepository.findAll());		
		return "uploadview";
	}
//	@GetMapping("/admin")
//	public String admin(Model model)
//	{
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	     String name = auth.getName(); //get logged in username
//	    
//		Employe employe = red.findByName(name) 	
//					.orElseThrow(() -> new UsernameNotFoundException("username " + name + " not found"));
//		System.out.println("0000"+employe.getId());
// 		return "index";
//	}
//	@PostMapping("/messages")
//	public String saveMessage(Message message)
//	{
//		messageRepository.save(message);
//		return "redirect:/home";
//	}
	
	

	
	
}
