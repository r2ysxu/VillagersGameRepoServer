package com.vgrs.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vgrs.dao.AccountDAO;
import com.vgrs.mgmt.account.dto.UserInfoDTO;

@Controller
public class AccountController {

	@Autowired
	private AccountDAO accountDAO;

	@RequestMapping("account/login")
	public String fetchLoginPage(@RequestParam("error") String error, Model model) {
		model.addAttribute("errorMessage", "Invalid Username/password");
		return "loginView";
	}

	@ResponseBody
	@RequestMapping(value = "account/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody UserInfoDTO userInfo) {
		System.out.println(userInfo);
		try {
			if (accountDAO.registerUser(userInfo)) {
				return "{ \"success\" : true }";
			} else {
				return "{ \"success\": false, \"message\": \"Username already taken\"}";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "{ \"success\": false, \"message\" : \"Unable to register user\" }";
	}

	@ResponseBody
	@RequestMapping(value = "")
	public String checkUserExist(@QueryParam("username") String username) {
		try {
			if (accountDAO.userExists(username))
				return "";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value = "account/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	private String generateSimpleSuccessJSON(boolean success, String message) {
		return null;
	}
}