
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $("#user").datagrid({
        toolbar:[{
            text:'修改用户状态',
            iconCls:'icon-pencil',
            onClick:updateS,
        }],
        fit:true,
        pagination:true,
        pageList:[5,10,15,20],
        pageSize:5,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:"${pageContext.request.contextPath}/users/findAllUser",
        columns:[[
            {field:'name',title:'用户名',width:100,sortable:true},
            {field:'fname',title:'法号',width:100,sortable:true},
            {field:'sex',title:'性别',width:100,sortable:true},
            {field:'phone',title:'用户电话',width:100,sortable:true},
            {field:'status',title:'状态',width:100,sortable:true},
            {field:'signature',title:'用户签名',width:100,sortable:true},

        ]],
        view:detailview,
        detailFormatter: function(rowIndex, rowData){
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src='+rowData.img+' style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>密码: ' + rowData.password + '</p>' +
                '<p>地区: ' + rowData.region + '</p>' +
                '<p>注册时间: ' + rowData.registertime+ '</p>' +
                '<p>盐值: ' + rowData.salt+ '</p>' +
                '</td>' +
                '</tr></table>';
        }
    });
   function updateS(){
        //获取当前选中行的信息
        var rows = $("#user").treegrid('getSelected');
       console.log(rows.id);
       $("#updatestatus").dialog({
            title:'修改用户状态',
            width:600,
            height:400,
            href:"${pageContext.request.contextPath}/User/updates.jsp?id="+rows.id,
            buttons:[{
                text:"保存",
                iconCls:"icon-picture_save",
                handler:function(){
                    //提交修改的form表单
                    $("#updateuserform").form('submit',{
                        url:"${pageContext.request.contextPath}/users/updates",
                        success:function(){
                            //提示信息
                            $.messager.show({title:"提示",msg:"修改成功！！！"});
                            //刷新datagrid
                            $("#user").datagrid('reload');
                            $("#updatestatus").dialog('close');
                        }
                    });
                }
            },{text:"关闭",iconCls:"icon-cancel",handler:function(){
                    //关闭对话框
                    $("#updatestatus").dialog('close');
                }
            }],
        });
    }




</script>

<%--用户模块--%>
<table id="user"></table>

<%--修改状态窗口--%>
<div id="updatestatus"></div>

