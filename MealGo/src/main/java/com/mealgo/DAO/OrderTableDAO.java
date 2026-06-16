package com.mealgo.DAO;

import java.util.List;

import com.mealgo.Model.OrderTable;

public interface OrderTableDAO {

    void addOrder(OrderTable order);

    OrderTable getOrder(int orderId);

    void updateOrder(OrderTable order);

    void deleteOrder(int orderId);

    List<OrderTable> getAllOrders();
}