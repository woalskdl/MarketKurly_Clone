package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.buyDTO;
import bean.managerDAO;

public class _06_checkOrderList implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<buyDTO> orderList = managerDAO.getInstance().getAllOrderList();
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("type", new Integer(0));
		
		return "06_checkOrderList.jsp";
	}
}
