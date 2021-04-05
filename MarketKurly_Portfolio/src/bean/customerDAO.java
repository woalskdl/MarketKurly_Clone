package bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class customerDAO {
	private customerDAO () {}
	
	private static customerDAO instance = new customerDAO();
	
	public static customerDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:/comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool");
		conn = ds.getConnection();
		
		return conn;
	}
	
	public int checkDoubleId(String id) {
		int check = -1;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT id FROM customer WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			}else {
				check = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null)
				try {pstmt.close();}catch(SQLException sqle) {}
			if(rs!=null)
				try {rs.close();}catch(SQLException sqle) {}
		}
		
		System.out.println("check = " + check);
		
		return check;
	}
	
	public int checkDoubleEmail(String email) {
		int check=-1;
		try {
			conn = getConnection();
			String sql = "SELECT email FROM customer WHERE email = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			}else{
				check = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null)
				try {pstmt.close();}catch(SQLException sqle) {}
			if(rs!=null)
				try {rs.close();}catch(SQLException sqle) {}
		}
		
		return check;
	}
	
	public void insertMember(String id, String pw, String name, String tel, String address, String email) {
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO customer VALUES(?,?,?,now(),?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, address);
			pstmt.setString(6, email);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null)
				try {pstmt.close();}catch(SQLException sqle) {}
			if(rs!=null)
				try {rs.close();}catch(SQLException sqle) {}
		}
	}
	
	public int userCheck(String id, String pw) {
		int check = -1;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM customer WHERE id = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			}
			System.out.println("check = " + check);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null)
				try {pstmt.close();}catch(SQLException sqle) {}
			if(rs!=null)
				try {rs.close();}catch(SQLException sqle) {}
		}
		
		return check;
	}
	
}
