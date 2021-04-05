package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _04_addNewItem implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setAttribute("type", new Integer(0));
		
		return "/04_addNewItem.jsp";
	}
}
