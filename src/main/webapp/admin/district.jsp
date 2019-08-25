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
    <script language="JavaScript" src="js/district.js"></script>
</head>
<body>
<table id="dg" ></table>
<%--工具栏--%>
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:addDistrict()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:upDateDistrict()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteDistrict()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除多条</a>
    </div>
</div>
<%--添加窗口--%>
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="form1" method="post">
        <table>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" name="name"  /></td>
            </tr>

        </table>
    </form>
</div>
<%--定义保存对话框的按钮--%>
<div id="AddDialogButtons">
    <a href="javascript:SaveDistrict()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:CloseDialog('AddDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<%--修改窗口--%>
<div id="upDateDialog" class="easyui-dialog" buttons="#upDateDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="form2" method="post">
        <table>
            <tr>
                <td>区域名称:</td>
                <td><input type="hidden" name="id" id="hd"></td>
                <td><input type="text" name="name" /></td>
            </tr>

        </table>
    </form>
</div>
<%--定义保存对话框的按钮--%>
<div id="upDateDialogButtons">
    <a href="javascript:SaveupDateDistrict()" class="easyui-linkbutton"
       iconCls="icon-ok">更新</a> <a href="javascript:CloseDialog('upDateDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<!--显示街道对话框-->
<div id="showStreetDialog" class="easyui-dialog" buttons="#showStreetDialogButtons"
     style="width: 500px; height: 350px; padding: 10px 20px;" closed="true">
    <table id="dgStreet">
    </table>
    <form method="post"  id="form3" name="form1">
        <input type="hidden" id="hidden3" name="districtId">
        街道名称:<input type="text" name="name" id="name2">
        <input type="button" value="添加" onclick="addStreet()">
    </form>
    <div id="showStreetDialogButtons">
     <a href="javascript:CloseDialog('showStreetDialog')"
                                       class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
</div>
</body>
</html>
