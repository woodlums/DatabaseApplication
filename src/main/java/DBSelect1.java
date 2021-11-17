import java.sql.*;

public class DBSelect1 {

    public static void main(String[] args) throws SQLException {

        String db = "jdbc:mysql://localhost/sales";
        String db_user  = "root";
        String db_pass = "p4ssword";

        String selectStatement = "SELECT * FROM inventory;";

        Connection conn = DriverManager.getConnection(db, db_user, db_pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectStatement);

        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getInt("on_hand"));
        }
    }
}
