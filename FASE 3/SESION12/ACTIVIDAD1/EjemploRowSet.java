/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplobasedatos;
import java.sql.*;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
public class EjemploRowSet {
   public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost/lp");
            rowSet.setUsername("root");
            rowSet.setPassword("root");
            rowSet.setCommand("SELECT id, nombre, edad FROM clientes");
            rowSet.execute();
            // Mostrar resultados
            while (rowSet.next()) {
                int id = rowSet.getInt("id");
                String nombre = rowSet.getString("nombre");
                int edad = rowSet.getInt("edad");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
            }
            rowSet.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
