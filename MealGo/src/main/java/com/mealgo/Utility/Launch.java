//package com.mealgo.Utility;
//
//import java.util.List;
//import java.sql.ResultSet;
//import java.sql.Timestamp;
//import java.util.Scanner;
//
//import com.tap.DAPImple.MenuDAOImple;
//import com.tap.DAPImple.OrderTableImple;
//import com.tap.DAPImple.RestaurantDAOImple;
//import com.tap.DAPImple.UserDAOImple;
//import com.tap.Model.Menu;
//import com.tap.Model.OrderTable;
//import com.tap.Model.Restaurant;
//import com.tap.Model.User;
//
//public class Launch {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		
////		Add User
////		System.out.println("Enter the name");
////		String userName = sc.next();
////		System.out.println("Enter the password");
////		String password = sc.next();
////		System.out.println("Enter the email");
////		String email = sc.next();
////		System.out.println("Enter the address");
////		String address = sc.next();
////		System.out.println("Enter the role");
////		String role = sc.next();
////		
////		User u = new User(userName, password, email, address, role);
////		
////		UserDAOImple daoi = new UserDAOImple();
////		daoi.addUser(u);
////		
////		System.out.println(u);
//		
//		
////		Get User
////		UserDAOImple daoi = new UserDAOImple();
////		User user = daoi.getUser(2);
////		System.out.print(user);
//		
////		Update User
////		UserDAOImple daoi = new UserDAOImple();
////		User user = daoi.getUser(1);
////		user.setLastLoginDate(new Timestamp(System.currentTimeMillis()));
////		daoi.updateUser(user);
////		System.out.print("Update Finished");
//		
////		Delete User
////		UserDAOImple daoi = new UserDAOImple();
////		daoi.deleteUser(2);
////		System.out.print("Delete Finished");
//		
////		Get All User
////		UserDAOImple daoi = new UserDAOImple();
////		List<User> allUser = daoi.getAllUsers();
////		
////		for(User user : allUser) {
////			System.out.print(user);
////		}
//		
//		
//		
////		------------------------------------------------------------------------
//		
////		Add Restaurant
////		System.out.println("Enter Restaurant Name");
////		String restName = sc.next();
////
////		System.out.println("Enter Cuisine Type");
////		String cuisineType = sc.next();
////
////		System.out.println("Enter Delivery Time");
////		int deliveryTime = sc.nextInt();
////
////		System.out.println("Enter Address");
////		String address = sc.next();
////
////		System.out.println("Enter Admin User Id");
////		int adminUserId = sc.nextInt();
////
////		System.out.println("Enter Rating");
////		float rating = sc.nextFloat();
////
////		System.out.println("Is Active (true/false)");
////		boolean isActive = sc.nextBoolean();
////
////		Restaurant restaurant = new Restaurant(restName, cuisineType, deliveryTime, address, adminUserId, rating, isActive);
////
////		RestaurantDAOImple daoi = new RestaurantDAOImple();
////
////		daoi.addRestaurant(restaurant);
////
////		System.out.println("Restaurant Added Successfully");
////
//
//
////		Get Restaurant
////		RestaurantDAOImple daoi = new RestaurantDAOImple();
////
////		Restaurant restaurant = daoi.getRestaurant(1);
////
////		System.out.println(restaurant);
//
//
//
////		Update Restaurant
////		RestaurantDAOImple daoi = new RestaurantDAOImple();
////
////		Restaurant restaurant = daoi.getRestaurant(1);
////
////		restaurant.setRestName("A2B");
////		restaurant.setCuisineType("SouthIndian");
////		restaurant.setDeliveryTime(30);
////		restaurant.setAddress("BTM");
////		restaurant.setAdminUserId(101);
////		restaurant.setRating(4.5f);
////		restaurant.setActive(true);
////
////		daoi.updateRestaurant(restaurant);
////
////		System.out.println("Update Finished");
//
//
////		Delete Restaurant
////		RestaurantDAOImple daoi = new RestaurantDAOImple();
////
////		daoi.deleteRestaurant(2);
////
////		System.out.println("Delete Finished");
//
//
//
////		Get All Restaurants
////		RestaurantDAOImple daoi = new RestaurantDAOImple();
////
////		List<Restaurant> allRestaurants = daoi.getAllRestaurants();
////
////		for(Restaurant restaurant : allRestaurants) {
////			System.out.println(restaurant);
////		}
//		
//		
////		-----------------------------------------------------------------
//		
////		Add Menu
////		Menu menu = new Menu(
////				1,
////				"ChickenBurger",
////				"Spicy chicken burger with cheese",
////				199.0,
////				true,
////				"FastFood",
////				null,
////				null,
////				null
////		);
////
////		MenuDAOImple daoi = new MenuDAOImple();
////
////		daoi.addMenu(menu);
////
////		System.out.println("Menu Added Successfully");
//
//		
//		
////		Get Menu
////		MenuDAOImple daoi = new MenuDAOImple();
////
////		Menu menu = daoi.getMenu(1);
////
////		System.out.println(menu);
//
//
//
//
////		Update Menu
////		MenuDAOImple daoi = new MenuDAOImple();
////
////		Menu menu = daoi.getMenu(1);
////
////		menu.setItemName("VegBurger");
////		menu.setDescription("Veg burger with cheese");
////		menu.setPrice(149.0);
////		menu.setAvailable(true);
////		menu.setCategory("FastFood");
////
////		daoi.updateMenu(menu);
////
////		System.out.println("Update Finished");
//
//
//
//
////		Delete Menu
////		MenuDAOImple daoi = new MenuDAOImple();
////
////		daoi.deleteMenu(2);
////
////		System.out.println("Delete Finished");
//
//
//
//
////		Get All Menus
////		MenuDAOImple daoi = new MenuDAOImple();
////
////		List<Menu> allMenus = daoi.getAllMenus();
////
////		for(Menu menu : allMenus) {
////			System.out.println(menu);
////		}
//		
//		
//		
//		
//        OrderTableImple daoi = new OrderTableImple();
//
//
////      ---------------- ADD ORDER ----------------
//        OrderTable order2 = new OrderTable(
//                2,
//                2,
//                1,
//                null,
//                399.0,
//                "CONFIRMED",
//                "CASH"
//        );
//
//        daoi.addOrder(order2);
//        System.out.println("Order Added Successfully");
//
//
//
////      ---------------- GET ORDER ----------------
////        OrderTable order = daoi.getOrder(1);
////        System.out.println(order);
//
//
//
////      ---------------- UPDATE ORDER ----------------
////        OrderTable order = daoi.getOrder(1);
////
////        order.setStatus("CONFIRMED");
////        order.setPaymentMethod("CASH");
////        order.setTotalAmount(350.0);
////
////        daoi.updateOrder(order);
////
////        System.out.println("Order Updated Successfully");
//
//
//
////      ---------------- DELETE ORDER ----------------
////        daoi.deleteOrder(2);
////        System.out.println("Order Deleted");
//
//
//
////      ---------------- GET ALL ORDERS ----------------
////        List<OrderTable> orders = daoi.getAllOrders();
////
////        for (OrderTable order : orders) {
////            System.out.println(order);
////        }
//
//		
//		
//	}
//
//}
