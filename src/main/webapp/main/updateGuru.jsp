<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function(){
        //调用form的表单的load方法
        console.log("${param.id}");
        $("#updateGuruform").form('load',"${pageContext.request.contextPath}/guru/showOneGuru?id=${param.id}");
    });
</script>

<div style="text-align: center;">
<form id="updateGuruform" action="" method="post" class="easyui-form">
    <div style="margin-top: 20px">
        法师编号:<input class="easyui-textbox" name="id" readonly/>
    </div>
    <div style="margin-top: 20px">
        法师名字:<input class="easyui-textbox" name="name" />
    </div>
    <div style="margin-top: 20px">
        法师性别:<input class="easyui-switchbutton" data-options="onText:'男',value:'男',offText:'女'" name="gender" />
    </div>
    <div style="margin-top: 20px">
        法师状态:<input class="easyui-switchbutton" data-options="onText:'正常',value:'正常',offText:'封禁'" name="state"/>
    </div>
</form>
</div>