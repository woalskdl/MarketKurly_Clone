package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.boardDAO;
import bean.boardDTO;

public class _09_writeAnswerPro implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boardDTO dto = new boardDTO();
		
		dto.setRef(ref);
		dto.setRe_step(re_step);
		dto.setRe_level(re_level);
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		boardDAO.getInstance().writeAnswer(dto);
		request.setAttribute("type", new Integer(0));
		
		return "/09_writeAnswerPro.jsp";
	}

}
