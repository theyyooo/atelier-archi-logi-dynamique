package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.model.Card;
import com.sp.model.User;

@Controller 
public class RequestCrt {
	
	@Autowired
    UserDao userDao;
	@Autowired
	CardDao cardDao;


	@RequestMapping(value = { "/", "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = { "/user/add", "/addUser" }, method = RequestMethod.GET)
	public String adduserGet(Model model) {
		User userForm = new User();
		model.addAttribute("userForm", userForm);
		return "adduser";
	}
	
	@RequestMapping(value = { "/user/add", "/addUser" }, method = RequestMethod.POST)
	public String adduserPost(Model model, @ModelAttribute("userForm") User userForm) {
		userDao.addUser(userForm.getLogin(),userForm.getPwd(),userForm.getAccount(),userForm.getLastName(), userForm.getSurName());
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = {"/user/list" }, method = RequestMethod.GET)
	public String getUsers(Model model) {
		model.addAttribute("userList",userDao.getUserList() );
		return "users";
	}
	
	@RequestMapping(value = { "/card/add", "/addCard" }, method = RequestMethod.GET)
	public String addcardGet(Model model) {
		Card cardForm = new Card();
		model.addAttribute("cardForm", cardForm);
		return "addcard";
	}
	
	@RequestMapping(value = { "/card/add", "/addCard" }, method = RequestMethod.POST)
	public String addcardPost(Model model, @ModelAttribute("cardForm") Card cardForm) {
		cardDao.addCard(cardForm.getName(),cardForm.getDescription(),cardForm.getFamily(),cardForm.getAffinity(), cardForm.getEnergy(), cardForm.getHp(), cardForm.getDefence(), cardForm.getAttack(), cardForm.getPrice());
		return "redirect:/card/list";
	}
	
	@RequestMapping(value = {"/card/list" }, method = RequestMethod.GET)
	public String getCards(Model model) {
		model.addAttribute("cardList",cardDao.getCardList() );
		return "cards";
	}

}
