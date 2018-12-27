<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

    <form id="addAlbumform" method="post"  enctype="multipart/form-data">
        <div style="text-align: center">

            <div style="margin-top: 20px">
                专辑名字:<input class="easyui-textbox" data-options="required:true" name="name"/>
            </div>
            <div style="margin-top: 20px">
                专辑作者:<input class="easyui-textbox" data-options="required:true" name="author"/>
            </div>
            <div style="margin-top: 20px">
                专辑播音:<input class="easyui-textbox" data-options="required:true" name="broadCast"/>
            </div>
            <div style="margin-top: 20px">
                专辑评分:<input class="easyui-textbox" data-options="required:true" name="score"/>
            </div>
            <div style="margin-top: 20px">
                专辑简介:<input class="easyui-textbox" data-options="required:true" name="brief"/>
            </div>
            <div style="margin-top: 20px">
                专辑封面:<input class="easyui-filebox" data-options="required:true,accept:'image/png,image/jpeg,image/gif'" name="Album"/>
            </div>

        </div>


    </form>

