package com.billies_works.javaweb.chapter17;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.billies_works.javaweb.chapter17.util.PropertyLoader;

/**
 * 商品追加画面への転送だけの役割
 * jspファイルをWEB-INFディレクトリに隠しているので、サーブレットから
 * 呼び出す
 */
public class ItemInsertion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException {

        String resultPage = PropertyLoader.getProperty("url.jsp.insertItem");
        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }
}
