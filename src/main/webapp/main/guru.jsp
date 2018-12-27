<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $('#guru').datagrid({
        toolbar:[{
            text:'添加',
            iconCls:'icon-add',
            onClick:addguru,
        },{
            text:'修改',
            iconCls:'icon-pencil',
            onClick:showguru,
        },{
            text:'删除',
            iconCls:'icon-cancel',
            onClick:deleguru,
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
        url:"${pageContext.request.contextPath}/guru/findAllGuru",
        columns:[[
            {field:'name',title:'法号',width:200,sortable:true},
            {field:'gender',title:'性别',width:100,align:'right',sortable:true},
            {field:'state',title:'状态',width:100,align:'right',sortable:true},
            {field:'photo',title:'照片路径',width:150,sortable:true}
        ]],
        view:detailview,
        detailFormatter: function(rowIndex, rowData){
        return '<table><tr>' +
            '<td rowspan=2 style="border:0"><img src='+rowData.photo+' style="height:50px;"></td>' +
            '<td style="border:0">' +
            '<p>编号: ' + rowData.id + '</p>' +
            '<p>性别: ' + rowData.gender + '</p>' +
            '<p>路径: ' + rowData.photo+ '</p>' +
            '</td>' +
            '</tr></table>';
    }
    });
    /**
     * 添加轮播图
     */
    function addguru(){
        $("#addGuru").dialog({
            title:'添加轮播图',
            width:600,
            height:400,
            href:"${pageContext.request.contextPath}/main/addguru.jsp",
            buttons:[{
                text:"保存",
                iconCls:"icon-save",
                handler:function(){
                    //提交修改的form表单
                    $("#addguruform").form('submit',{
                        url:"${pageContext.request.contextPath}/guru/addGuru",
                        success:function(){
                            //提示信息
                            $.messager.show({title:"提示",msg:"添加成功！！！"});
                            //刷新datagrid
                            $("#guru").datagrid('reload');
                            $("#addGuru").dialog('close');
                        }
                    });
                }
            },{text:"关闭",iconCls:"icon-cancel",handler:function(){
                    //关闭对话框
                    $("#addGuru").dialog('close');
                }
            }],
        });
    }
    /**
     * 修改功能
     */
    function showguru(){
        //调用datagrid返回选中所有行的方法
        var rows = $("#guru").datagrid('getSelected');
        if(rows == null){
            $.messager.alert('警告','请选中一行数据！！！');
        }else{
            $("#uGuru").dialog({
                title:'修改数据',
                width:600,
                height:400,
                href:"${pageContext.request.contextPath}/main/updateGuru.jsp?id="+rows.id,
                buttons:[
                    {
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function(){
                            //提交修改的form表单
                            $("#updateGuruform").form('submit',{
                                url:"${pageContext.request.contextPath}/guru/updateGuru",
                                success:function(){
                                    //提示信息
                                    $.messager.show({title:"提示",msg:"修改成功"});
                                    //刷新datagrid
                                    $("#guru").datagrid('reload');
                                    $("#uGuru").dialog('close');
                                }
                            });
                        }
                    },
                    {text:"关闭",iconCls:"icon-cancel",handler:function(){
                            //关闭对话框
                            $("#uGuru").dialog('close');
                        }
                    },
                ]
            });
        }
    }
    /**
     * 删除
     */
    function deleguru(){
        //调用datagrid返回选中所有行的方法
        var rows = $("#guru").datagrid('getSelected');
        if(rows == null){
            $.messager.alert('警告','请选中一行数据！！！');
        }else{
            $.messager.confirm("提示","您确定要删除当前所选的数据吗？",function(r){
                if(r){
                    //发送ajax请求删除所有选中
                    $.ajax({
                        type:"POST",
                        url:"${pageContext.request.contextPath}/guru/deleteguru",
                        data:{id:rows.id},
                        dataType:"JSON",
                    });
                    $("#guru").datagrid('reload');
                    //提示信息
                    $.messager.show({title:"提示",msg:"数据删除成功！！！"});
                }
            });
        }
    }
</script>

<table id="guru"></table>


<div id="addGuru"></div>


<div id="uGuru"></div>

