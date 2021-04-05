package command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.itemDTO;
import bean.managerDAO;

public class _04_addNewItemPro implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("UTF-8");
		
		String realFolder = "";
		String fileName="";
		MultipartRequest imageup = null;
		
		String saveFolder = "/img";
		String encType = "UTF-8";
		int max_size = 2 * 1024 * 1024;
		
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		try {
			imageup = new MultipartRequest(request, realFolder, max_size, encType, new DefaultFileRenamePolicy());
			Enumeration<?> files = imageup.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				fileName = imageup.getFilesystemName(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String item_name = imageup.getParameter("name");
		String item_category = imageup.getParameter("category");
		String item_price = imageup.getParameter("price");
		String item_stock = imageup.getParameter("stock");
		String item_info = imageup.getParameter("info");
		String discount_rate = imageup.getParameter("discountRate");
		
		itemDTO dto = new itemDTO();
		dto.setItem_category(item_category);
		dto.setItem_name(item_name);
		dto.setItem_price(Integer.parseInt(item_price));
		dto.setItem_stock(Integer.parseInt(item_stock));
		dto.setItem_info(item_info);
		dto.setDiscount_rate(Integer.parseInt(discount_rate));
		
		if(fileName != null) {
			dto.setItem_image(fileName);
		}else {
			dto.setItem_image("error.jpg");
		}
		
		managerDAO dao = managerDAO.getInstance();
		dao.insertNewItem(dto);
		
		request.setAttribute("type", new Integer(0));
		
		return "/04_addNewItemPro.jsp";
	}
	
}
