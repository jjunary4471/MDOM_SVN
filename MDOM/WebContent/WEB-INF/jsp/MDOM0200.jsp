<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月次書類管理システム</title>

<style type="text/css">
	.menuStyle {
		margin-left:280px;
		margin-top:200px;
	}
</style>

<script>
	function writeDsp() {
		parent.document.location.href="MakeMonthlyDoc.action";
	}
	
	function menu2() {
		var user_flg = <% out.print(session.getAttribute("s_user_auth_flg"));%>
		if(user_flg == 1) {
			parent.document.location.href="ConfirmMonthyDoc.action";
			return true;
		}else {
			alert('確認権限がありません。');
			return false;
		}
	}
</script>

</head>
<body>
<iframe src="header/header.jsp" height="80px" width="100%" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0>
</iframe>
<a href="#" onclick="writeDsp()"><img src="img/menu1.jpg" width="400px" class="menuStyle"></a>
<a href="#" onclick="return menu2()"><img src="img/menu2.jpg" width="400px"></a>

</body>
</html>