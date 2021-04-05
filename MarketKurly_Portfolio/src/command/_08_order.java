package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.buyDAO;
import bean.cartDTO;
import bean.customerDTO;

public class _08_order implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String id = request.getParameter("buyer");
		ArrayList<cartDTO> itemList = buyDAO.getInstance().getItemList(id);
		customerDTO customerBean = buyDAO.getInstance().getCustomerInfo(id);
		int total = Integer.parseInt(request.getParameter("total"));
		
		System.out.println(id);
		System.out.println(total);
		System.out.println(customerBean.getName());
		
		request.setAttribute("orderList", itemList);
		request.setAttribute("customer", customerBean);
		request.setAttribute("total", total);
		request.setAttribute("type", new Integer(1));
		
		return "/08_order.jsp";
	}
}
