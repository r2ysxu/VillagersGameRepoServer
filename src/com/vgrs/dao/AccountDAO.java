package com.vgrs.dao;

import java.sql.SQLException;

import com.vgrs.mgmt.account.dto.UserInfoDTO;

public interface AccountDAO {
	public boolean registerUser(UserInfoDTO userInfo) throws SQLException;
	
	public UserInfoDTO verifyUserInfo(String username) throws SQLException;
	
	public boolean userExists(String username) throws SQLException;
}
