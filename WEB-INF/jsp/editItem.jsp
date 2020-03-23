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
    <title>商品を編集</title>
    <link href="css/table.css" rel="stylesheet"/>
  </head>
  <body>
    <h1>商品を編集</h1>
    
    <table>
      <caption>編集内容を選択してください。</caption>
      <tr>
        <th>ID</th>
        <th>商品名</th>
        <th>価格</th>
        <th> </th>
        <th> </th>
      </tr>
      <tr>
        <td><%= item.getId() %></td>
        <td><%= item.getName() %></td>
        <td class="price"><%= NumberFormatUtility.formatCurrency(item.getPrice()) %></td>
        <td><a href="<%= PropertyLoader.getProperty("url.servlet.ItemUpdate") %>?id=<%= item.getId() %>">更新</a></td>
        <td><a href="<%= PropertyLoader.getProperty("url.servlet.ItemDeletion") %>?id=<%= item.getId() %>">削除</a></td>
      </tr>
      <tr>
        <td colspan="5"><a href="<%= PropertyLoader.getProperty("url.servlet.ItemManager") %>">キャンセル</a></td>
      </tr>
    </table>
  </body>
</html>


<!-- 修正時刻： Mon Mar 23 20:15:26 2020 -->
