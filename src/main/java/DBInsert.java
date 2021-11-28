import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class DBInsert {

    public static void main(String[] args) throws SQLException {

        final String db = "jdbc:mysql://localhost/sales";
        final String db_user  = "root";
        final String db_pass = "p4ssword";

        Connection conn = DriverManager.getConnection(db, db_user, db_pass);
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the name of the item?");
        String itemName = sc.nextLine();

        System.out.println("What is the price?");
        String itemPrice = sc.nextLine();

        SalesItem si = new SalesItem(itemName, new BigDecimal(itemPrice));

        String insertStatement = "insert into item (name, price) values (?, ?);";

        PreparedStatement stmt = conn.prepareStatement(insertStatement, PreparedStatement.RETURN_GENERATED_KEYS);

        stmt.setString(1, si.getName());
        stmt.setBigDecimal(2, si.getPrice());

        int count = stmt.executeUpdate();

        int lastKey = 0;

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next())
        {
            lastKey = rs.getInt(1);
        }

        System.out.println("Inserted Record");
        System.out.println("Last record ID was " + lastKey);
    }

}
