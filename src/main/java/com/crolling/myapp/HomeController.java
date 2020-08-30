package com.crolling.myapp;

import java.io.IOException;

import javax.inject.Inject;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject 
	UserInfo user;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws MessagingException{
		pop3 pop = new pop3();
		List list;
		System.out.println("아이디 " + user.getId());
		try {
			list = pop3.con(user.getId(), user.getPw());
			model.addAttribute("list", list);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "main";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String view(Model model) throws MessagingException{
		pop3 pop = new pop3();
		List list;
		try {
			list = pop3.con(user.getId(), user.getPw());
			model.addAttribute("list", list);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "view2";
	}
	
}
