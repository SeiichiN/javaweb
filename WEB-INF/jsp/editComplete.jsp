<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.billies_works.javaweb.chapter17.util.NumberFormatUtility"
         import="com.billies_works.javaweb.chapter17.bean.ItemBean"
         import="com.billies_works.javaweb.chapter17.util.PropertyLoader" %>

<% ItemBean item = (ItemBean) request.getAttribute("item"); %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8"/>
    <title>編集完了</title>
    <link href="css/table.css" rel="stylesheet"/>
  </head>
  <body>
    <h1>編集完了</h1>
    
    <table>
      <tr>
        <th>ID</th>
        <th>商品名</th>
        <th>価格</th>
      </tr>
      <tr>
        <td><%= item.getId() %></td>
        <td><%= item.getName() %></td>
        <td class="price"><%= NumberFormatUtility.formatCurrency(item.getPrice()) %></td>
      </tr>
      <tr>
        <td colspan="3"><a href="<%= PropertyLoader.getProperty("url.servlet.ItemManager") %>">商品管理</a></td>
      </tr>
    </table>
  </body>
</html>


<!-- 修正時刻： Mon Mar 23 18:40:02 2020 -->
