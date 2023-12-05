/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplobasedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManejoTransacciones {
    public static void main(String[] args) {
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp", "root", "root");
            connection.setAutoCommit(false);
            String insertQuery = "INSERT INTO clientes (nombre, edad) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "Juan");
            preparedStatement.setInt(2, 25);
            preparedStatement.executeUpdate();
            String selectQuery = "SELECT * FROM Personas";
            preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
            };
            connection.commit();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
