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
import com.billies_works.javaweb.chapter17.util.Encoder;
import com.billies_works.javaweb.chapter17.util.PropertyLoader;

public class ItemSelector extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException {

        String id = Encoder.encodeUTF8(request.getParameter("id"));
        String name = Encoder.encodeUTF8(request.getParameter("name"));
        String stringPrice = Encoder.encodeUTF8(request.getParameter("price"));
        String resultPage = PropertyLoader.getProperty("url.jsp.error");

        try {
            int price = Integer.MAX_VALUE;

            if (id.length() == 0) {
                id = "%";
            }

            if (name.length() == 0) {
                name = "%";
            }

            if (stringPrice.length() != 0) {
                price = Integer.parseInt(stringPrice);
            }

            ItemDAO dao = new ItemDAO();
            List<ItemBean> itemList = dao.getItemListConditionally(id, name, price);
            request.setAttribute("itemList", itemList);
            resultPage = PropertyLoader.getProperty("url.jsp.selectItem");

        } catch (NamingException e) {
            request.setAttribute("errorMessage", e.getMessage());
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage",
                                 PropertyLoader.getProperty("message.NumberFormatException"));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }
}
