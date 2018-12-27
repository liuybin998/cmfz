<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $('#album').treegrid({
        toolbar:[{
            text:'专辑详情',
            iconCls:'icon-folder_lightbulb',
            onClick:particulars,
        },{
            text:'添加专辑',
            iconCls:'icon-folder_add',
            onClick:addAlbum,
        },{
            text:'添加章节',
            iconCls:'icon-cdr_add',
            onClick:addChapter,
        },{
            text:'下载音频',
            iconCls:'icon-download',
            onClick:download,
        },{
            text:'删除所选',
            iconCls:'icon-cancel',
            onClick:deleteselect,
        }],
        pagination:true,
        url:"${pageContext.request.contextPath}/album/findAlbum",
        idField:'id',
        treeField:'name',
        fit:true,
        columns:[[
            {title:'名字',field:'name',width:200},
            {field:'url',title:'下载路径',width:400,align:'right'},
            {field:'size',title:'章节大小',width:300},
            {field:'time',title:'章节时长',width:300}
        ]]
    });

    /**
     * 删除所选 专辑或者章节
     */
    function deleteselect(){
        //获取当前选中行的信息
        var rows = $("#album").treegrid('getSelected');
        if(rows == null){
            $.messager.alert('警告','请选中一行数据！！！');
        }else{
            /**
             * 如果为null 说明选中的是章节
             *      此时次奥用删除单个章节的方法
             * 如果不为null  说明选中的专辑
             *      此时需要先根据 专辑id
             *      删除所有父类id为 此专辑id的数据
             *      然后再删除专辑信息
             */
            if(rows.children == null){
                $.messager.confirm("提示","您确定要删除当前所选章节吗？",function(r){
                    if(r){
                        //发送ajax请求删除所有选中
                        $.ajax({
                            type:"POST",
                            url:"${pageContext.request.contextPath}/chapter/deleteChap",
                            data:{id:rows.id,aid:rows.aid},
                            dataType:"JSON",
                        });
                        $("#album").treegrid('reload');
                        //提示信息
                        $.messager.show({title:"提示",msg:"数据删除成功！！！"});
                    }
                });
            }else{
                $.messager.confirm("提示","您确定要删除当前所选专辑吗？",function(r){
                    if(r){
                        //发送ajax请求删除所有选中
                        $.ajax({
                            type:"POST",
                            url:"${pageContext.request.contextPath}/album/deleteAlbum",
                            data:{id:rows.id},
                            dataType:"JSON",
                        });
                        $("#album").treegrid('reload');
                        //提示信息
                        $.messager.show({title:"提示",msg:"数据删除成功！！！"});
                    }
                });
            }
        }
    }

    /**
     * 下载章节
     */
    function download(){
        //获取当前选中行的信息
        var rows = $("#album").treegrid('getSelected');
        if(rows == null){
            $.messager.alert('警告','请选中一行数据！！！');
        }else{
            if(rows.children != null){
                $.messager.alert('提示','请选择您要下载的章节！！！');
            }else{
                window.location.href='${pageContext.request.contextPath}/chapter/download?url='+rows.url;
            }
        }
    }
    /**
     * 上传章节到某个专辑
     */
    function addChapter(){
        //获取当前选中行的信息
        var rows = $("#album").treegrid('getSelected');
        if(rows == null){
            $.messager.alert('警告','请选中一行数据！！！');
        }else{
            if(rows.children == null){
                $.messager.alert('提示','请选中专辑！！！');
            }else{
                $("#addchap").dialog({
                    title:'添加章节',
                    width:600,
                    height:400,
                    href:"${pageContext.request.contextPath}/album/addChap.jsp",
                    buttons:[{
                        text:'保存',
                        iconCls:'icon-picture_save',
                        handler:function(){
                            console.log(rows.id);
                            $("#addChapform").form('submit',{
                                url:'${pageContext.request.contextPath}/chapter/addChapter?aid='+rows.id,
                                success:function(){
                                    //提示信息
                                    $.messager.show({title:"提示",msg:"添加成功！！！"});
                                    //关闭对话框
                                    $("#addchap").dialog('close');
                                    //刷新datagrid
                                    $("#album").treegrid('reload');
                                }
                            })
                        }
                    },{
                        text:'关闭',
                        iconCls:"icon-cancel",
                        handler:function(){
                            $("#addchap").dialog('close');
                        }
                    }],
                });
            }
        }
    }
    /**
     * 添加专辑信息
     */
    function addAlbum(){
        $("#addalbum").dialog({
            title:'添加专辑',
            width:600,
            height:400,
            href:"${pageContext.request.contextPath}/album/addAlbum.jsp",
            buttons:[{
                text:'保存',
                iconCls:'icon-picture_save',
                handler:function(){
                    $("#addAlbumform").form('submit',{
                        url:"${pageContext.request.contextPath}/album/addAlbum",
                        success:function(){
                            //提示信息
                            $.messager.show({title:"提示",msg:"添加成功！！！"});
                            //关闭对话框
                            $("#addalbum").dialog('close');
                            //刷新datagrid
                            $("#album").treegrid('reload');
                        }
                    })
                }
            },{
                text:'关闭',
                iconCls:"icon-cancel",
                handler:function(){
                    $("#addalbum").dialog('close');
                }
            }]
        });
    }

    /**
     * 展示专辑的详细信息
     */
    function particulars(){
        var rows = $("#album").treegrid('getSelected');
        if(rows == null){
            $.messager.alert('警告','请选中一行数据！！！');
        }else{
            if(rows.children == null){
                $.messager.alert('提示','请选中专辑！！！');
            }else{
                $("#particulars").dialog({
                    title:'专辑详情',
                    width:600,
                    height:400,
                    //展示数据的页面
                    href:"${pageContext.request.contextPath}/album/particulars.jsp?id="+rows.id,
                    buttons:[{text:"关闭",iconCls:"icon-cancel",handler:function(){
                            //关闭对话框
                            $("#particulars").dialog('close');
                        }
                    }]
                });
            }
        }
    }
</script>



<%--专辑模块--%>
<table id="album"></table>

<%--展示专辑详情窗口--%>
<div id="particulars"></div>

<%--添加专辑 窗口--%>
<div id="addalbum"></div>

<%--添加章节窗口--%>
<div id="addchap"></div>