package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.cartDAO;

public class _08_deleteCart implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		int cart_num = Integer.parseInt(request.getParameter("cart_number"));
		System.out.println("delCartNum : " + cart_num);
		
		cartDAO.getInstance().deleteCart(cart_num);
		request.setAttribute("type", new Integer(1));
		
		return "/08_deleteCart.jsp";
	}
}
