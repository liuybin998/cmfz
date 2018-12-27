<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<div style="text-align: center;">
<form id="addguruform" action="" method="post" enctype="multipart/form-data">
    <div style="margin-top: 20px">
        法号:<input class="easyui-textbox" data-options="required:true" name="name"/>
    </div>
    <div style="margin-top: 20px">
        法师照片:<input class="easyui-filebox" data-options="required:true,accept:'image/png,image/jpeg,image/gif'" name="photos"/>
    </div>
    <div style="margin-top: 20px">
        法师性别:<input class="easyui-switchbutton" data-options="onText:'男',value:'男',offText:'女'" name="gender"/>

    </div>
    <div style="margin-top: 20px">
        法师状态:<input class="easyui-switchbutton" data-options="onText:'正常',value:'正常',offText:'封禁'" name="state"/>
    </div>
</form>
</div>