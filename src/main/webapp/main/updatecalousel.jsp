<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function(){
        //调用form的表单的load方法
        $("#updatecalouselform").form('load',"${pageContext.request.contextPath}/carousel/showid?id=${param.id}");
    });
</script>

<div style="text-align: center;">
<form id="updatecalouselform" action="" method="post" class="easyui-form">
    <div style="margin-top: 20px">
        图片编号:<input class="easyui-textbox" name="id" readonly/>
    </div>
    <div style="margin-top: 20px">
        图片标题:<input class="easyui-textbox" name="headline" />
    </div>
    <div style="margin-top: 20px">
        图片描述:<input class="easyui-textbox" name="describ" />
    </div>
    <div style="margin-top: 20px">
        图片状态:<input class="easyui-switchbutton" data-options="onText:'展示',value:'展示',offText:'不展示'" name="status"/>
    </div>
</form>
</div>