package com.vgrs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.vgrs.dao.AccountDAO;
import com.vgrs.dao.SQLConnector;
import com.vgrs.mgmt.account.dto.UserInfoDTO;

public class SQLAccountDAO implements AccountDAO {

	private Connection conn;
	private PreparedStatement createUserPs, queryUserPs;

	public SQLAccountDAO() throws SQLException {
		conn = SQLConnector.connect();
		generateStaticPreparedStatements();
	}

	private void generateStaticPreparedStatements() throws SQLException {
		createUserPs = conn.prepareStatement("INSERT OR IGNORE INTO Users VALUES (NULL, ?, ?, ?, ?, 'ROLE_USER', 0, 'ACTIVE', ?)");
		queryUserPs = conn.prepareStatement("SELECT users.id, users.password, users.email, users.name, users.role, users.status "
				+ "FROM Users WHERE users.username = ?");
	}

	@Override
	public boolean registerUser(UserInfoDTO userInfo) throws SQLException {
		createUserPs.setString(1, userInfo.getUsername());
		createUserPs.setString(2, userInfo.getPassword());
		createUserPs.setString(3, userInfo.getName());
		createUserPs.setString(4, userInfo.getEmail());
		createUserPs.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

		return createUserPs.executeUpdate() > 0;
	}

	@Override
	public UserInfoDTO verifyUserInfo(String username) throws SQLException {
		queryUserPs.setString(1, username);

		ResultSet rs = queryUserPs.executeQuery();
		if (rs.next()) {
			return new UserInfoDTO(username, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		}
		return null;
	}

	@Override
	public boolean userExists(String username) throws SQLException {
		queryUserPs.setString(1, username);
		return queryUserPs.executeQuery().next();
	}
}