package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class itemDAO {
	
	private itemDAO() {};
	
	private static itemDAO instance = new itemDAO();
	
	public static itemDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:/comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool");
		conn = ds.getConnection();
		
		return conn;
	}
	
	public ArrayList<itemDTO> getAllItem(){
		ArrayList<itemDTO> itemList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM item";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					itemDTO dto = new itemDTO();
					
					dto.setItem_number(rs.getInt("item_number"));
					dto.setItem_category(rs.getString("item_category"));
					dto.setItem_name(rs.getString("item_name"));
					dto.setItem_price(rs.getInt("item_price"));
					dto.setItem_stock(rs.getInt("item_stock"));
					dto.setItem_image(rs.getString("item_image"));
					dto.setItem_info(rs.getString("item_info"));
					dto.setDiscount_rate(rs.getInt("discount_rate"));
					dto.setReg_date(rs.getString("reg_date"));
					dto.setSold(rs.getInt("sold"));
					
					itemList.add(dto);
					
				}while(rs.next());
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
		
		return itemList;
	}
	
	public ArrayList<itemDTO> getCategory(int category){
		ArrayList<itemDTO> itemList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM item WHERE item_category = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					itemDTO dto = new itemDTO();
					
					dto.setItem_number(rs.getInt("item_number"));
					dto.setItem_category(rs.getString("item_category"));
					dto.setItem_name(rs.getString("item_name"));
					dto.setItem_price(rs.getInt("item_price"));
					dto.setItem_stock(rs.getInt("item_stock"));
					dto.setItem_image(rs.getString("item_image"));
					dto.setItem_info(rs.getString("item_info"));
					dto.setDiscount_rate(rs.getInt("discount_rate"));
					dto.setReg_date(rs.getString("reg_date"));
					dto.setSold(rs.getInt("sold"));
					
					itemList.add(dto);
					
				}while(rs.next());
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
		
		return itemList;
	}
	
	public ArrayList<itemDTO> getOneItem(int num){
		
		ArrayList<itemDTO> itemList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM item WHERE item_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				itemDTO dto = new itemDTO();
				
				dto.setItem_number(num);
				dto.setItem_category(rs.getString("item_category"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getInt("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setItem_info(rs.getString("item_info"));
				dto.setDiscount_rate(rs.getInt("discount_rate"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSold(rs.getInt("sold"));
				
				itemList.add(dto);
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
		
		return itemList;
	}
	
	public ArrayList<itemDTO> getNewItem(){
		ArrayList<itemDTO> newList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM item ORDER BY reg_date DESC;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				itemDTO dto = new itemDTO();
				
				dto.setItem_number(rs.getInt("item_number"));
				dto.setItem_category(rs.getString("item_category"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getInt("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setItem_info(rs.getString("Item_info"));
				dto.setDiscount_rate(rs.getInt("discount_rate"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSold(rs.getInt("sold"));
				
				newList.add(dto);
				
				i++;
				
				if (i > 8)
					break; 
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
		
		return newList;
	}
	
	public ArrayList<itemDTO> getBestItem(){
		ArrayList<itemDTO> bestList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM item ORDER BY sold DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				itemDTO dto = new itemDTO();
				
				dto.setItem_number(rs.getInt("item_number"));
				dto.setItem_category(rs.getString("item_category"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getInt("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setItem_info(rs.getString("Item_info"));
				dto.setDiscount_rate(rs.getInt("discount_rate"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSold(rs.getInt("sold"));
				
				bestList.add(dto);
				
				i++;
				
				if (i > 8)
					break; 
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
		
		return bestList;
	}
	
	public ArrayList<itemDTO> getDiscountedItem(){
		ArrayList<itemDTO> discountedList = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM item WHERE discount_rate >= 20";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				itemDTO dto = new itemDTO();
				
				dto.setItem_number(rs.getInt("item_number"));
				dto.setItem_category(rs.getString("item_category"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getInt("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setItem_info(rs.getString("Item_info"));
				dto.setDiscount_rate(rs.getInt("discount_rate"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSold(rs.getInt("sold"));
				
				discountedList.add(dto);
				
				i++;
				
				if (i > 8)
					break; 
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
		
		return discountedList;
	}
	
}
