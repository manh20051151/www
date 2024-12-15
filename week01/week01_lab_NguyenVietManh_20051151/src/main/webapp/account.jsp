<%@ page import="com.example.week01_lab_nguyenvietmanh_20051151.entities.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/11/2024
  Time: 5:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function dodelete(id){
            if (confirm("ban muon xoa khong?")){
                window.location="delete?id="+id;
            }
        }
    </script>
</head>
<body>
<body>
<center>
    <h1>listttt category</h1>
</center>
<div style="display: flex; justify-content: center">
    <%
        if (request.getAttribute("err") != null){
            String err = request.getAttribute("err").toString();
    %>
    <h2><%=err%></h2>
    <%
        }
    %>
    <form action="list" method="post">
        account_id: <input type="text" name="account_id"/> <br/>
        fullName: <input type="text" name="fullName"/><br/>
        password: <input type="text" name="password"/><br/>
        email: <input type="text" name="email"/><br/>
        phone: <input type="text" name="phone"/><br/>
        status: <input type="text" name="status"/><br/>
        <input type="submit" value="add" />
    </form>

</div>
<div style="display: flex; justify-content: center">
    <table border="1px" width="60%">
        <tr>
            <th>account_id</th>
            <th>fullName</th>
            <th>password</th>
            <th>email</th>
            <th>phone</th>
            <th>status</th>
            <th>action</th>
        </tr>
        <%
            List<Account> list = (List<Account>) request.getAttribute("data");
            for (Account ca: list) {
        %>
        <tr>
            <td><%=ca.getId()%></td>
            <td><%=ca.getName()%></td>
            <td><%=ca.getpassword()%></td>
            <td><%=ca.getemail()%></td>
            <td><%=ca.getphone()%></td>
            <td><%=ca.getstatus()%></td>
            <td>
                <a href="update?id=<%=ca.getId()%>">update</a>
                <a href="#" onclick="dodelete('<%=ca.getId()%>')">delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
