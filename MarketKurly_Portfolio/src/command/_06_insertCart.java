package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.cartDAO;
import bean.cartDTO;
import bean.itemDAO;
import bean.itemDTO;

public class _06_insertCart implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String buyer = request.getParameter("buyer");
		System.out.println("Buyer : " + buyer);
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		ArrayList<itemDTO> bean = itemDAO.getInstance().getOneItem(item_number);
		
		String item_name = bean.get(0).getItem_name();
		int buy_price = bean.get(0).getItem_price() - bean.get(0).getItem_price()*bean.get(0).getDiscount_rate()/100;
		int buy_count = Integer.parseInt(request.getParameter("buyCnt"));
		String item_image = bean.get(0).getItem_image();
		
		cartDTO dto = new cartDTO();
		dto.setBuyer(buyer);
		dto.setItem_name(item_name);
		dto.setBuy_price(buy_price);
		dto.setBuy_count(buy_count);
		dto.setItem_image(item_image);
		
		cartDAO.getInstance().insertCart(dto);
		
		return "/06_insertCart.jsp";
	}
}
