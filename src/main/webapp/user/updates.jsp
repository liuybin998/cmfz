<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<script>
    $(function(){
        //调用form的表单的load方法
        $("#updateuserform").form('load',"${pageContext.request.contextPath}/users/findOneUser?id=${param.id}");
    });
</script>

<div style="text-align: center;">
    <form id="updateuserform" method="post" class="easyui-form">
        <div style="margin-top: 20px">
            用户编号:<input type="text" style="border: none" name="id" readonly/>
        </div>
        <div style="margin-top: 20px">
            用户名:<input type="text" style="border: none" name="name" readonly/>
        </div>
        <div style="margin-top: 20px">
            法名:<input type="text" style="border: none" name="fname" readonly/>
        </div>
        <div style="margin-top: 20px">
            用户状态:<input class="easyui-switchbutton" data-options="onText:'正常',value:'正常',offText:'冻结'" name="status"/>
        </div>
    </form>
</div>
