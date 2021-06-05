package com.example.cntr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.dto.User;
import com.example.service.UserService;
import com.example.valid.UserValidator;
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	
	@RequestMapping(value = "/login_form.htm",method = RequestMethod.GET)
	public String loginForm(ModelMap model) {
		model.put("user", new User());
		return "login_form";
	}
	
	@RequestMapping(value = "/reg_form.htm",method = RequestMethod.GET)
	public String registrationForm(ModelMap model) {
		model.put("user", new User());
		return "registration_form";
	}
	
	@RequestMapping(value = "/register.htm",method = RequestMethod.POST)
	public String register(User user, ModelMap model) {
		userService.addUser(user);
		model.put("user", new User());
		return "login_form";
	}
	
	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String login(User user,BindingResult result,ModelMap model,HttpSession session) {
		
		
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "login_form";
		}
		
		boolean flag = userService.checkUser(user);
		if(flag) {
			session.setAttribute("user", user); 
			System.out.println("userid =================== "+user.getUserId());
			return "home";
		}
		model.put("user", user);
		return "login_form";
	}
	
	@RequestMapping(value = "/home.htm",method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "home";
	}
	
	@RequestMapping(value = "/upload_profile_pic.htm",method = RequestMethod.POST)
	public String profileUpdate(@RequestParam CommonsMultipartFile profilePic, ModelMap model, HttpServletRequest request, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		int userId = user.getUserId();
		
		try {
			Path path = Paths.get(request.getServletContext().getRealPath("/images"));
			if(!Files.exists(path)) {
				Files.createDirectory(path);
			}
			String fileName = profilePic.getOriginalFilename();
			fileName = fileName.substring(fileName.lastIndexOf('.')); 
			path = path.resolve(path+"\\"+userId+fileName);
			System.out.println(path.toString());
			Files.copy(profilePic.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return "home";
	}
	
	@RequestMapping(value = "/logout.htm",method = RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) {
		model.remove("user");
		session.removeAttribute("user");
		session.invalidate();
		model.put("user", new User());
		return "login_form";
	}
}
