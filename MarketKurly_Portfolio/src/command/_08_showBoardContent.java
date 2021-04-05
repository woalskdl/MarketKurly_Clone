package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.boardDAO;
import bean.boardDTO;

public class _08_showBoardContent implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		ArrayList<boardDTO> bean = boardDAO.getInstance().getOneBoard(num);
		
		request.setAttribute("bean", bean);
		request.setAttribute("type", new Integer(1));
		
		return "08_showBoardContent.jsp";
	}
}
