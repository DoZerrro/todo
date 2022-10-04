<%--
  Created by IntelliJ IDEA.
  User: kangdoyeong
  Date: 2022-10-04
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>TodoList</title>
</head>
<body>
 <h1>Todo List Page</h1>
    <%-- DAO 를 연결하여 list 출력
    <C:forEach items="${list}" var="item">
        <ul>
            <li>
                ${item.tno} ${item.title} ${item.memo} ${item.duedate} ${item.complete} <br/>
                ${item.regdate} ${item.moddate}
            </li>
        </ul>
    </C:forEach>--%>

     <C:forEach items="${list}" var="item">
         <ul>
             <li>
                     ${item.title} ${item.memo} ${item.duedate} ${item.complete} <br/>
                     ${item.regdate} ${item.moddate}
             </li>
         </ul>
     </C:forEach>

</body>
</html>
