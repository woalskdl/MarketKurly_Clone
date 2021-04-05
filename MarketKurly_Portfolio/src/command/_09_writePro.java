package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.boardDAO;
import bean.boardDTO;

public class _09_writePro implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String pw = request.getParameter("pw");
		String content = request.getParameter("content");
		
		System.out.println(writer);
		
		boardDTO dto = new boardDTO();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setPw(pw);
		dto.setContent(content);
		
		boardDAO.getInstance().insertBoard(dto);
		request.setAttribute("type", new Integer(1));
		
		return "/09_writePro.jsp";
	}
}
