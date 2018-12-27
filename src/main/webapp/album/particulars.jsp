<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
   $(function(){
       $.post("${pageContext.request.contextPath}/album/findOneAlbum?id=${param.id}",function(sss){

           $("#imgs").attr("src","../album/img"+sss.img);
           console.log(sss.name);
           $("#name").text(sss.name);
           $("#author").text(sss.author);
           $("#broadCast").text(sss.broadCast);
           $("#count").text(sss.count);
           $("#createDate").text(sss.createDate);
           $("#score").text(sss.score);
           $("#brief").text(sss.brief);
       },"JSON");
      /*  //调用form的表单的load方法
        $("#findOneAlbum").form('load',"${pageContext.request.contextPath}/album/findOneAlbum?id=${param.id}");
       console.log(${requestScope.img});*/
   });
</script>
    <form id="findOneAlbum" method="post" class="easyui-form">
        <div style="text-align:left;float:left;">
            <tr>
                <td><h3>专辑封面:</h3></td>
            </tr>
            <tr>
                <td><img id="imgs" style="width: 200px;height:200px;" <%--src="/cmfz_lyb/album/img/${requestScope.img}"--%>></td>
            </tr>
        </div>
        <div style="text-align: center">
            <br>
            <tr>
                <td><h3><span>专辑名字:</span><span id="name"></span></h3></td>
            </tr>
            <tr>
                <td><h3><span>专辑作者:</span><span id="author"></span></h3></td>
            </tr>
            <tr>
                <td><h3><span>专辑播音:</span><span id="broadCast"></span></h3></td>
            </tr>
            <tr>
                <td><h3><span>文章集数:</span><span id="count"></span></h3></td>
            </tr>
            <tr>
                <td><h3><span>创建时间:</span><span id="createDate"></span></h3></td>
            </tr>
            <tr>
                <td><h3><span>专辑评分:</span><span id="score"></span></h3></td>
            </tr>
            <tr>
                <td><h3><span>专辑描述:</span><span id="brief"></span></h3></td>
            </tr>
        </div>
    </form>

