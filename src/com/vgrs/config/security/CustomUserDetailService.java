package com.vgrs.config.security;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vgrs.mgmt.account.dto.UserInfoDTO;
import com.vgrs.mgmt.dao.AccountDAO;
import com.vgrs.mgmt.dao.impl.SQLAccountDAO;

public class CustomUserDetailService implements UserDetailsService {

	private AccountDAO accountDAO;

	public CustomUserDetailService() {
		try {
			accountDAO = new SQLAccountDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserInfoDTO user = accountDAO.verifyUserInfo(username);
			if (user != null) {
				Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority(user.getRole()));
				UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);
				return userDetails;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
