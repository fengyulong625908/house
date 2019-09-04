$(function(){
    $.post("/selectTypeAll2",null,function (data) {
        for(var i=0;i<data.length;i++){
            //创建节点
            var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
            //追加节点
            $("#type_id").append(node);
        }
    },"json");

    //1.发送异步请求获取区域，进行显示
    $.post("/selectDistrictAll2",null,function (data) {
        for(var i=0;i<data.length;i++){
            //创建节点
            var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
            //追加节点
            $("#district_id").append(node);
        }
        loadStreet();  //加载街道
    },"json");

    //给区域添加改变事件
    $("#district_id").change(loadStreet);

    //加载街道   代码复用
    function loadStreet(){
        //获取区域编号
        var did=$("#district_id").val();
        if(did!="") {
            //发送异步请求加载街道数据
            //清空原有数据项
            $("#street_id>option:gt(0)").remove();
            $.post("/selectStreetAllByDid2", {"did": did}, function (data) {

                for (var i = 0; i < data.length; i++) {
                    //创建节点
                    var node = $("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
                    //追加节点
                    $("#street_id").append(node);
                }
                //设置选中项
                $("#street_id").val();
            }, "json");
        }
    }

    //使用datagrid绑定数据库
    $('#dgHouse').datagrid({
        url:'getHouseByPass',
        title:"已审核的房子",
        pagination:true,
        toolbar:"#ToolBar",
        pageSize:3,
        pageList:[3,6,10,20],
        columns:[[
            {field:'cb',checkbox:true,},
            {field:'id',title:'编号'},
            {field:'title',title:'标题'},
            {field:'dname',title:'区域'},
            {field:'sname',title:'街道'},
            {field:'price',title:'价格'},
            {field:'tname',title:'房间类型'},
            {field:'floorage',title:'面积'},
            {field:'contact',title:'手机号'},
            {field:'s',title:'操作',
                formatter: function(value,row,index){
                    var str="<a  href= 'javascript:noPassHouse("+row.id+")'>取消审核</a> "
                    return str;
                }
            }
        ]]
    });

});
/*实现用户搜索功能*/
function houseSearch2(){
    var title=$("#inptitle").val();
    var tid=$("#type_id").val()
    var did=$("#district_id").val();
    var sid = $("#street_id").val()
    var end = $("#endPrice").val()
    var sar = $("#startPrice").val()
    $('#dgHouse').datagrid('load',{
        title: title,
        tid:tid,
        did:did,
        sid:sid,
        startPrice:sar,
        endPrice:end
    });
}
/*取消审核功能*/
function noPassHouse(id) {
    $.post("nOPassHouse",{id:id},function (date) {
        if (date.mgs>0) {
            $('#dgHouse').datagrid('reload');
        }else {
            $.messager.alert('提示','取消失败','info');
        }
    },"json")
}

  //加载事件
    //1.发送异步请求获取类型，进行显示












