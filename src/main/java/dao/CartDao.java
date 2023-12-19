package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void addToCart(String jno, String jname) throws SQLException {
    	
    	Connection conn = getConnection();             
    	PreparedStatement pstmt = conn.prepareStatement("select*from jmnumber where jname =?");
    	pstmt.setString(1,jname);
    	ResultSet rs = pstmt.executeQuery();
    	if(rs.next()) {
    	  
    	  Member m = new Member();
    	  m.setName(rs.getString("jname"));

    	  return;
    	}
    
    }	}   