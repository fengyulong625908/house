<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0032)http://localhost:8080/HouseRent/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户登录</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>

<link rel="stylesheet" type="text/css" href="../scripts/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../scripts/easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../scripts/easyUI/css/demo.css">
<script src="../scripts/js/jquery-1.8.3.js"></script>
<script src="../scripts/js/jquery.easyui.min.js"></script>
<script language="JavaScript">
    var timeobj;
  $(function () {
      $("#button").click(function () {
          $('#user').form('submit', {
                  url:"login",
          success:function(data){
              if (data>0) {
                  $.messager.alert('提示','登入成功','info');
                  window.location.href="/page/getHouseByUser"
              }else {
                  $.messager.alert('提示','登入失败','error');

              }
          }
          });
      })

      $("#button3").click(function () {
          $('#login').form('submit', {
              url:"login2",
              success:function(data){
                  if (data>0) {
                      $.messager.alert('提示','登入成功','info');
                      window.location.href="/page/getHouseByUser"
                  }else {
                      $.messager.alert('提示','登入失败','error');

                  }
              }
          });
      })

      $("#getCode").click(function () {
          var v=$("#tel").val();
          $.post("getCode",{"tel":v},function (data) {
            if (data.mgs>0) {
                timeobj=setInterval("goback()",1000);
                window.alert("发送成功")
            }else {
                window.alert("发送失败")
            }
          },"json")
      })
  })
    var time=60;
    function goback(){
        time--;
        if(time==0) {
            $("#getCode").val("重新发送");
            time=60;
            clearInterval(timeobj); //消除定时
        }
        else {
            $("#getCode").val(time);
        }
    }

</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DIV class=box>
<H4>用户登录</H4>
<FORM id=user method=post name=user action=/page/login>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD colSpan=2></TD></TR>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><!-- <input type="text" class="text" name="name" /> --><INPUT
      id=user_name class=text type=text name=userName> </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><!-- <input type="password" class="text" name="password" /> --><INPUT 
      id=user_password class=text type=password name=password> </TD></TR>

						</TBODY></TABLE>
<DIV class=buttons> <INPUT  value=登陆 type=button id="button"> <INPUT onclick='document.location="regs.jsp"' value=注册 type=button>
</DIV></DIV></FORM>
  <Form action="login2" method="post" id="login">
    <table>
      <tr>
        <td class="field">手机号：</td>
        <td><input type="text"    name="tel" id="tel" />
          <input type="button" value="获取验证码" id="getCode" />
        </td>
      </tr>
      <tr>
        <td class="field">验 证 码：</td>
        <td><input type="text"  name="inputCode" />
          <input type="button" value="登录" id="button3">
        </td>
      </tr>
    </table>
  </Form>
</DIV></DIV></DIV>


<DIV id=footer class=wrap>
<DL>

  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
