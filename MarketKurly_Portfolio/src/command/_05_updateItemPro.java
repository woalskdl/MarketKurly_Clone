package command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.itemDTO;
import bean.managerDAO;

public class _05_updateItemPro implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		String realFolder = "";
		String fileName = "";
		MultipartRequest imageUp = null;
		
		String saveFolder = "/img";
		String encType = "UTF-8";
		int max_size = 1 * 1024 * 1024;
		
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		try {
			imageUp = new MultipartRequest(request, realFolder, max_size, encType, new DefaultFileRenamePolicy());
			Enumeration<?> files = imageUp.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				fileName = imageUp.getFilesystemName(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String item_name = imageUp.getParameter("name");
		String item_category = imageUp.getParameter("category");
		String item_price = imageUp.getParameter("price");
		String item_stock = imageUp.getParameter("stock");
		String item_info = imageUp.getParameter("info");
		String discount_rate = imageUp.getParameter("discount_rate");
		
		itemDTO dto = new itemDTO();
		
		dto.setItem_category(item_category);
		dto.setItem_name(item_name);
		dto.setItem_price(Integer.parseInt(item_price));
		dto.setItem_stock(Integer.parseInt(item_stock));
		dto.setItem_info(item_info);
		dto.setDiscount_rate(Integer.parseInt(discount_rate));
		
		if(fileName!=null){
			dto.setItem_image(fileName);
		}else{
			dto.setItem_image("error.jpg");
		}
		int item_number = Integer.parseInt(imageUp.getParameter("item_number"));
		
		System.out.println("item_number : " + item_number);
		System.out.println("item_name : " + item_name);
		System.out.println("item_category : " + item_category);
		System.out.println("item_price : " + item_price);
		System.out.println("item_stock : " + item_stock);
		System.out.println("item_info : " + item_info);
		System.out.println("discount_rate : " + discount_rate);
		
		managerDAO dao = managerDAO.getInstance();
		dao.updateItem(item_number, dto);
		request.setAttribute("type", new Integer(0));
		
		return "05_updateItemPro.jsp";
	}
}
