package com.billies_works.javaweb.chapter17;

import java.io.IOException;
import java.util.List;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.naming.NamingException;

import com.billies_works.javaweb.chapter17.bean.ItemBean;
import com.billies_works.javaweb.chapter17.dao.ItemDAO;
import com.billies_works.javaweb.chapter17.util.PropertyLoader;

public class ItemManager extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String resultPage = PropertyLoader.getProperty("url.jsp.error");

				String stringPageNo = Encoder.encodeUTF8(request.getParameter("page"));
				if (stringPageNo != null && stringPageNo.length() != 0) {
					int pageNo = Integer.parseInt(stringPageNo);
				}
				String strigCountPageView = PropertyLoader.getProperty("count.pageView");
				int countPageView = Integer.parseInt(stringCountPageView);
			
			
        try {
            ItemDAO dao = new ItemDAO();
            // List<ItemBean> itemList = dao.getItemListAll();
            List<ItemBean> itemList = dao.getItemListPage(pageNo, countPageView);
            request.setAttribute("itemList", itemList);
            resultPage = PropertyLoader.getProperty("url.jsp.selectItem");
        } catch (NamingException e) {
            request.setAttribute("errorMessage", e.getMessage());
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }
}

// 修正時刻： Sun Mar 22 08:06:26 2020
