$(function(){
    //使用datagrid绑定数据库
    $('#dg').datagrid({
        url:'selectDistrictAll',
        title:"区域信息",
        pagination:true,
        toolbar:"#ToolBar",
        pageSize:3,
        pageList:[3,6,10,20],
        columns:[[
            {field:'cb',checkbox:true,},
            {field:'id',title:'编号'},
            {field:'name',title:'区域名称'},
            {field:'s',title:'操作',
                formatter: function(value,row,index){
                    var str="<a  href= 'javascript:DeleteDistrict()'  >删除</a>|<a href=javascript:upDateDistrict()>修改</a> <a href=javascript:OpenShowStreetDialog("+row.id+")>查看街道</a>"
                    return str;
                }
            }
        ]]
    });
});

/*打开添加的对话框*/
function addDistrict() {
    $("#AddDialog").window("open")
    $("#AddDialog").window("setTitle","添加区域")
}
/*新增*/
function SaveDistrict() {

    $('#form1').form('submit', {
        url:"addDistrict",
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
function upDateDistrict() {
    var selectRow=$("#dg").datagrid('getSelections')
    if (selectRow.length==1) {
        $("#upDateDialog").window("open")
        $("#upDateDialog").window("setTitle","修改区域")
        $.post("selectDistrictOne",{id: selectRow[0].id},function (data) {
            $("#form2").form('load',data); //将对象还原表单
        },"json")
    }else {
        $.messager.alert('提示','你选择了多行或者一行都没有选','error');
    }
}

/*修改*/
function SaveupDateDistrict() {
    $('#form2').form('submit', {
        url:"updateDistrict",
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
function DeleteDistrict() {
    //获取选择行
    var SelectRows = $("#dg").datagrid('getSelections');
    var ids=[];
    if (SelectRows.length>0) {
        for (var i=0;i<SelectRows.length;i++) {
            ids.push(SelectRows[i].id)
        }

        $.messager.confirm("系统提示", "你确定要删除" + SelectRows.length + " 条数据吗?", function(or){
            if (or) {
                $.post("deleteDistrict",{ids:ids.toString() },function (data) {
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

function OpenShowStreetDialog(did) {
    $("#hidden3").val(did)
    $('#showStreetDialog').window('setTitle', "街道信息");
    $('#showStreetDialog').window("open");
    //发请求绑定数据
    $('#dgStreet').datagrid({
        url: 'selectStreetAllByDid?did=' + did,
        //toolbar:"#ToolBar",  //指定工具栏
        pagination: true,
        pageList: [3, 6, 9, 15, 20],
        pageSize: 3,
        //singleSelect:true,
        columns: [[
            {field: "cb", checkbox: true},
            {field: 'id', title: '编号', width: 100},
            {
                field: 'name', title: '街道名称', width: 100,
                formatter: function (value, row, index) {
                    var str = "<input type='text' value='" + value + "' id='street"+row.id+"'>";
                    return str;
                }
            },
            {
                field: 's', title: '操作', width: 200,
                formatter: function (value, row, index) {
                    var str = "<a href='javascript:updateStreet("+row.id+")'>更新</a>";
                    return str;
                }
            }
        ]]
    });
}
//修改街道
function updateStreet(id) {
 var name=  $("#street"+id).val()
   $.post("updateStreet",{name:name,id:id},function (date) {
       if (date>0) {
           $.messager.alert('提示','更新数据成功','info');
           $('#dgStreet').datagrid('reload');
       }else {
           $.messager.alert('提示','删除数据失败','error');
           $('#dgStreet').datagrid('reload');
       }
   })
}
//新增街道
function addStreet() {
    var districtId=$("#hidden3").val();
    var name=$("#name2").val()
    $.post("addStreet",{name:name,districtId:districtId},function (date) {
        if (date>0) {
            $.messager.alert('提示','更新数据成功','info');
            $('#dgStreet').datagrid('reload');
        }else {
            $.messager.alert('提示','更新数据失败','error');
            $('#dgStreet').datagrid('reload');
        }
    })

}

/*关闭添加对话框*/
function CloseDialog(id) {
    $("#"+id).window("close")
}


