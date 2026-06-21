package com.mealgo.DAPImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mealgo.DAO.MenuDAO;
import com.mealgo.Model.Menu;
import com.mealgo.Utility.DBConnection;

public class MenuDAOImple implements MenuDAO {

	private static final String INSERT_QUERY =
			"INSERT INTO menu (restaurantId, itemName, description, price, isAvailable, category, imageUrl, createdDate, updatedDate, deletedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SELECT_QUERY =
			"SELECT * FROM menu WHERE menuId = ?";

	private static final String UPDATE_QUERY =
			"UPDATE menu SET restaurantId=?, itemName=?, description=?, price=?, isAvailable=?, category=?, imageUrl=?, updatedDate=? WHERE menuId=?";

	private static final String DELETE_QUERY =
			"DELETE FROM menu WHERE menuId = ?";

	private static final String SELECT_ALL_QUERY =
			"SELECT * FROM menu";
	
	private static final String SELECT_TOP10_MENUS_QUERY =
	        "SELECT * FROM menu LIMIT 10";
	
	private static final String SELECT_BY_RESTAURANT =
	        "SELECT * FROM menu WHERE restaurantId = ?";

	@Override
	public void addMenu(Menu menu) {

		Connection con = DBConnection.getConnection();

		try {

			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setDouble(4, menu.getPrice());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setString(6, menu.getCategory());
			pstmt.setString(7, menu.getImageUrl());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(10, null);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Menu getMenu(int menuId) {

		Connection con = DBConnection.getConnection();

		Menu menu = null;

		try {

			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);

			pstmt.setInt(1, menuId);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				int id = res.getInt("menuId");
				int restaurantId = res.getInt("restaurantId");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				boolean isAvailable = res.getBoolean("isAvailable");
				String category = res.getString("category");
				String imageUrl = res.getString("imageUrl");
				Timestamp createdDate = res.getTimestamp("createdDate");
				Timestamp updatedDate = res.getTimestamp("updatedDate");
				Timestamp deletedDate = res.getTimestamp("deletedDate");

				menu = new Menu(
						id,
						restaurantId,
						itemName,
						description,
						price,
						isAvailable,
						category,
						imageUrl,
						createdDate,
						updatedDate,
						deletedDate
				);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menu;
	}

	@Override
	public void updateMenu(Menu menu) {

		Connection con = DBConnection.getConnection();

		try {

			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setDouble(4, menu.getPrice());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setString(6, menu.getCategory());
			pstmt.setString(7, menu.getImageUrl());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(9, menu.getMenuId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int menuId) {

		Connection con = DBConnection.getConnection();

		try {

			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, menuId);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenus() {

		Connection con = DBConnection.getConnection();

		List<Menu> al = new ArrayList<>();

		try {

			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {

				int id = res.getInt("menuId");
				int restaurantId = res.getInt("restaurantId");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				boolean isAvailable = res.getBoolean("isAvailable");
				String category = res.getString("category");
				String imageUrl = res.getString("imageUrl");
				Timestamp createdDate = res.getTimestamp("createdDate");
				Timestamp updatedDate = res.getTimestamp("updatedDate");
				Timestamp deletedDate = res.getTimestamp("deletedDate");

				Menu menu = new Menu(
						id,
						restaurantId,
						itemName,
						description,
						price,
						isAvailable,
						category,
						imageUrl,
						createdDate,
						updatedDate,
						deletedDate
				);

				al.add(menu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}
	
	
	@Override
	public List<Menu> getTop10Menus() {

	    Connection con = DBConnection.getConnection();

	    List<Menu> al = new ArrayList<>();

	    try {

	        Statement stmt = con.createStatement();

	        ResultSet res = stmt.executeQuery(SELECT_TOP10_MENUS_QUERY);

	        while (res.next()) {

	            int id = res.getInt("menuId");
	            int restaurantId = res.getInt("restaurantId");
	            String itemName = res.getString("itemName");
	            String description = res.getString("description");
	            double price = res.getDouble("price");
	            boolean isAvailable = res.getBoolean("isAvailable");
	            String category = res.getString("category");
	            String imageUrl = res.getString("imageUrl");
	            Timestamp createdDate = res.getTimestamp("createdDate");
	            Timestamp updatedDate = res.getTimestamp("updatedDate");
	            Timestamp deletedDate = res.getTimestamp("deletedDate");

	            Menu menu = new Menu(
	                    id,
	                    restaurantId,
	                    itemName,
	                    description,
	                    price,
	                    isAvailable,
	                    category,
	                    imageUrl,
	                    createdDate,
	                    updatedDate,
	                    deletedDate
	            );

	            al.add(menu);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return al;
	}
	
	
	@Override
	public List<Menu> getMenuByRestaurantId(int restaurantId) {

	    Connection con = DBConnection.getConnection();

	    List<Menu> list = new ArrayList<>();

	    try {

	        PreparedStatement pstmt =
	                con.prepareStatement(SELECT_BY_RESTAURANT);

	        pstmt.setInt(1, restaurantId);

	        ResultSet res = pstmt.executeQuery();

	        while (res.next()) {

	            Menu menu = new Menu(
	                    res.getInt("menuId"),
	                    res.getInt("restaurantId"),
	                    res.getString("itemName"),
	                    res.getString("description"),
	                    res.getDouble("price"),
	                    res.getBoolean("isAvailable"),
	                    res.getString("category"),
	                    res.getString("imageUrl"),
	                    res.getTimestamp("createdDate"),
	                    res.getTimestamp("updatedDate"),
	                    res.getTimestamp("deletedDate")
	            );

	            list.add(menu);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
}