package com.vgrs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vgrs.mgmt.account.dto.UserInfoDTO;

@Controller
public class AccountController {

	@RequestMapping("account/login")
	public String fetchLoginPage() {
		return "loginView";
	}
	
	@ResponseBody
	@RequestMapping(value="account/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody UserInfoDTO userInfo) {
		System.out.println(userInfo);
		return "{ \"success\" : true }";
	}
	
	@RequestMapping(value="account/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
}