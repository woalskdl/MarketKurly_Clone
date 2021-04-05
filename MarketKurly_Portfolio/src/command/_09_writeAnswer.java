package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.boardDAO;
import bean.boardDTO;

public class _09_writeAnswer implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		ArrayList<boardDTO> bean = boardDAO.getInstance().getOneBoard(num);
		
		int ref = bean.get(0).getRef();
		int re_step = bean.get(0).getRe_step();
		int re_level = bean.get(0).getRe_level();
		
		request.setAttribute("num", num);
		request.setAttribute("bean", bean);
		request.setAttribute("ref", ref);
		request.setAttribute("re_step", re_step);
		request.setAttribute("re_level", re_level);
		request.setAttribute("type", new Integer(0));
		
		return "/09_writeAnswer.jsp";
	}

}
