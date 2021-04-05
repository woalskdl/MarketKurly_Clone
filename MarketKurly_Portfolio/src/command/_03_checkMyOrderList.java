package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.buyDAO;
import bean.buyDTO;

public class _03_checkMyOrderList implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String id = request.getParameter("id");
		System.out.println("checkMyOrderList id = " + id);
		ArrayList<buyDTO> buyList = buyDAO.getInstance().getBuyList(id);
		int cnt = buyList.size();
		System.out.println(cnt);
		
		request.setAttribute("buyList", buyList);
		request.setAttribute("cnt", cnt);
		request.setAttribute("type", new Integer(1));
		
		return "/03_checkMyOrderList.jsp";
	}
}
