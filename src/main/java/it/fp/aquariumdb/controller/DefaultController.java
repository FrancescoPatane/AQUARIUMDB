package it.fp.aquariumdb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.fp.aquariumdb.model.Fish;
import it.fp.aquariumdb.model.Image;
import it.fp.aquariumdb.repository.FishRepository;
import it.fp.aquariumdb.repository.ImageRepository;
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
		File file = new File("new.txt");
		try {
			file.createNewFile();
			System.out.println(file.getAbsolutePath());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@ResponseBody
	@GetMapping("/async/getimage")
	public String getImage(@RequestParam("fishId") String fishId) {
		System.out.println("*******");
		Long id = Long.valueOf(fishId);
		Image img = imageRepo.findByTableNameAndPkeyValueAndIsMainImage("fish", id, Boolean.TRUE);
		String path;
		if (img != null)
			path = img.getImagePath();
		else
			path = "/img/no-image-found.jpg";
		return path;
	}


}
