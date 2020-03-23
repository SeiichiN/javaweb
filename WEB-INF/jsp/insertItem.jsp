<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.billies_works.javaweb.chapter17.util.PropertyLoader" %>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>商品を追加</title>
    <link rel="stylesheet" href="css/table.css"/>
  </head>
  <body>
    <h1>商品を追加</h1>
    <form method="get" action="<%=
                               PropertyLoader.getProperty("url.servlet.ItemInsertion2") %>">
      <table>
        <caption>ID、名前、価格を入力してください。</caption>
        <tr>
          <th>ID</th>
          <th>名前</th>
          <th>価格</th>
          <th> </th>
        </tr>
        <tr>
          <td><input type="text" name="id"/></td>
          <td><input type="text" name="name"/></td>
          <td><input type="text" name="price"/></td>
          <td><input type="submit" value="追加"/></td>
        </tr>
        <tr>
          <td colspan="4">
            <a href="<%=
         PropertyLoader.getProperty("url.servlet.ItemManager") %>">キャ
         ンセル</a>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>

<!-- 修正時刻： Mon Mar 23 18:11:07 2020 -->
