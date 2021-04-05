package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.managerDAO;

public class _02_managerMain implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		managerDAO dao = managerDAO.getInstance();
		
		int memberCnt = dao.customerCnt();
		int itemCnt = dao.itemCnt();
		int orderCnt = dao.orderCnt();
		
		request.setAttribute("memberCnt", memberCnt);
		request.setAttribute("itemCnt", itemCnt);
		request.setAttribute("orderCnt", orderCnt);
		
		request.setAttribute("type", new Integer(0));
		
		return "/02_managerMain.jsp";
	}
}
