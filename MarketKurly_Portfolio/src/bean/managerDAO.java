package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class managerDAO {
	
	private managerDAO() {}
	
	private static managerDAO instance = new managerDAO();
	
	public static managerDAO getInstance() {
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
	
	public int checkManager(String id, String pw) {
		int check = -1;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM manager WHERE id = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				check = 1;

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
	
	public int customerCnt() {
		int cnt = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT COUNT(*) FROM cart";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cnt = rs.getInt(1);
			
		}catch(Exception e) {
			
		}finally {
			if(conn!=null)
				try {conn.close();}catch(SQLException sqle) {}
			if(pstmt!=null)
				try {pstmt.close();}catch(SQLException sqle) {}
			if(rs!=null)
				try {rs.close();}catch(SQLException sqle) {}
		}
		
		return cnt;
	}
	
	public int itemCnt() {
		int cnt = 0;
		
		try{
			conn = getConnection();
			
			String sql = "SELECT COUNT(*) FROM item";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cnt = rs.getInt(1);
				
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
		
		return cnt;
	}
	
	public int orderCnt() {
		int cnt = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT COUNT(*) FROM buy";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		
		return cnt;
	}
	
	public void insertNewItem(itemDTO dto) {
		try {
			
			conn = getConnection();
			
			int num = 0;
			String sql = "SELECT MAX(item_number) FROM item";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			sql = "INSERT INTO item(item_number, item_category,item_name,item_price,";
			sql += "item_stock,item_image,item_info,discount_rate,reg_date,sold)  values(?,?,?,?,?,?,?,?,now(),0)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num + 1);
			pstmt.setString(2,  dto.getItem_category());
			pstmt.setString(3, dto.getItem_name());
			pstmt.setInt(4, dto.getItem_price());
			pstmt.setInt(5, dto.getItem_stock());
			pstmt.setString(6, dto.getItem_image());
			pstmt.setString(7, dto.getItem_info());
			pstmt.setInt(8, dto.getDiscount_rate());
			
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
	
	public void updateItem(int item_number, itemDTO dto) {
		try {
			conn = getConnection();
			
			int sold = 0;
			String sql = "SELECT sold FROM item WHERE item_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_number);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sold = rs.getInt(1);
			}
			
			sql = "UPDATE item SET item_category = ?, item_name = ?, item_price = ?, item_stock = ?";
			sql += ", item_image = ?, item_info = ?, discount_rate = ?, reg_date = now(), sold = ? WHERE item_number = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  dto.getItem_category());
			pstmt.setString(2, dto.getItem_name());
			pstmt.setInt(3, dto.getItem_price());
			pstmt.setInt(4, dto.getItem_stock());
			pstmt.setString(5, dto.getItem_image());
			pstmt.setString(6, dto.getItem_info());
			pstmt.setInt(7, dto.getDiscount_rate());
			pstmt.setInt(8, sold);
			pstmt.setInt(9, item_number);
			
			System.out.println(sql);
			
			System.out.println("item_number : " + item_number);
			System.out.println("category : " + dto.getItem_category());
			System.out.println("name : " + dto.getItem_name());
			System.out.println("price : " + dto.getItem_price());
			System.out.println("stock : " + dto.getItem_stock());
			System.out.println("image : " + dto.getItem_image());
			System.out.println("info : " + dto.getItem_info());
			System.out.println("discount_rate : " + dto.getDiscount_rate());
			
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
	
	public ArrayList<itemDTO> getOneItem(int item_number){
		ArrayList<itemDTO> list = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			
			String sql = "SELECT * FROM item WHERE item_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_number);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
				
				list.add(dto);
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
		
		return list;
	}
	
	public void deleteItem(int item_number) {
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM item WHERE item_number = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_number);
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
	
	public ArrayList<buyDTO> getAllOrderList(){
		
		ArrayList<buyDTO> orderList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM buy";
			
			pstmt = conn.prepareStatement(sql);
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
				
				orderList.add(dto);
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
		
		return orderList;
	}
	
}
