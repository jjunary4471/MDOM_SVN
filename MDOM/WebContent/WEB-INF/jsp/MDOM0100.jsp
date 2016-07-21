<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>月次書類管理システム</title>
</head>

<style type="text/css">
	#center { position:absolute; top:60%; left:50%; width:500px; height:200px; overflow:hidden; margin-top:-150px; margin-left:-100px;}
	
	#title { position:absolute; top:50%; left:47%; width:500px; height:200px; overflow:hidden; margin-top:-170px; margin-left:-100px;}
</style>

<script type="text/javascript">
	function validate()
	{
		var id = document.getElementById("userId").value;
		var pw = document.getElementById("userPassword").value;
		var chk;
		
		if(id.length == 0 || pw.length == 0) {
			alert('社員番号とバスワードを全て入力してください。')
			return false;
		}
		
		return true;
	}
	
	 function idcheck(){
     	var id = document.getElementById("userId").value;
     	
     	 if(id.length < 8) {
     		alert('社員番号は8桁で入力してください。')
     		document.loginForm.userId.value="";
     	}
     	 
     	for(var i=0; i<id.length; i++) {
     		var c = id.charCodeAt(i);
     		
     		if((c <= 0xff61 && c >= 0xff9f) || c > 256) {
     			alert('社員番号は全角で入力してください。')
     			document.loginForm.userId.value="";
     			break;
     		}
     	}
     }
	 
	 function pwcheck() {
		 var pw = document.getElementById("userPassword").value;
		 
		 if(pw.length < 6) {
			 alert('パスワードは6桁以上、16桁以下で入力してください。')
			 document.loginForm.userPassword.value="";
		 }
	 }
</script>

<body>
<%
	String checkFlag = (String)request.getAttribute("checkFlag");
%>

	<div id="title">
		<h1>月次書類管理システム</h1>
	</div>
	<div id="center">
		<s:form name="loginForm" action="loginAction" onsubmit='return validate();' >
			<s:textfield name="userId" id="userId" label="社員番号" size="20" maxlength="8" onblur="idcheck();"/>
			<s:password name="userPassword" id="userPassword" label="パスワード" size="20" maxlength="16" onblur="pwcheck();"/>
			<s:submit name="loginBtn" value="ログイン"/>
			
			<%
				if(checkFlag == "0") {
			%>
				<script>
					alert('社員番号またはパスワードが正しくありません。');
					location.href="Login.action";
				</script>
			<%
				checkFlag = null;
				}
			%>
		</s:form>
	</div>
</body>
</html>