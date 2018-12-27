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
    <script>
        $(function(){
            //调用form的表单的load方法
            $("#asdasd").form('load',"${pageContext.request.contextPath}/user/findone?id=${param.id}");
        });
    </script>
</head>
<body>
<form id="asdasd" action="../user/update" method="post" >
    <div style="text-align: center">
        <div style="margin-top: 20px">
            编号:<input class="easyui-textbox" data-options="required:true" name="id" readonly/>
        </div>
        <div style="margin-top: 20px">
            名字:<input class="easyui-textbox" data-options="required:true" name="name"/>
        </div>
        <div style="margin-top: 20px">
            法号:<input class="easyui-textbox" data-options="required:true" name="fname"/>
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
            <input type="submit" value="修改">
        </div>
    </div>
</form>
</body>
</html>
