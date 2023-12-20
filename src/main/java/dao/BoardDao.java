package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Board;

public class BoardDao {

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
	 
	 public int insertBorad(Board board) throws UnsupportedEncodingException, SQLException {
	      	
	      Connection conn = getConnection();
	          
	         PreparedStatement pstmt = conn.prepareStatement("insert into myboard "
	        		  + "values (boardseq.nextval?,?,?,?,?,sysdate,0,?)");
	         //mapping
	         pstmt.setString(1,board.getName());
	         pstmt.setString(2,board.getPass());
	         pstmt.setString(3,board.getSubject());
	         pstmt.setString(4,board.getContent());
	         pstmt.setString(5,board.getFile1());
	         pstmt.setString(6,board.getBoardid());
	         
	         //4)excute
	         int num = pstmt.executeUpdate();
	         return num;
	                  
	   }
}
