package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sp.model.UserDTO;

@Controller 
public class RequestCrt {
	
	@Autowired
    UserDao userDao;


	@RequestMapping(value = { "/", "/addUser" }, method = RequestMethod.GET)
	public String index(Model model) {
		UserDTO userForm = new UserDTO();
		model.addAttribute("userForm", userForm);
		return "index";
	}
	
	@RequestMapping(value = { "/", "/addUser" }, method = RequestMethod.POST)
	public String indexPost(Model model, @ModelAttribute("userForm") UserDTO userForm) {
		userDao.addUser(userForm.getLogin(),userForm.getPwd(),userForm.getAccount(),userForm.getLastName(), userForm.getSurName());
		return "redirect:/getUsers";
	}
	
	@RequestMapping(value = {"/getUsers" }, method = RequestMethod.GET)
	public String getUsers(Model model) {
		model.addAttribute("userList",userDao.getUserList() );
		return "users";
	}

}
