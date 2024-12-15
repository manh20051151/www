<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Account List</title>
</head>
<body>
<center>
  <h1>Account Category List</h1>
</center>
<div style="display: flex; justify-content: center">
  <form action="list" method="post">
    account_id: <input type="text" name="account_id"/> <br/>
    fullName: <input type="text" name="fullName"/><br/>
    password: <input type="text" name="password"/><br/>
    email: <input type="text" name="email"/><br/>
    phone: <input type="text" name="phone"/><br/>
    status: <input type="text" name="status"/><br/>
    <input type="submit" value="Add" />
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
    <tr>
      <td>1</td>
      <td>Tran Thi Met</td>
      <td>123</td>
      <td>met@gmail.com</td>
      <td>0904567890</td>
      <td>1</td>
      <td>
        <a href="#">update</a>
        <a href="#">delete</a>
      </td>
    </tr>
    <tr>
      <td>2</td>
      <td>Nguyen Van Teo</td>
      <td>123</td>
      <td>teo@gmail.com</td>
      <td>0903123456</td>
      <td>1</td>
      <td>
        <a href="#">update</a>
        <a href="#">delete</a>
      </td>
    </tr>
  </table>
</div>
</body>
</html>
