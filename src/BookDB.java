import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDB {

	// private Book b = new Book();

	private Connection con = null;

	private Connection connect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		return con;
	}

	public Book getBook(String value) {

		Book b = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from books where sku = \'" + value + "\'";

		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				b = new Book(rs.getString("sku"), rs.getString("title"), rs.getString("author"),
						rs.getString("description"), rs.getDouble("price"));

				// System.out.println(rs.getString(1));
				// System.out.println(rs.getString(2));
				// System.out.println(rs.getString(3));
				// System.out.println(rs.getString(4));
				// System.out.println(rs.getDouble(5) + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
			// } catch (ClassNotFoundException e) {
			// e.printStackTrace();
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

	public int updateDescription(String _sku, String _desc) {

		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "update books set description = ? where sku = ? ";

		try {

			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, _desc);
			pstmt.setString(2, _sku);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	public int insertBook(String _sku, String _title, String _author, String _desc, double _price) {

		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "insert into books values (?, ?, ?, ?, ?)";

		try {

			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, _sku);
			pstmt.setString(2, _title);
			pstmt.setString(3, _author);
			pstmt.setString(4, _desc);
			pstmt.setDouble(5, _price);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	public int deleteBook(String _sku) {

		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "delete from books where sku = ? ";

		try {

			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, _sku);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;

	}
}
