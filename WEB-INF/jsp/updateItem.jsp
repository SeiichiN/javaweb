<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.billies_works.javaweb.chapter17.bean.ItemBean"
         import="com.billies_works.javaweb.chapter17.util.PropertyLoader" %>

<% ItemBean item = (ItemBean) request.getAttribute("item"); %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8"/>
    <title>商品を更新</title>
    <link href="css/table.css" rel="stylesheet"/>
  </head>
  <body>
    <h1>商品を更新</h1>

    <form method="get" action="<%=
                               PropertyLoader.getProperty("url.servlet.ItemUpdate2") %>">
      <table>
        <caption>変更する項目を上書きしてください。</caption>
        <tr>
          <th>ID</th>
          <th>商品名</th>
          <th>価格</th>
          <th> </th>
        </tr>
        <tr>
          <td><input type="text" name="id" value="<%= item.getId() %>"/></td>
          <td><input type="text" name="name" value="<%= item.getName() %>"/></td>
          <td><input type="text" name="price" value="<%= item.getPrice() %>"/></td>
          <td><input type="submit" value="更新"/></td>
        </tr>
        <tr>
          <td colspan="4"><a href="<%= PropertyLoader.getProperty("url.servlet.ItemManager") %>">キャンセル</a></td>
        </tr>
      </table>
      <input type="hidden" name="oldId" value="<%= item.getId() %>"/>
    </form>
  </body>
</html>


<!-- 修正時刻： Mon Mar 23 20:45:41 2020 -->
