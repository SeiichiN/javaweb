package com.billies_works.javaweb.chapter17;

import java.io.IOException;
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

/**
 * 
 * 
 * 
 */
public class ItemUpdate2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException {

        String id = Encoder.encodeUTF8(request.getParameter("id"));
        String name = Encoder.encodeUTF8(request.getParameter("name"));
        String stringPrice = Encoder.encodeUTF8(request.getParameter("price"));
        String oldId = Encoder.encodeUTF8(request.getParameter("oldId"));
        String resultPage = PropertyLoader.getProperty("url.jsp.error");

        if (id.length() != 0 && name.length() != 0 && stringPrice.length() != 0) {
            try {
                ItemDAO dao = new ItemDAO();
                ItemBean item = dao.getItemById(id);

                if (id.equals(oldId) || item.getId() == null) {
                    int price = Integer.parseInt(stringPrice);
                    dao.updateItem(id, name, price, oldId);
                    item = dao.getItemById(id);
                    request.setAttribute("item", item);
                    request.setAttribute("message",
                                         PropertyLoader.getProperty("message.completeUpdate"));
                    resultPage = PropertyLoader.getProperty("url.jsp.editComplete");
                } else {
                    resultPage = PropertyLoader.getProperty("url.jsp.error");
                    request.setAttribute("errorMessage",
                                         PropertyLoader.getProperty("message.duplication"));
                }
                
            } catch (NamingException e) {
                request.setAttribute("errorMessage", e.getMessage());
            } catch (SQLException e) {
                request.setAttribute("errorMessage", e.getMessage());
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", e.getMessage());
            }
        } else {
            resultPage = PropertyLoader.getProperty("url.jsp.error");
            request.setAttribute("errorMessage", PropertyLoader.getProperty("message.inputNull"));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }
}


// 修正時刻： Mon Mar 23 21:07:23 2020
