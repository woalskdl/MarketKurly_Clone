package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _03_logout implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setAttribute("type", new Integer(1));
		
		return "/03_logout.jsp";
	}
}
