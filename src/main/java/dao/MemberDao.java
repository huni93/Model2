package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jumun.Jumun;
import model.Member;

public class MemberDao {
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

	public int insertMember(Member member) throws UnsupportedEncodingException, SQLException {
		System.out.println(member);
		Connection conn = getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into member " + "values (?,?,?,?,?,?,?)");
		// mapping
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPassword());
		pstmt.setString(3, member.getPassCheck());
		pstmt.setString(4, member.getName());
		pstmt.setString(5, member.getEmail());
		pstmt.setString(6, member.getNickname());
		pstmt.setString(7, member.getTel());
		// 4)excute
		int num = pstmt.executeUpdate();
		return num;

	}

	public Member oneMember(String id) throws SQLException {

		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select*from member where id =?");
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {

			Member m = new Member();
			m.setId(rs.getString("id"));
			m.setPassword(rs.getString("password"));
			m.setPassCheck(rs.getString("passcheck"));
			m.setName(rs.getString("name"));
			m.setEmail(rs.getString("email"));
			m.setNickname(rs.getString("nickname"));
			m.setTel(rs.getString("tel"));
			return m;
		}
		return null;
	}

	public int updateMember(Member member) throws UnsupportedEncodingException, SQLException {
		Connection conn = getConnection();
		String sql = "update member set name=?,nickname=?,tel=?,email=? where id =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// mapping
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getNickname());
		pstmt.setString(3, member.getTel());
		pstmt.setString(4, member.getEmail());
		pstmt.setString(5, member.getId());
		// 4)excute
		int num = pstmt.executeUpdate();
		return num;

	}

	public int deleteMember(String id) throws UnsupportedEncodingException, SQLException {
		Connection conn = getConnection();
		String sql = "delete member where id =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// mapping
		pstmt.setString(1, id);
		// 4)excute
		int num = pstmt.executeUpdate();
		return num;
	}

	public int passMember(String id, String chgpass) throws UnsupportedEncodingException, SQLException {
		Connection conn = getConnection();
		String sql = "update member set password=? where id =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// mapping
		pstmt.setString(1, chgpass);
		pstmt.setString(2, id);
		// 4)excute
		int num = pstmt.executeUpdate();
		return num;
	}
	
	public List<Jumun> jumunList() throws UnsupportedEncodingException, SQLException {
		Connection conn = getConnection();
		String sql = "select * from jmnumber";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		List<Jumun>  li = new ArrayList<>();
		
		
		// 4)excute
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Jumun j = new Jumun();
			j.setJname(rs.getString(2));
			j.setJno(rs.getString(1));
			li.add(j);
		}
		
		return li;
		
	}
	

}// class end