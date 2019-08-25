<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="../scripts/js/jquery-1.8.3.js"></script>
<script language="JavaScript">
    $(function () {
       $.post("selectTypeAll",null,function (date) {
           for (var i=0;i<date.length;i++) {
               var node=$("<option value='"+date[i].id+"'>"+date[i].name+"</option>");
              $("#type_id").append(node)
           }
           $("#type_id").val(${house.streetId})
       },"json")


        $.post("selectDistrictAll",null,function (date) {
            for (var i=0;i<date.length;i++) {
                var node=$("<option value='"+date[i].id+"'>"+date[i].name+"</option>");
                $("#district_id").append(node)
            }
            $("#district_id").val(${house.did})
            loadStreet(${house.typeId})
        },"json")

        $("#district_id").change(loadStreet);

        //加载街道   代码复用
        function loadStreet(typeID){
            //获取区域编号
            var did=$("#district_id").val();
            //发送异步请求加载街道数据
            //清空原有数据项
            $("#street_id>option").remove();
            $.post("selectStreetAllByDid",{"did":did},function (data) {
                for(var i=0;i<data.length;i++){
                    //创建节点
                    var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                    //追加节点
                    $("#street_id").append(node);
                }
                $("#street_id").val(typeID)
            },"json");
        }


    })
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>修改房屋信息</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id="add_action" method=post
action="/page/updateHouse" enctype="multipart/form-data">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>

    <TD class=field>标　　题：</TD>
    <input type="hidden" name="id" value="${house.id}">
    <TD><INPUT id=add_action_title value="${house.title}" class=text type=text name=title> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class="text" name="typeId" id="type_id">

    </SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price value="${house.price}" class=text type=text name=price> </TD></TR>
  <TR>
    <TD class=field>发布日期：</TD>
    <TD><INPUT class=text type=date name=pubdate value="<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"/>"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=district_id id="district_id"></SELECT>
      街：<SELECT class=text
        name=streetId id="street_id"></SELECT> </TD></TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact value="${house.contact}" class=text type=text name=contact> </TD></TR>
  <tr>
    <TD class=field>房屋照片：</TD>
    <TD ><img src="http://localhost:80/${house.path}" height="100" width="100"></TD></tr>
  <TR>
    <TD class=field></TD>
      <INPUT id=deletePfile class=text type=hidden name=deletePfile value="${house.path}">
    <TD><INPUT id=pic class=text type=file name=pfile> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT  value="更新" type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
