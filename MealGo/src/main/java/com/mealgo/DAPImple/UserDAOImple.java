package com.mealgo.DAPImple;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mealgo.DAO.UserDAO;
import com.mealgo.Model.User;
import com.mealgo.Utility.DBConnection;

public class UserDAOImple implements UserDAO {

	private static final String INSERT_QUERY = "INSERT INTO user (userName, password, email, address, role, createDate, lastLoginDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_QUERY = "SELECT * FROM USER WHERE userId= ?";
	private static final String UPDATE_QUERY = "UPDATE user SET userName=?, password=?, email=?, address=?, lastLoginDate=? WHERE userId = ?";
	private static final String DELETE_QUERY = "DELETE FROM user WHERE userId = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM user";

	@Override
	public int addUser(User user) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

			int i = pstmt.executeUpdate();
			return i;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User getUser(int userId) {
		Connection con = DBConnection.getConnection();
		User user = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, userId);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int id = res.getInt("userId");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String role = res.getString("role");
				Timestamp createDate = res.getTimestamp("createDate");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");

				user = new User(id, userName, password, email, address, role, createDate, lastLoginDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(6, user.getUserId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int userId) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt;

		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUsers() {
		Connection con = DBConnection.getConnection();
		User user = null;
		ArrayList<User> al = new ArrayList<User>();

		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int id = res.getInt("userId");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String role = res.getString("role");
				Timestamp createDate = res.getTimestamp("createDate");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");

				user = new User(id, userName, password, email, address, role, createDate, lastLoginDate);

				al.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public User login(String input, String password) {

		Connection con = DBConnection.getConnection();
		User user = null;

		String query = "SELECT userId FROM user WHERE (email=? OR userName=?) AND password=?";

		try {
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, input);
			pstmt.setString(2, input);
			pstmt.setString(3, password);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				user = new User(); 
				user.setUserId(res.getInt("userId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
