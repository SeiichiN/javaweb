<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.Iterator"
         import="java.util.List"
         import="com.billies_works.javaweb.chapter17.util.NumberFormatUtility"
         import="com.billies_works.javaweb.chapter17.bean.ItemBean"
         import="com.billies_works.javaweb.chapter17.util.Cast"
         import="com.billies_works.javaweb.chapter17.util.PropertyLoader" %>

<% List<ItemBean> itemList = Cast.castList(request.getAttribute("itemList"));
Iterator<ItemBean> iterator = itemList.iterator();
int pageNo = 0;
boolean isNext = false;
boolean isPrev = false;
if (request.getAttribute("page") != null) {
  pageNo = Cast.castInt(request.getAttribute("page"));
}
if (request.getAttribute("next") != null ) {
  isNext = Cast.castBoolean(request.getAttribute("next"));
}
if (request.getAttribute("prev") != null ) {
  isPrev = Cast.castBoolean(request.getAttribute("prev"));
}
int nextPage = pageNo + 1;
int prevPage = pageNo - 1; %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8"/>
    <title>商品管理</title>
    <link href="css/table.css" rel="stylesheet"/>
  </head>
  <body>
    <h1>商品管理</h1>
    <section class="left-side">
      <table>
        <caption>商品一覧</caption>
        <tr>
          <th>ID</th>
          <th>商品名</th>
          <th>価格</th>
          <th> </th>
        </tr>
        <% while (iterator.hasNext()) {
          ItemBean item = iterator.next(); %>
        <tr>
          <td><%= item.getId() %></td>
          <td><%= item.getName() %></td>
          <td class="price">
            <%= NumberFormatUtility.formatCurrency(item.getPrice())
            %></td>
          <td><a href="<%=
                       PropertyLoader.getProperty("url.servlet.ItemEditor")
                       %>?id=<%= item.getId() %>">編集</a></td>
        </tr>
      <% } %>
      <tr>
        <td colspan="4"><a href="<%=
                                 PropertyLoader.getProperty("url.servlet.ItemInsertion")
                                 %>">商品を追加</a></td>
      </tr>
      </table>

      <ul class="pagenation">
        <% if (isPrev) { %> 
          <li class="before"><a href="<%=
                                      PropertyLoader.getProperty("url.servlet.ItemManager")
                                      %>?page=<%= prevPage %>">前へ</a></li>
        <% } %>
        <% if (isNext) { %> 
          <li class="after"><a href="<%=
                                     PropertyLoader.getProperty("url.servlet.ItemManager")
                                     %>?page=<%= nextPage %>">次へ</a></li>
        <% } %>
      </ul>
    </section>

    <form method="get" action="<%=
                               PropertyLoader.getProperty("url.servlet.ItemSelector")
                               %>">
      <table>
        <caption>検索</caption>
        <tr>
          <th>IDで検索</th>
        </tr>
        <tr>
          <td><input type="text" name="id"/></td>
        </tr>
        <tr>
          <th>名前で検索</th>
        </tr>
        <tr>
          <td><input type="text" name="name"/></td>
        </tr>
        <tr>
          <th>金額(上限)で検索</th>
        </tr>
        <tr>
          <td><input type="text" name="price"/></td>
        </tr>
        <tr>
          <td><input type="submit" value="検索" name="submit"/></td>
        </tr>
        <tr>
          <td><a href="<%= PropertyLoader.getProperty("url.servlet.ItemManager")
                               %>">すべて表示</a></td>
        </tr>
      </table>
    </form>
  </body>
</html>

<!-- 修正時刻： Fri Mar 27 08:42:13 2020 -->
