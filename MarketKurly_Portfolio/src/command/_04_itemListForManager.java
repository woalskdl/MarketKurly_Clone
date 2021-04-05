package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.itemDAO;
import bean.itemDTO;

public class _04_itemListForManager implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<itemDTO> registeredItemList = itemDAO.getInstance().getAllItem();
		int cnt = registeredItemList.size();
		
		if(cnt > 0) {
			request.setAttribute("registeredItemList", registeredItemList);
		}
		
		request.setAttribute("type", new Integer(0));
		request.setAttribute("cnt", new Integer(cnt));
		
		return "/04_itemListForManager.jsp";
	}
}
