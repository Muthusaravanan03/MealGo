<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.mealgo.Model.Restaurant"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MealGo | Restaurants</title>

<link rel="stylesheet" href="restaurant.css" />

<link
	href="https://fonts.googleapis.com/css2?family=Lexend:wght@100..900&display=swap"
	rel="stylesheet" />
	
<link rel="icon" href="images/logo.jpg" sizes="32x32" />
</head>

<body>
	<!-- ================= NAVBAR ================= -->
	<header class="navbar">
		<a href="index.jsp" class="logo">🍔 MealGo</a>

		<div class="menu-icon" onclick="toggleMenu()">☰</div>

		<nav class="nav-links">
			<a href="index.jsp">Home</a> <a href="callRestaurantServlet">Restaurants</a>
			<a href="callMenuServlet">Menu</a> <a href="#">Orders</a> <a
				href="login.html">Login</a> <a href="signup.html">Sign Up</a>
		</nav>
	</header>

	<!-- ================= HERO SECTION ================= -->
	<section class="restaurant-hero">
		<div class="hero-content">
			<h1>Discover Great Food Near You !!</h1>

			<p>Search from hundreds of restaurants and enjoy your favorite
				meals delivered fast.</p>

			<!-- Restaurant Search -->
			<div class="search-wrapper">
				<!-- Restaurant Search -->
				<div class="search-bar restaurant-search">
					<input type="text" placeholder="Search restaurants, food..." /> <img
						src="images/search-icon.png" class="search-icon" alt="search" />
				</div>

				<!-- Location Search -->
				<div class="location-bar">
					<img src="images/location-icon.png" class="location-icon"
						alt="location" /> <input type="text" placeholder="Enter location" />
				</div>
			</div>
		</div>
	</section>

	<!-- ================= RESTAURANTS SECTION ================= -->
	<section class="restaurant-section" id="restaurant-section">
		<h2 class="section-title">🍽️ Top Restaurants Near You</h2>

		<div class="restaurant-grid">
			<!-- CARD 1 -->

			<%
			List<Restaurant> allRestaurants = (List<Restaurant>) request.getAttribute("allRestaurants");

			if (allRestaurants != null) {
				for (Restaurant restaurant : allRestaurants) {
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

			<h3 style="color: red;">No restaurants found or servlet not
				called!</h3>

			<%
			}
			%>
		</div>
	</section>

	<!-- ================= FOOTER ================= -->
	<footer class="footer">
		<div class="footer-container">
			<div class="footer-box">
				<h2>🍔 MealGo</h2>
				<p>Delicious food delivered fast at your doorstep. Order from
					your favorite restaurants anytime.</p>
			</div>

			<div class="footer-box">
				<h3>Quick Links</h3>
				<a href="index.html">Home</a> <a href="#">Menu</a> <a
					href="restaurant.html">Restaurants</a> <a href="login.html">Login</a>
				<a href="signup.html">Sign Up</a>
			</div>

			<div class="footer-box">
				<h3>Contact</h3>
				<p>📍 Bangalore, India</p>
				<p>📞 +91 98765 43210</p>
				<p>✉️ support@mealgo.com</p>
			</div>

			<div class="footer-box">
				<h3>Follow Us</h3>
				<a href="#">Instagram</a> <a href="#">Facebook</a> <a href="#">Twitter</a>
			</div>
		</div>

		<div class="footer-bottom">
			<p>© 2026 MealGo. All rights reserved.</p>
		</div>
	</footer>

	<script>
		function toggleMenu() {
			document.querySelector(".nav-links").classList.toggle("active");
		}
	</script>
</body>
</html>
