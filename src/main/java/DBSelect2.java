import java.sql.*;

public class DBSelect2 {

    public static void main(String[] args) throws SQLException {

        int targetRecord = 2;

        String db = "jdbc:mysql://localhost/sales";
        String db_user  = "root";
        String db_pass = "p4ssword";

        String selectStatement = "SELECT * FROM inventory where id = ?";

        Connection conn = DriverManager.getConnection(db, db_user, db_pass);

        PreparedStatement stmt = conn.prepareStatement(selectStatement);
        stmt.setString(1, String.valueOf(targetRecord));

        ResultSet rs = stmt.executeQuery(selectStatement);

        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getInt("on_hand"));
        }
    }
}
