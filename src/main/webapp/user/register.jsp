<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
</head>
<body>
<form action="../user/register" method="post" enctype="multipart/form-data">
    <div style="text-align: center">
        <div style="margin-top: 20px">
            名字:<input class="easyui-textbox" data-options="required:true" name="name"/>
        </div>
        <div style="margin-top: 20px">
            法号:<input class="easyui-textbox" data-options="required:true" name="fname"/>
        </div>
        <div style="margin-top: 20px">
            性别:<input class="easyui-textbox" data-options="required:true" name="sex"/>
        </div>
        <div style="margin-top: 20px">
            电话:<input class="easyui-textbox" data-options="required:true" name="phone"/>
        </div>
        <div style="margin-top: 20px">
            密码:<input class="easyui-textbox" data-options="required:true" name="password"/>
        </div>
        <div style="margin-top: 20px">
            签名:<input class="easyui-textbox" data-options="required:true" name="signature"/>
        </div>
        <div style="margin-top: 20px">
            地区:<input class="easyui-textbox" data-options="required:true" name="region"/>
        </div>
        <div style="margin-top: 20px">
            上传头像:<input class="easyui-filebox" data-options="required:true,accept:'image/png,image/jpeg,image/gif'" name="imgs"/>
        </div>
        <div style="margin-top: 20px">
            <input type="submit" value="注册">
        </div>
    </div>
</form>
</body>
</html>
