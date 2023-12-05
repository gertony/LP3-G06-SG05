/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplobasedatos;

import java.sql.*;

public class EjemploPreparedStatement {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/lp", "root", "root");

            // Consulta preparada para insertar
            String sqlInsert = "INSERT INTO clientes (nombre, edad) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, "Maria");
            pstmt.setInt(2, 25);
            pstmt.executeUpdate();
            System.out.println("Registro insertado correctamente.");

            pstmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}