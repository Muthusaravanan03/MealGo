package com.mealgo.Model;

public class Restaurant {

	private int restaurantId;
	private String restName;
	private String cuisineType;
	private int deliveryTime;
	private String address;
	private int adminUserId;
	private float rating;
	private boolean isActive;
	private String imageUrl;   // ✅ added field

	public Restaurant() {
		
	}

	public Restaurant(int restaurantId, String restName, String cuisineType, int deliveryTime, String address,
			int adminUserId, float rating, boolean isActive, String imageUrl) {
		super();
		this.restaurantId = restaurantId;
		this.restName = restName;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imageUrl = imageUrl;
	}

	public Restaurant(String restName, String cuisineType, int deliveryTime, String address, int adminUserId,
			float rating, boolean isActive, String imageUrl) {
		this.restName = restName;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imageUrl = imageUrl;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	// ✅ new getter/setter
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId 
				+ ", restName=" + restName 
				+ ", cuisineType=" + cuisineType
				+ ", deliveryTime=" + deliveryTime 
				+ ", address=" + address 
				+ ", adminUserId=" + adminUserId
				+ ", rating=" + rating 
				+ ", isActive=" + isActive 
				+ ", imageUrl=" + imageUrl + "]";
	}
}