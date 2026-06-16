package com.mealgo.Model;

import java.sql.Timestamp;

public class Menu {

	private int menuId;
	private int restaurantId;
	private String itemName;
	private String description;
	private double price;
	private boolean isAvailable;
	private String category;
	private String imageUrl;   // Added
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private Timestamp deletedDate;

	public Menu(int restaurantId, String itemName, String description, double price, boolean isAvailable,
			String category, String imageUrl, Timestamp createdDate, Timestamp updatedDate, Timestamp deletedDate) {

		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.category = category;
		this.imageUrl = imageUrl;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.deletedDate = deletedDate;
	}

	public Menu(int menuId, int restaurantId, String itemName, String description, double price,
			boolean isAvailable, String category, String imageUrl, Timestamp createdDate,
			Timestamp updatedDate, Timestamp deletedDate) {

		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.category = category;
		this.imageUrl = imageUrl;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.deletedDate = deletedDate;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Timestamp getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName
				+ ", description=" + description + ", price=" + price + ", isAvailable=" + isAvailable
				+ ", category=" + category + ", imageUrl=" + imageUrl + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", deletedDate=" + deletedDate + "]";
	}
}