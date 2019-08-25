$(function(){
    //使用datagrid绑定数据库
    $('#dgUsers').datagrid({
        url:'selectUserstAll',
        title:"用户信息",
        pagination:true,
        toolbar:"#ToolBar",
        pageSize:3,
        pageList:[3,6,10,20],
        columns:[[
            {field:'cb',checkbox:true,},
            {field:'id',title:'编号'},
            {field:'name',title:'用户名'},
            {field:'telephone',title:'手机号'},
            {field:'s',title:'操作',
                formatter: function(value,row,index){
                    var str="<a  href= 'javascript:DeleteDistrict()'  >删除</a>|<a href=javascript:upDateDistrict()>修改</a> "
                    return str;
                }
            }
        ]]
    });

});
/*实现用户搜索功能*/
function userSearch(){
    //取值
    var name=$("#inputname").val();

    var tel=$("#inputtel").val();

    $('#dgUsers').datagrid('load',{
        name: name,
        telephone: tel
    });
}









