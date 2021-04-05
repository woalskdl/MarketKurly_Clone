package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import command._00_shopMain;
import command._01_join;
import command._01_login;
import command._01_loginPro;
import command._01_managerLogin;
import command._01_managerLoginPro;
import command._02_checkDoubleEmail;
import command._02_checkDoubleId;
import command._02_joinPro;
import command._02_managerMain;
import command._03_checkMyOrderList;
import command._03_logout;
import command._03_managerLogout;
import command._04_addNewItem;
import command._04_addNewItemPro;
import command._04_itemListForManager;
import command._04_showAllItem;
import command._04_showBestItem;
import command._04_showCategory;
import command._04_showDiscountedItem;
import command._04_showNewItem;
import command._05_deleteItemPro;
import command._05_showOneItem;
import command._05_updateItem;
import command._05_updateItemPro;
import command._06_checkOrderList;
import command._06_insertCart;
import command._07_adminShowBoardList;
import command._07_cartInfo;
import command._07_showBoardListForCustomer;
import command._08_adminShowBoardContent;
import command._08_deleteCart;
import command._08_order;
import command._08_showBoardContent;
import command._09_delete;
import command._09_insertOrderList;
import command._09_update;
import command._09_updatePro;
import command._09_write;
import command._09_writeAnswer;
import command._09_writeAnswerPro;
import command._09_writePro;

@WebServlet(urlPatterns = {"*.do"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Object> commandMap = new HashMap<String, Object>();
    
    public void init() throws ServletException{
    	commandMap.put("/index.do", new _00_shopMain());
    	commandMap.put("/join.do", new _01_join());
    	commandMap.put("/login.do", new _01_login());
    	commandMap.put("/loginPro.do", new _01_loginPro());
    	commandMap.put("/managerLogin.do", new _01_managerLogin());
    	commandMap.put("/managerLoginPro.do", new _01_managerLoginPro());
    	commandMap.put("/managerMain.do", new _02_managerMain());
    	commandMap.put("/checkDoubleId.do", new _02_checkDoubleId());
    	commandMap.put("/checkDoubleEmail.do", new _02_checkDoubleEmail());
    	commandMap.put("/joinPro.do", new _02_joinPro());
    	commandMap.put("/logout.do", new _03_logout());
    	commandMap.put("/managerLogout.do", new _03_managerLogout());
    	commandMap.put("/checkMyOrderList.do", new _03_checkMyOrderList());
    	commandMap.put("/addNewItem.do", new _04_addNewItem());
    	commandMap.put("/addNewItemPro.do", new _04_addNewItemPro());
    	commandMap.put("/itemListForManager.do", new _04_itemListForManager());
    	commandMap.put("/showAllItem.do", new _04_showAllItem());
    	commandMap.put("/showNewItem.do", new _04_showNewItem());
    	commandMap.put("/showBestItem.do", new _04_showBestItem());
    	commandMap.put("/showDiscountedItem.do", new _04_showDiscountedItem());
    	commandMap.put("/showCategory.do", new _04_showCategory());
    	commandMap.put("/showOneItem.do", new _05_showOneItem());
    	commandMap.put("/updateItem.do", new _05_updateItem());
    	commandMap.put("/updateItemPro.do", new _05_updateItemPro());
    	commandMap.put("/deleteItemPro.do", new _05_deleteItemPro());
    	commandMap.put("/checkOrderList.do", new _06_checkOrderList());
    	commandMap.put("/insertCart.do", new _06_insertCart());
    	commandMap.put("/showBoardListForCustomer.do", new _07_showBoardListForCustomer());
    	commandMap.put("/adminShowBoardList.do", new _07_adminShowBoardList());
    	commandMap.put("/cartInfo.do", new _07_cartInfo());
    	commandMap.put("/showBoardContent.do", new _08_showBoardContent());
    	commandMap.put("/adminShowBoardContent.do", new _08_adminShowBoardContent());
    	commandMap.put("/order.do", new _08_order());
    	commandMap.put("/deleteCart.do", new _08_deleteCart());
    	commandMap.put("/write.do", new _09_write());
    	commandMap.put("/update.do", new _09_update());
    	commandMap.put("/updatePro.do", new _09_updatePro());
    	commandMap.put("/delete.do", new _09_delete());
    	commandMap.put("/writePro.do", new _09_writePro());
    	commandMap.put("/insertOrderList.do", new _09_insertOrderList());
    	commandMap.put("/writeAnswer.do", new _09_writeAnswer());
    	commandMap.put("/writeAnswerPro.do", new _09_writeAnswerPro());
    }
    
    protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String view = null;
    	CommandAction com = null;
    	
    	try {
    		String command = request.getRequestURI();
    		System.out.println(command);
    		if(command.indexOf(request.getContextPath()) == 0)
    			command = command.substring(request.getContextPath().length());
    		
    		com = (CommandAction)commandMap.get(command);
    		view = com.requestPro(request, response);
    		System.out.println("com = " + com);
    		System.out.println("view = " + view);
    	}catch (Throwable e) {
    		e.printStackTrace();
    	}
    	
    	request.setAttribute("cont", view);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    	dispatcher.forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

}
