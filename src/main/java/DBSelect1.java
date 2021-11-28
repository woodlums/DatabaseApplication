import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSelect1 {

    public static void main(String[] args) throws SQLException {

        List<SalesItem> dailySales = new ArrayList<>();

        String db = "jdbc:mysql://localhost/sales";
        String db_user  = "root";
        String db_pass = "p4ssword";

        String selectStatement = "SELECT * FROM item;";

        Connection conn = DriverManager.getConnection(db, db_user, db_pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectStatement);

        while (rs.next()) {

            SalesItem i = new SalesItem(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBigDecimal("price"));

            dailySales.add(i);
        }

        System.out.println("Database records acquired.");

        for(SalesItem item : dailySales)
        {
            System.out.println(item);
        }
    }
}
