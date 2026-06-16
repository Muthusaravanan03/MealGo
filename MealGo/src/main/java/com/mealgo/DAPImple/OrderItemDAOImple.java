package com.mealgo.DAPImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mealgo.DAO.OrderItemDAO;
import com.mealgo.Model.OrderItem;
import com.mealgo.Utility.DBConnection;

public class OrderItemDAOImple implements OrderItemDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO order_item (orderId, menuId, quantity, itemTotal) VALUES (?, ?, ?, ?)";

    private static final String SELECT_QUERY =
            "SELECT * FROM order_item WHERE orderItemId = ?";

    private static final String UPDATE_QUERY =
            "UPDATE order_item SET orderId=?, menuId=?, quantity=?, itemTotal=? WHERE orderItemId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM order_item WHERE orderItemId=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM order_item";

    @Override
    public void addOrderItem(OrderItem orderItem) {

        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItem(int orderItemId) {

        Connection con = DBConnection.getConnection();
        OrderItem orderItem = null;

        try {

            PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);

            pstmt.setInt(1, orderItemId);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                int id = res.getInt("orderItemId");
                int orderId = res.getInt("orderId");
                int menuId = res.getInt("menuId");
                int quantity = res.getInt("quantity");
                double itemTotal = res.getDouble("itemTotal");

                orderItem = new OrderItem(
                        id,
                        orderId,
                        menuId,
                        quantity,
                        itemTotal
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItem;
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());
            pstmt.setInt(5, orderItem.getOrderItemId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int orderItemId) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, orderItemId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getAllOrderItems() {

        Connection con = DBConnection.getConnection();

        List<OrderItem> orderItems = new ArrayList<>();

        try {

            Statement stmt = con.createStatement();

            ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY);

            while (res.next()) {

                int id = res.getInt("orderItemId");
                int orderId = res.getInt("orderId");
                int menuId = res.getInt("menuId");
                int quantity = res.getInt("quantity");
                double itemTotal = res.getDouble("itemTotal");

                OrderItem orderItem = new OrderItem(
                        id,
                        orderId,
                        menuId,
                        quantity,
                        itemTotal
                );

                orderItems.add(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }
}