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

public class ItemManager extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException {

        String resultPage = PropertyLoader.getProperty("url.jsp.error");
        int pageNo = 0;
        boolean isNextPage = false;
        boolean isPrevPage = false;
        
        // page -- 現在何ページめであるかという情報
        String param = request.getParameter("page");
        if (param != null && param.length() != 0) {
            String stringPageNo = Encoder.encodeUTF8(param);
            pageNo = Integer.parseInt(stringPageNo);
        }
        // count.pageView -- 1ページにつき何件表示するか。初期値は10。
        String stringCountPageView = PropertyLoader.getProperty("count.pageView");
        int countPageView = Integer.parseInt(stringCountPageView);

        // check
        System.out.println("pageNo:" + pageNo);
        System.out.println("countPageView:" + countPageView);
			
        try {
            ItemDAO dao = new ItemDAO();
            // 10件分あるいはそれ以下の次のデータを取得する
            List<ItemBean> itemList = dao.getItemListPage(pageNo, countPageView);
            // isNextPage -- 次のページがあれば、true
            isNextPage = isNext(dao, pageNo, countPageView);
            // isPrevpage -- 前のページがあれば、true
            isPrevPage = isPrev(pageNo, countPageView);
            // 次のデータ
            request.setAttribute("itemList", itemList);
            // 現在のページ番号
            request.setAttribute("page", pageNo);
            request.setAttribute("next", isNextPage);
            request.setAttribute("prev", isPrevPage);
            resultPage = PropertyLoader.getProperty("url.jsp.selectItem");
        } catch (NamingException e) {
            request.setAttribute("errorMessage", e.getMessage());
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }

    protected boolean isNext(ItemDAO dao, int pageNo, int countPageView) {
        boolean hantei = false;
        int nextPageNo = pageNo * countPageView + countPageView;
        System.out.println("nextPageNo:" + nextPageNo);
        //        try {
            System.out.println("Size:" + dao.getNumber());
            if (dao.getNumber() >= nextPageNo) {
                hantei = true;
                System.out.println("OKだよ!");
            } else {
                System.out.println("あかんやん!");
            }
        // } catch (NamingException e) {
        //     e.printStackTrace();
        // } catch (SQLException e) {
        //     System.out.println("ERRRRRR!");
        //     e.printStackTrace();
        // }
        return hantei;
    }

    protected boolean isPrev(int pageNo, int countPageView) {
        boolean hantei = false;
        int prevPageNo = pageNo * countPageView  - countPageView;
        if (prevPageNo >= 0) {
            hantei = true;
        } else {
            hantei = false;
        }
        return hantei;
    }
}

// 修正時刻： Fri Mar 27 08:18:52 2020
