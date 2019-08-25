<%--
  Created by IntelliJ IDEA.
  User: FYL
  Date: 2019/8/9
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>区域管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/house.js"></script>
</head>
<body>
<table id="dgHouse" ></table>
<%--工具栏--%>
<div id="ToolBar">
    <div style="height: 40px;">
       <%-- <a href="javascript:addDistrict()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:upDateDistrict()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteDistrict()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除多条</a>--%>
           标题<input type="text"  id="inptitle"  name="title"/>
           区域:<select id="district_id"  name="did">
           <option value="">请选择</option>
       </select>
           街道:<select id="street_id" name="sid">
           <option value="">请选择</option>
       </select>
           类型:<select id="type_id" name="tid">
           <option value="">请选择</option>
       </select>
           价格:<input type="tex" name="startPrice" size="8" id="startPrice">-
           <input name="endPrice" type="text" size="8"  id="endPrice">
        <a id="btn" href="javascript:houseSearch1();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    </div>
</div>

</body>
</html>
