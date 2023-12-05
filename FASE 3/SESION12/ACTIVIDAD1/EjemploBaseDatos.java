/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplobasedatos;
import java.sql.*;

public class EjemploBaseDatos {

    

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lp", "root", "root");

            Statement stmt = conn.createStatement();
            String sqlInsert = "INSERT INTO clientes (nombre, edad) VALUES ('Juan', 30)";
            stmt.executeUpdate(sqlInsert);
            System.out.println("Registro insertado correctamente.");

            String sqlSelect = "SELECT id, nombre, edad FROM clientes";
            ResultSet rs = stmt.executeQuery(sqlSelect);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
            }

            String sqlUpdate = "UPDATE clientes SET edad = 31 WHERE nombre = 'Juan'";
            stmt.executeUpdate(sqlUpdate);
            System.out.println("Registro actualizado correctamente.");

            // Borrar registro
            String sqlDelete = "DELETE FROM clientes WHERE nombre = 'Juan'";
            stmt.executeUpdate(sqlDelete);
            System.out.println("Registro borrado correctamente.");

            // Paso 4: Cerrar recursos
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}

