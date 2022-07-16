package com.oc_p8.ecommerce.ordercycle.infrastructure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderQueryDTO;

public class OrderQueryDAO {

    public List<OrderQueryDTO> findOrdersByState(OrderState state) throws SQLException {
        List<OrderQueryDTO> orders = new ArrayList<>();
        String sql = "SELECT id, assignee FROM orders WHERE state = ?;";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, state.ordinal());

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            OrderQueryDTO orderQueryDTO = new OrderQueryDTO();
            orderQueryDTO.setId(rs.getLong("id"));
            orderQueryDTO.setAssignee(rs.getString("assignee"));

            orders.add(orderQueryDTO);
        }

        rs.close();
        ps.close();

        return orders;
    }

    public OrderQueryDTO findOrderById(Long id) throws SQLException {
        OrderQueryDTO orderDTO = null;
        String sql = "SELECT id, state, assignee FROM orders WHERE id = ?;";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            orderDTO = new OrderQueryDTO();
            orderDTO.setId(rs.getLong("id"));
            orderDTO.setState(rs.getInt("state"));
            orderDTO.setAssignee(rs.getString("assignee"));
        }

        return orderDTO;
    }

    private Connection getConnection() throws SQLException {
        return ConnectionManagerSQL.getInstance().getConnection();
    }
}
