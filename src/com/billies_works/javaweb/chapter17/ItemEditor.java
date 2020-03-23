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
 * 商品管理画面で商品を選択、そこからIDを引き継ぎ、itemテーブルから
 * 情報を取得しなおす。
 * その結果を editItem.jspに渡す。
 */
public class ItemEditor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException {

        String id = Encoder.encodeUTF8(request.getParameter("id"));
        String resultPage = PropertyLoader.getProperty("url.jsp.error");

        try {
            ItemDAO dao = new ItemDAO();
            ItemBean item = dao.getItemById(id);
            request.setAttribute("item", item);
            resultPage = PropertyLoader.getProperty("url.jsp.editItem");
        } catch (NamingException e) {
            request.setAttribute("errorMessage", e.getMessage());
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }
}

