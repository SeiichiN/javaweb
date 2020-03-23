<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.billies_works.javaweb.chapter17.util.PropertyLoader" %>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>エラー</title>
  </head>
  <body>
    <h1>エラー</h1>
    <table id="error">
      <caption>${errorMessage}</caption>
      <tr>
        <td><a href='<%= PropertyLoader.getProperty("url.servlet.ItemManager") %>'>
        商品管理</a></td>
      </tr>
    </table>
  </body>
</html>

<!-- 修正時刻： Mon Mar 23 07:13:51 2020 -->
