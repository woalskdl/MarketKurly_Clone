package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class buyDAO {
	private buyDAO() {}
	
	private static buyDAO instance = new buyDAO();
	
	public static buyDAO getInstance() {
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
	
	public customerDTO getCustomerInfo(String id) {
		customerDTO dto = new customerDTO();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM customer WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
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
		
		return dto;
	}
	
	public ArrayList<cartDTO> getItemList(String id){
		ArrayList<cartDTO> cartList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM cart WHERE buyer = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cartDTO dto = new cartDTO();
				
				dto.setCart_number(rs.getInt("cart_number"));
				dto.setBuyer(rs.getString("buyer"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setBuy_price(rs.getInt("buy_price"));
				dto.setBuy_count(rs.getInt("buy_count"));
				dto.setItem_image(rs.getString("item_image"));
				
				cartList.add(dto);
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
		
		return cartList;
	}
	
	public void insertOrderList(buyDTO dto) {
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO buy(customer_id,customer_name,cart_number,item_name,buy_price,";
			sql += "buy_count,item_image,buy_date,howpay,address) VALUES(?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCustomer_id());
			pstmt.setString(2, dto.getCustomer_name());
			pstmt.setInt(3, dto.getCart_number());
			pstmt.setString(4, dto.getItem_name());
			pstmt.setInt(5, dto.getBuy_price());
			pstmt.setInt(6, dto.getBuy_count());
			pstmt.setString(7, dto.getItem_image());
			pstmt.setString(8, dto.getHowpay());
			pstmt.setString(9, dto.getAddress());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) 
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null) 
				try {pstmt.close();}catch(SQLException sqle) {}
		}
	}
	
	public void updateSold(String item_name, int buy_count) {
		int soldCnt = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT sold FROM item WHERE item_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				soldCnt = rs.getInt(1);
			}
			
			sql = "UPDATE item SET sold = ? WHERE item_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, soldCnt + buy_count);
			pstmt.setString(2, item_name);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) 
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null) 
				try {pstmt.close();}catch(SQLException sqle) {}
			
		}
	}
	
	public void deleteCartList(String id) {
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM cart WHERE buyer = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) 
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null) 
				try {pstmt.close();}catch(SQLException sqle) {}
		}
	}
	
	public ArrayList<buyDTO> getBuyList(String id){
		ArrayList<buyDTO> buyList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM buy WHERE customer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				buyDTO dto = new buyDTO();
				
				dto.setCustomer_id(rs.getString("customer_id"));
				dto.setCustomer_name(rs.getString("customer_name"));
				dto.setCart_number(rs.getInt("cart_number"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setBuy_price(rs.getInt("buy_price"));
				dto.setBuy_count(rs.getInt("buy_count"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setBuy_date(rs.getString("buy_date"));
				dto.setHowpay(rs.getString("howpay"));
				dto.setAddress(rs.getString("address"));
				
				buyList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) 
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null) 
				try {pstmt.close();}catch(SQLException sqle) {}
		}
		
		return buyList;
	}
	
}
