package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.cartDAO;
import bean.cartDTO;

public class _07_cartInfo implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String id = request.getParameter("id");
		System.out.println("cartInfo : " + id);
		ArrayList<cartDTO> cartList = cartDAO.getInstance().getCartList(id);
		int cnt = cartDAO.getInstance().countItem(id);
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("cnt", cnt);
		request.setAttribute("type", new Integer(1));
		
		return "07_cartInfo.jsp";
	}
}
