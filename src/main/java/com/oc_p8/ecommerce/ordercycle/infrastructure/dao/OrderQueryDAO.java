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

    private String request = "SELECT * FROM order WHERE order.state =?";

    public List<OrderQueryDTO> findOrdersByState(OrderState state) throws SQLException {
        List<OrderQueryDTO> orders = new ArrayList<>();

        PreparedStatement ps = this.getConnection().prepareStatement(request);
        ps.setString(1, state.toString());

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            OrderQueryDTO orderQueryDTO = new OrderQueryDTO();
            orderQueryDTO.setId(rs.getLong("id"));
            orderQueryDTO.setClientFirstName(rs.getString("client_first_name"));
            orderQueryDTO.setClientLastName(rs.getString("client_last_name"));
            // TODO Cart
            orders.add(orderQueryDTO);
        }

        rs.close();
        ps.close();

        return orders;
    }

    private Connection getConnection() throws SQLException {
        return ConnectionManagerSQL.getInstance().getConnection();
    }
}
