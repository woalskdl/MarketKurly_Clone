package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.itemDAO;
import bean.itemDTO;

public class _04_showCategory implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String cat = request.getParameter("category");
		int category = 0;
		if(cat != null) {
			category = Integer.parseInt(cat);
		}
		ArrayList<itemDTO> itemList = itemDAO.getInstance().getCategory(category);
		
		String categoryName="";
		if(category == 100){
			categoryName = "채소";
		}else if(category == 200){
			categoryName = "해산물";
		}else if(category == 300){
			categoryName = "육류";
		}else if(category == 400){
			categoryName = "전자제품";
		}else if(category == 0) {
			categoryName = "전체상품";
		}
		
		if(itemList != null)
			request.setAttribute("itemList", itemList);
		
		request.setAttribute("category", category);
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("type", new Integer(1));
		
		return "/04_showItems.jsp";
	}
}
