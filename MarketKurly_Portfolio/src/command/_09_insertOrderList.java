package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.buyDAO;
import bean.buyDTO;
import bean.cartDAO;
import bean.cartDTO;
import bean.customerDTO;

public class _09_insertOrderList implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String customer_id = request.getParameter("id");
		customerDTO customerBean = buyDAO.getInstance().getCustomerInfo(customer_id);
		ArrayList<cartDTO> cartList = cartDAO.getInstance().getCartList(customer_id);
		int payhow = Integer.parseInt(request.getParameter("howPay"));
		String pay = "";
		
		System.out.println(customer_id);
		System.out.println(payhow);
		
		if(payhow == 1) {
			pay = "계좌이체";
		}else if(payhow == 2) {
			pay = "신용카드";
		}
		
		for(int i=0; i<cartList.size(); i++) {
			cartDTO bean = cartList.get(i);
			
			String customer_name = customerBean.getName();		
			int cart_number = bean.getCart_number();
			String item_name = bean.getItem_name();	
			int buy_price = bean.getBuy_price();
			int buy_count = bean.getBuy_count();
			String item_image = bean.getItem_image();		
			String howpay = pay;		
			String address = customerBean.getAddress();
			
			System.out.println("item_name : " + item_name);
			System.out.println("buy_count : " + buy_count);
			
			buyDTO dto = new buyDTO();
			dto.setCustomer_id(customer_id);
			dto.setCustomer_name(customer_name);
			dto.setCart_number(cart_number);
			dto.setItem_name(item_name);
			dto.setBuy_price(buy_price);
			dto.setBuy_count(buy_count);
			dto.setItem_image(item_image);
			dto.setHowpay(howpay);
			dto.setAddress(address);
			
			buyDAO.getInstance().insertOrderList(dto);
			buyDAO.getInstance().updateSold(item_name, buy_count);
		}
		
		buyDAO.getInstance().deleteCartList(customer_id);
		
		return "/09_insertOrderList.jsp";
	}
}
