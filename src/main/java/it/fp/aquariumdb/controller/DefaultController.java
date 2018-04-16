package it.fp.aquariumdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.fp.aquariumdb.model.Fish;
import it.fp.aquariumdb.model.Image;
import it.fp.aquariumdb.repository.FishRepository;
import it.fp.aquariumdb.repository.ImageRepository;
import it.fp.aquariumdb.repository.RoleRepository;
import it.fp.aquariumdb.repository.UserRepository;

@Controller
public class DefaultController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private FishRepository fishRepo;
	
	@Autowired
	ImageRepository imageRepo;
	
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String index(Model model) {
    
        return "home";
    }
    
    @RequestMapping(value = { "/fishes" }, method = RequestMethod.GET)
    public String fishes(Model model) {
    	List<Fish> fishes = fishRepo.findAll();
    	model.addAttribute("fishes", fishes);
        return "search";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    @PostMapping("/async/getimage")
    //@RequestMapping(value = "/async/getimage", method = RequestMethod.GET)

    public void getImage() {
    	System.out.println("*******");
    	Image img = imageRepo.findByTableNameAndPkeyValue("fish", 1);
    	System.out.println(img.getName());
    }
    

}
