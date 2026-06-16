package com.mealgo.DAPImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mealgo.DAO.OrderTableDAO;
import com.mealgo.Model.OrderTable;
import com.mealgo.Utility.DBConnection;

public class OrderTableImple implements OrderTableDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO order_table (orderId, userId, restaurantId, orderDate, totalAmount, status, paymentMethod) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_QUERY =
            "SELECT * FROM order_table WHERE orderId = ?";

    private static final String UPDATE_QUERY =
            "UPDATE order_table SET userId=?, restaurantId=?, orderDate=?, totalAmount=?, status=?, paymentMethod=? WHERE orderId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM order_table WHERE orderId = ?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM order_table";

    @Override
    public void addOrder(OrderTable orderTable) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

            pstmt.setInt(1, orderTable.getOrderId()); // IMPORTANT FIX
            pstmt.setInt(2, orderTable.getUserId());
            pstmt.setInt(3, orderTable.getRestaurantId());
            pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            pstmt.setDouble(5, orderTable.getTotalAmount());
            pstmt.setString(6, orderTable.getStatus());
            pstmt.setString(7, orderTable.getPaymentMethod());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderTable getOrder(int orderId) {

        Connection con = DBConnection.getConnection();

        OrderTable order = null;

        try {

            PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);

            pstmt.setInt(1, orderId);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                int id = res.getInt("orderId");
                int userId = res.getInt("userId");
                int restaurantId = res.getInt("restaurantId");
                Timestamp orderDate = res.getTimestamp("orderDate");
                double totalAmount = res.getDouble("totalAmount");
                String status = res.getString("status");
                String paymentMethod = res.getString("paymentMethod");

                order = new OrderTable(
                        id,
                        userId,
                        restaurantId,
                        orderDate,
                        totalAmount,
                        status,
                        paymentMethod
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public void updateOrder(OrderTable orderTable) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

            pstmt.setInt(1, orderTable.getUserId());
            pstmt.setInt(2, orderTable.getRestaurantId());
            pstmt.setTimestamp(3, orderTable.getOrderDate());
            pstmt.setDouble(4, orderTable.getTotalAmount());
            pstmt.setString(5, orderTable.getStatus());
            pstmt.setString(6, orderTable.getPaymentMethod());
            pstmt.setInt(7, orderTable.getOrderId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, orderId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderTable> getAllOrders() {

        Connection con = DBConnection.getConnection();

        List<OrderTable> al = new ArrayList<>();

        try {

            Statement stmt = con.createStatement();

            ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY);

            while (res.next()) {

                int id = res.getInt("orderId");
                int userId = res.getInt("userId");
                int restaurantId = res.getInt("restaurantId");
                Timestamp orderDate = res.getTimestamp("orderDate");
                double totalAmount = res.getDouble("totalAmount");
                String status = res.getString("status");
                String paymentMethod = res.getString("paymentMethod");

                OrderTable order = new OrderTable(
                        id,
                        userId,
                        restaurantId,
                        orderDate,
                        totalAmount,
                        status,
                        paymentMethod
                );

                al.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return al;
    }
}