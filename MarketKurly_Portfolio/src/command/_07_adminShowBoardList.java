package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.boardDAO;
import bean.boardDTO;

public class _07_adminShowBoardList implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int count = 0;
		int number = 0;
		
		int curPage = Integer.parseInt(pageNum);
		count = boardDAO.getInstance().getAllCount();
		
		int startRow = (curPage - 1) * pageSize;
		int endRow = curPage * pageSize;
		ArrayList<boardDTO> boardList = boardDAO.getInstance().getAllBoardList(startRow, endRow);
		
		number = count - (curPage - 1) * pageSize;
		
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1;
		if(curPage % pageSize != 0) {
			startPage = (int)(curPage / pageSize) * pageSize + 1;
		}else {
			startPage = ((int)(curPage / pageSize) - 1) * pageSize + 1;
		}
		
		int endPage = startPage + pageSize - 1;
		if(endPage > pageCount)
			endPage = pageCount;
		
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		System.out.println("count : " + count);
		System.out.println("curPage : " + curPage);
		
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("number", number);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("curPage", curPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("boardList", boardList);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		
		System.out.println(boardList.size());
		
		request.setAttribute("type", new Integer(0));
		
		return "/07_adminShowBoardList.jsp";
	}
}
