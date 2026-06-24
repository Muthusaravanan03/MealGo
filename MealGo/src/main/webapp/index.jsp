<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.mealgo.Model.Restaurant"%>

<%@ page import="java.util.List"%>
<%@ page import="com.mealgo.Model.Restaurant"%>
<%@ page import="com.mealgo.DAPImple.RestaurantDAOImple"%>




<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MealGo</title>
<link rel="stylesheet" href="style.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

<link
	href="https://fonts.googleapis.com/css2?family=Lexend:wght@100..200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet" />
<link rel="icon" href="images/logo.jpg" sizes="32x32" />
</head>
<body>

	 <jsp:include page="navbar.jsp" />
	 
	<section class="hero">
		<div class="hero-content">
			<div class="search-bar">
				<input type="text" placeholder="Search restaurants, food..." /> <img
					src="images/search-icon.png" class="search-icon" alt="search" />
			</div>

			<h1>Delicious Food Delivered Fast!!</h1>
			<p>Order your favorite meals from the best restaurants near you.</p>

			<a href="#menu-section">
				<button>Order Now</button>
			</a>
		</div>

		<!-- VIDEO / IFRAME SECTION -->
		<div class="hero-video">
			<video autoplay muted loop playsinline>
				<source src="images/HeroVideo.mp4" type="video/mp4" />
			</video>
		</div>
	</section>

	<!-- ================= MENU SECTION ================= -->
	<section class="menu-section" id="menu-section">

		<h2 class="section-title">🍽️ Popular Menu Items</h2>

		<div class="menu-grid">

			<%
			com.mealgo.DAPImple.MenuDAOImple menudao = new com.mealgo.DAPImple.MenuDAOImple();

			java.util.List<com.mealgo.Model.Menu> menuList = menudao.getTop10Menus();
			%>

			<%
			if (menuList != null && !menuList.isEmpty()) {

				for (com.mealgo.Model.Menu menu : menuList) {
			%>

			<div class="menu-card">

				<img src="<%=menu.getImageUrl()%>" alt="<%=menu.getItemName()%>" />

				<div class="menu-content">

					<h3><%=menu.getItemName()%></h3>

					<p class="desc"><%=menu.getDescription()%></p>

					<div class="info">
						<span>🍴 <%=menu.getCategory()%></span>
					</div>

					<div class="info">
						<span>₹ <%=menu.getPrice()%></span> <span
							style="color:<%=menu.isAvailable() ? "green" : "red"%>; font-weight:600;">
							<%=menu.isAvailable() ? "AVAILABLE" : "NOT AVAILABLE"%>
						</span>
					</div>

					<a href="cart?action=add&menuId=<%=menu.getMenuId()%>"
						class="add-cart-btn"> Add to Cart </a>
				</div>

			</div>

			<%
			}
			} else {
			%>

			<h3 style="color: red; text-align: center;">No menu items found
				in database!</h3>

			<%
			}
			%>

		</div>
	</section>

	<!-- Restaurants List -->
	<%
	RestaurantDAOImple dao = new RestaurantDAOImple();
	List<Restaurant> topRestaurants = dao.getTop10Restaurants();
	%>
	<section class="restaurant-section" id="restaurant-section">
		<h2 class="section-title">🍽️ Top Restaurants Near You</h2>

		<div class="restaurant-grid">

			<%
			if (topRestaurants != null && !topRestaurants.isEmpty()) {

				for (Restaurant restaurant : topRestaurants) {
			%>

			<div class="restaurant-card">

				<img src="<%=restaurant.getImageUrl()%>"
					alt="<%=restaurant.getRestName()%>" />

				<div class="restaurant-content">

					<h3><%=restaurant.getRestName()%></h3>

					<p class="cuisine">
						🍛
						<%=restaurant.getCuisineType()%></p>

					<div class="info">
						<span>⭐ <%=restaurant.getRating()%></span> <span>🚚 <%=restaurant.getDeliveryTime()%>
							min
						</span>
					</div>

					<p class="address"><%=restaurant.getAddress()%></p>

					<small style="display: block; margin-bottom: 10px;">
						Status: <span
						style="color:<%=restaurant.isActive() ? "green" : "red"%>; font-weight:600;">
							<%=restaurant.isActive() ? "OPEN" : "CLOSED"%>
					</span>
					</small>
					<button>View Menu</button>

				</div>

			</div>
			<%
			}
			} else {
			%>

			<p>No restaurants found!</p>

			<%
			}
			%>

		</div>
	</section>
	<!--  Image Sliding -->

	<section class="about-images">
		<div class="img-box box1"></div>
		<div class="img-box box2"></div>
		<div class="img-box box3"></div>
	</section>

	<!-- ================= FOOTER ================= -->
	<footer class="footer">
		<div class="footer-container">
			<!-- Brand -->
			<div class="footer-box">
				<h2>🍔 MealGo</h2>
				<p>Delicious food delivered fast at your doorstep. Order from
					your favorite restaurants anytime.</p>
			</div>

			<!-- Quick Links -->
			<div class="footer-box">
				<h3>Quick Links</h3>
				<a href="index.html">Home</a> <a href="#menu-section">Menu</a> <a
					href="restaurants.html">Restaurants</a> <a href="login.html">Login</a>
				<a href="signup.html">Sign Up</a>
			</div>

			<!-- Contact -->
			<div class="footer-box">
				<h3>Contact</h3>
				<p>📍 Bangalore, India</p>
				<p>📞 +91 98765 43210</p>
				<p>✉️ support@mealgo.com</p>
			</div>

			<!-- Social -->
			<div class="footer-box">
				<h3>Follow Us</h3>
				<a href="#">Instagram</a> <a href="#">Facebook</a> <a href="#">Twitter</a>
			</div>
		</div>

		<div class="footer-bottom">
			<p>© 2026 MealGo. All rights reserved.</p>
		</div>
	</footer>
</body>
</html>
