<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.mealgo.Model.Menu"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MealGo | Menu</title>

<link rel="stylesheet" href="menu.css" />

<link
	href="https://fonts.googleapis.com/css2?family=Lexend:wght@100..900&display=swap"
	rel="stylesheet" />
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

	<!-- ================= HERO SECTION (MENU) ================= -->
	<section class="menu-hero">
		<div class="hero-content">

			<h1>Explore Delicious Menu Items 🍽️</h1>

			<p>Find your favorite dishes, explore categories, and order tasty
				food instantly.</p>

			<!-- MENU SEARCH -->
			<div class="search-wrapper">

				<!-- Food Search -->
				<div class="search-bar menu-search">
					<input type="text" placeholder="Search food, burgers, pizza..." />
					<img src="images/search-icon.png" class="search-icon" alt="search" />
				</div>

				<!-- Category Filter -->
				<div class="category-bar">
					<select>
						<option value="">All Categories</option>
						<option value="burger">Burger</option>
						<option value="pizza">Pizza</option>
						<option value="noodles">Noodles</option>
						<option value="biryani">Biryani</option>
						<option value="pasta">Pasta</option>
						<option value="sandwich">Sandwich</option>
					</select>
				</div>

			</div>

		</div>
	</section>

	<!-- ================= MENU SECTION ================= -->
	<section class="menu-section">

		<h2 class="section-title">🍽️ Popular Menu Items</h2>

		<div class="menu-grid">

			<%
			List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");

			if (menuList != null && !menuList.isEmpty()) {

				for (Menu menu : menuList) {
			%>

			<div class="menu-card">

				<img src="<%=menu.getImageUrl()%>" alt="<%=menu.getItemName()%>">

				<div class="menu-content">

					<h3><%=menu.getItemName()%></h3>

					<p class="description"><%=menu.getDescription()%></p>

					<p class="category">
						🍴
						<%=menu.getCategory()%></p>

					<p class="price">
						₹
						<%=menu.getPrice()%></p>

					<small style="display: block; margin-bottom: 10px;">
						Status: <span
						style="color:<%=menu.isAvailable() ? "green" : "red"%>; font-weight:600;">
							<%=menu.isAvailable() ? "Available" : "Not Available"%>
					</span>
					</small>

					<button>Add to Cart</button>

				</div>

			</div>

			<%
			}
			} else {
			%>

			<h3 style="color: red;">No menu items found or servlet not
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
				<p>Delicious food delivered fast at your doorstep.</p>
			</div>

			<div class="footer-box">
				<h3>Quick Links</h3>
				<a href="index.jsp">Home</a> <a href="callMenuServlet">Menu</a> <a
					href="callRestaurantServlet">Restaurants</a> <a href="login.html">Login</a>
				<a href="signup.html">Sign Up</a>
			</div>

			<div class="footer-box">
				<h3>Contact</h3>
				<p>📍 Bangalore, India</p>
				<p>📞 +91 98765 43210</p>
				<p>✉️ support@mealgo.com</p>
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