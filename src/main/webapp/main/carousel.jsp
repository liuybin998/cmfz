<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $('#carousel').datagrid({
        toolbar:[{
            text:'添加',
            iconCls:'icon-add',
            onClick:addcarousel,
        },{
            text:'修改',
            iconCls:'icon-pencil',
            onClick:showid,
        },{
            text:'删除',
            iconCls:'icon-cancel',
            onClick:dele,
        },{
            text:'保存',
            iconCls:'icon-disk',
        }],
        fit:true,
        pagination:true,
        pageList:[5,10,15,20],
        pageSize:5,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:"${pageContext.request.contextPath}/carousel/findallcarousel",
        columns:[[
            {field:'headline',title:'标题',width:100,sortable:true},
            {field:'status',title:'状态',width:100,align:'right',sortable:true},
            {field:'url',title:'路径',width:300,align:'right',sortable:true},
            {field:'time',title:'上传时间',width:150,sortable:true}
        ]],
        view:detailview,
        detailFormatter: function(rowIndex, rowData){
            console.log(rowData.url)
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src='+rowData.url+' style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>上传时间: ' + rowData.time + '</p>' +
                '<p>描述: ' + rowData.describ + '</p>' +
                '<p>路径: ' + rowData.url+ '</p>' +
                '</td>' +
                '</tr></table>';
        }
    });
    /**
     * 添加轮播图
     */
    function addcarousel(){
        $("#addcarousel").dialog({
            title:'添加轮播图',
            width:600,
            height:400,
            href:"${pageContext.request.contextPath}/main/addcarousel.jsp",
            buttons:[{
                text:"保存",
                iconCls:"icon-save",
                handler:function(){
                    //提交修改的form表单
                    $("#addcalouselform").form('submit',{
                        url:"${pageContext.request.contextPath}/carousel/addcarousel",
                        success:function(){
                            //提示信息
                            $.messager.show({title:"提示",msg:"添加成功！！！"});
                            //刷新datagrid
                            $("#carousel").datagrid('reload');
                            $("#addcarousel").dialog('close');
                        }
                    });
                }
            },{text:"关闭",iconCls:"icon-cancel",handler:function(){
                    //关闭对话框
                    $("#addcarousel").dialog('close');
                }
            }],
        });
    }
    /**
     * 修改功能
     */
    function showid(){
        //调用datagrid返回选中所有行的方法
        var rows = $("#carousel").datagrid('getSelected');
        if(rows == null){
            $.messager.alert('警告','请选中一行数据！！！');
        }else{
            $("#sid").dialog({
                title:'修改数据',
                width:600,
                height:400,
                href:"${pageContext.request.contextPath}/main/updatecalousel.jsp?id="+rows.id,
                buttons:[
                    {
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function(){
                            //提交修改的form表单
                            $("#updatecalouselform").form('submit',{
                                url:"${pageContext.request.contextPath}/carousel/update",
                                success:function(){//这里获取的json字符串
                                    //提示信息
                                    $.messager.show({title:"提示",msg:"修改成功"});
                                    //刷新datagrid
                                    $("#carousel").datagrid('reload');
                                    $("#sid").dialog('close');
                                }
                            });
                        }
                    },
                    {text:"关闭",iconCls:"icon-cancel",handler:function(){
                            //关闭对话框
                            $("#sid").dialog('close');
                        }
                    },
                ]
            });
        }
    }
    /**
     * 删除
     */
    function dele(){
        //调用datagrid返回选中所有行的方法
        var rows = $("#carousel").datagrid('getSelected');
        if(rows == null){
            $.messager.alert('警告','请选中一行数据！！！');
        }else{
            $.messager.confirm("提示","您确定要删除当前所选的数据吗？",function(r){
                if(r){
                    //发送ajax请求删除所有选中
                    $.ajax({
                        type:"POST",
                        url:"${pageContext.request.contextPath}/carousel/delete",
                        data:{id:rows.id},
                        dataType:"JSON",
                    });
                    $("#carousel").datagrid('reload');
                    //提示信息
                    $.messager.show({title:"提示",msg:"数据删除成功！！！"});
                }
            });
        }
    }
</script>
<%--布局--%>
<table id="carousel"></table>

<%--添加对话框--%>
<div id="addcarousel"></div>

<%--修改对话框--%>
<div id="sid"></div>
