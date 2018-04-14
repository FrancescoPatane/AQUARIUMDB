package it.fp.aquariumdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.fp.aquariumdb.model.Fish;
import it.fp.aquariumdb.repository.FishRepository;
import it.fp.aquariumdb.repository.RoleRepository;
import it.fp.aquariumdb.repository.UserRepository;

@Controller
public class DefaultController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private FishRepository fishRepo;
	
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String index(Model model) {
    
        return "home";
    }
    
    @RequestMapping(value = { "/fishes" }, method = RequestMethod.GET)
    public String fishes(Model model) {
    	List<Fish> f = fishRepo.findAll();
    	System.out.println(f);
        return "home";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

}
