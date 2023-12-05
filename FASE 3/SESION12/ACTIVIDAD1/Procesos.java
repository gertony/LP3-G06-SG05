
package ejemplobasedatos;
import java.sql.*;
public class Procesos {
    public static void main(String[] args) throws ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp", "root", "root")){
            String sql = "{call actualizar()}"; // Procedimientos
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pstmt = connection.prepareStatement(sql);
            sql = "{call suma(2,4)}"; // Funcion
            pstmt = connection.prepareStatement(sql);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
