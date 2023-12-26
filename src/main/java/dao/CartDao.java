package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jumun.Cart;
import jumun.Jumun;
import model.MyBoard;
import model.Member;

public class CartDao {
	public Connection getConnection() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kic", "1111");
			return conn;
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public int addToCart(String jno, String id) throws SQLException {

		Connection conn = getConnection();
		String sql = "insert into Cart values (cartseq.nextval, ?,?,1 )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, jno);

		int num = pstmt.executeUpdate();

		return num;
	}

	public List<Cart> jumunList(String id) throws SQLException {

		Connection conn = getConnection();
		String sql = " select  a.itemid, j.jname, sum(a.qty) as qty, sum(j.price) as price "
				+ " from cart a, jmnumber j  "
				+ " where a.itemid = j.jno and a.userid = ?  "
				+ " group BY a.itemid, j.jname, j.price "
				+ " order by itemid ";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		List<Cart> li = new ArrayList();

		while (rs.next()) {

			Cart m = new Cart();
			//m.setSer(rs.getString("ser"));
			//m.setUserid(rs.getString("userid"));
			m.setItemid(rs.getString("itemid"));
			m.setQty(rs.getString("qty"));
			m.setJname(rs.getString("jname"));
			m.setPrice(rs.getInt("price"));
			li.add(m);

		}
		return li;
		
		
	}

	public int insertjumun(Jumun jumun) throws UnsupportedEncodingException, SQLException {

		Connection conn = getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into jmnumber " + "values (?,?,? )");
		// mapping
		pstmt.setString(1, jumun.getJno());
		pstmt.setString(2, jumun.getJname());
		pstmt.setInt(3, jumun.getPrice());

		// 4)excute
		int num = pstmt.executeUpdate();
		return num;

	}
	
}