import java.sql.*;
import java.util.Scanner;

public class DBSelect2Bad {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("What record would you like to see? >"); // SQL Injection Attack ( 2 or 1 = 1; )

        String recordId = sc.nextLine();

        String db = "jdbc:mysql://localhost/sales";
        String db_user  = "root";
        String db_pass = "p4ssword";

        String selectStatement = "SELECT * FROM item where id = " + recordId;

        Connection conn = DriverManager.getConnection(db, db_user, db_pass);

        PreparedStatement stmt = conn.prepareStatement(selectStatement);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getBigDecimal("price"));
        }
    }
}
