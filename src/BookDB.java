import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDB {

	public static Book getBook(String value) {

		Book b = new Book();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from books where sku = \'" + value + "\'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				b = new Book(rs.getString("sku"), rs.getString("title"), rs.getString("author"),
						rs.getString("description"), rs.getDouble("price"));

				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getDouble(5) + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return b;
	}

}
