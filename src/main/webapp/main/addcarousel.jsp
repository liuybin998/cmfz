<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<div style="text-align: center;">
<form id="addcalouselform" action="" method="post" enctype="multipart/form-data">
    <div style="margin-top: 20px">
        图片标题:<input class="easyui-textbox" data-options="required:true" name="headline"/>
    </div>

    <div style="margin-top: 20px">
        图片描述:<input class="easyui-textbox" data-options="required:true" name="describ"/>
    </div>
    <div style="margin-top: 20px">
        选择图片:<input class="easyui-filebox" data-options="required:true,accept:'image/png,image/jpeg,image/gif'" name="aa"/>
    </div>
    <div style="margin-top: 20px">
        图片状态:<input class="easyui-switchbutton" data-options="onText:'展示',value:'展示',offText:'不展示'" name="status"/>
    </div>
</form>
</div>