package com.mealgo.DAPImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mealgo.DAO.RestaurantDAO;
import com.mealgo.Model.Restaurant;
import com.mealgo.Utility.DBConnection;

public class RestaurantDAOImple implements RestaurantDAO {

	private static final String INSERT_QUERY =
			"INSERT INTO restaurant (restName, cuisineType, deliveryTime, address, adminUserId, rating, isActive, imageUrl) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SELECT_QUERY =
			"SELECT * FROM restaurant WHERE restaurantId = ?";

	private static final String UPDATE_QUERY =
			"UPDATE restaurant SET restName=?, cuisineType=?, deliveryTime=?, address=?, adminUserId=?, rating=?, isActive=?, imageUrl=? WHERE restaurantId=?";

	private static final String DELETE_QUERY =
			"DELETE FROM restaurant WHERE restaurantId = ?";

	private static final String SELECT_ALL_QUERY =
			"SELECT * FROM restaurant";

	@Override
	public void addRestaurant(Restaurant restaurant) {

		Connection con = DBConnection.getConnection();

		try {

			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

			pstmt.setString(1, restaurant.getRestName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setInt(5, restaurant.getAdminUserId());
			pstmt.setFloat(6, restaurant.getRating());
			pstmt.setBoolean(7, restaurant.isActive());
			pstmt.setString(8, restaurant.getImageUrl()); // ✅ added

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {

		Connection con = DBConnection.getConnection();

		Restaurant restaurant = null;

		try {

			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);

			pstmt.setInt(1, restaurantId);

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {

				int id = res.getInt("restaurantId");
				String restName = res.getString("restName");
				String cuisineType = res.getString("cuisineType");
				int deliveryTime = res.getInt("deliveryTime");
				String address = res.getString("address");
				int adminUserId = res.getInt("adminUserId");
				float rating = res.getFloat("rating");
				boolean isActive = res.getBoolean("isActive");
				String imageUrl = res.getString("imageUrl"); // ✅ added

				restaurant = new Restaurant(
						id, restName, cuisineType, deliveryTime,
						address, adminUserId, rating, isActive, imageUrl
				);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {

		Connection con = DBConnection.getConnection();

		try {

			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, restaurant.getRestName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setInt(5, restaurant.getAdminUserId());
			pstmt.setFloat(6, restaurant.getRating());
			pstmt.setBoolean(7, restaurant.isActive());
			pstmt.setString(8, restaurant.getImageUrl()); // ✅ added
			pstmt.setInt(9, restaurant.getRestaurantId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {

		Connection con = DBConnection.getConnection();

		try {

			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, restaurantId);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Restaurant> getAllRestaurants() {

		Connection con = DBConnection.getConnection();

		List<Restaurant> al = new ArrayList<>();

		try {

			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY);

			while(res.next()) {

				int id = res.getInt("restaurantId");
				String restName = res.getString("restName");
				String cuisineType = res.getString("cuisineType");
				int deliveryTime = res.getInt("deliveryTime");
				String address = res.getString("address");
				int adminUserId = res.getInt("adminUserId");
				float rating = res.getFloat("rating");
				boolean isActive = res.getBoolean("isActive");
				String imageUrl = res.getString("imageUrl"); // ✅ added

				Restaurant restaurant = new Restaurant(
						id, restName, cuisineType, deliveryTime,
						address, adminUserId, rating, isActive, imageUrl
				);

				al.add(restaurant);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}
	
	
	public List<Restaurant> getTop10Restaurants() {

	    Connection con = DBConnection.getConnection();
	    List<Restaurant> list = new ArrayList<>();

	    try {

	        String query = "SELECT * FROM restaurant LIMIT 10";
	        PreparedStatement ps = con.prepareStatement(query);

	        ResultSet res = ps.executeQuery();

	        while (res.next()) {

	            Restaurant restaurant = new Restaurant(
	                res.getInt("restaurantId"),
	                res.getString("restName"),
	                res.getString("cuisineType"),
	                res.getInt("deliveryTime"),
	                res.getString("address"),
	                res.getInt("adminUserId"),
	                res.getFloat("rating"),
	                res.getBoolean("isActive"),
	                res.getString("imageUrl")
	            );

	            list.add(restaurant);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
}