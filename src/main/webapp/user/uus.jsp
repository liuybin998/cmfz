<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div style="text-align: center">
    <h1>主页面</h1>
    <h2>欢迎${sessionScope.userLogin.name}</h2>
    <a href="../User/update.jsp?id=${sessionScope.userLogin.id}"><input type="button" value="修改资料"></a>
    <a href="../carousel/findimg"><input type="button" value="查看轮播图"></a>
    <a href="../album/findAlbum"><input type="button" value="查看专辑信息"></a>
</div>
</body>
</html>