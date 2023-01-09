/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Product;


/**
 *
 * @author vinik
 */
public class ProductDAO {

    public void create(Product p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO product (id, name, value)VALUES(DEFAULT, ?, ?)");
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getName());
            stmt.setFloat(3, p.getValue());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Product successfully saved.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error trying to save Product. " + ex);
        } finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }

}
