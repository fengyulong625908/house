$(function(){
    //使用datagrid绑定数据库
    $('#dg').datagrid({
        url:'selectTypeAll',
        title:"区域信息",
        pagination:true,
        toolbar:"#ToolBar",
        pageSize:3,
        pageList:[3,6,10,20],
        columns:[[
            {field:'cb',checkbox:true,},
            {field:'id',title:'编号'},
            {field:'name',title:'类型'},
            {field:'s',title:'操作',
                formatter: function(value,row,index){
                    var str="<a  href= 'javascript:DeleteType()'  >删除</a>|<a href=javascript:upDateType()>修改</a>"
                    return str;
                }
            }
        ]]
    });
});
function addType() {
    /*打开添加的对话框*/

    $("#AddDialog").window("open")
    $("#AddDialog").window("setTitle","添加区域")

}

/*新增*/
function SaveType() {

    $('#form1').form('submit', {
        url:"addType",
        success:function(data){
            data=  $.parseJSON(data)
            if (data>0) {
                $.messager.alert('提示','添加成功','info');
                $("#AddDialog").window("close")
                $('#dg').datagrid('reload');

            }else {
                $.messager.alert('提示','添加失败','error');
                $("#AddDialog").window("close")
            }
        }
    });
}


/*打开修改的对话框*/
function upDateType() {
    var selectRow=$("#dg").datagrid('getSelections')
    if (selectRow.length==1) {
        $("#upDateDialog").window("open")
        $("#upDateDialog").window("setTitle","修改区域")
        $.post("selectOneType",{id: selectRow[0].id},function (data) {
            $("#form2").form('load',data); //将对象还原表单
        },"json")
    }else {
        $.messager.alert('提示','你选择了多行或者一行都没有选','error');
    }
}

/* 修改*/
function SaveUpDateType() {
    $('#form2').form('submit', {
        url:"updateType",
        type:"json",
        success:function(data){
            data=  $.parseJSON(data)
            if (data>0) {
                $.messager.alert('提示','修改成功','info');
                $("#upDateDialog").window("close")
                $('#dg').datagrid('reload');
            }else {
                $.messager.alert('提示','修改失败','error');
                $("#upDateDialog").window("close")
            }
        }
    });
}


/*删除*/
function DeleteType() {
    //获取选择行
    var SelectRows = $("#dg").datagrid('getSelections');
    var ids=[];
    if (SelectRows.length>0) {
        for (var i=0;i<SelectRows.length;i++) {
            ids.push(SelectRows[i].id)
        }

        $.messager.confirm("系统提示", "你确定要删除" + SelectRows.length + " 条数据吗?", function(or){
            if (or) {
                $.post("deleteTypes",{ids:ids.toString() },function (data) {
                    if (data>0) {
                        $.messager.alert('提示','删除数据成功','info');
                        $('#dg').datagrid('reload');
                    }else {
                        $.messager.alert('提示','删除数据失败','error');
                        $('#dg').datagrid('reload');
                    }
                },"json")
            }
        })
    }else {
        $.messager.alert('提示','请最少选择一行','error');
    }

}

/*关闭添加对话框*/
function CloseDialog(id) {
    $("#"+id).window("close")
    $("#dg")
}