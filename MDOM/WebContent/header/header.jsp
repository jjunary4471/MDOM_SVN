<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
div.shadow {
	width: 200px;
	height: 200px;
	border: 1px solid black;
	background-color: white;
	-webkit-box-shadow: 3px 3px 6px #adadad; /* Safari and Chrome */
	-moz-box-shadow: 3px 3px 6px #adadad; /* Firefox */
	box-shadow: 3px 3px 6px #adadad; /* CSS3 */
	filter: progid:DXImageTransform.Microsoft.Shadow(color=#adadad,
		Direction=135, Strength=6);
}
</style>
<script>
	function logout() {

		if (confirm("ログアウトしますか。") == true) { //확인
			parent.document.location.href = "LogoutAction.action";
		} else { //취소
			return;
		}

	}
</script>

</head>
<body>
	<div style="float: right;">
		<%
			out.print(session.getAttribute("s_user_dept_name"));
		%>
		&nbsp;
		<%
			out.print(session.getAttribute("s_user_name"));
		%>
		&nbsp;
		<%
			out.print(session.getAttribute("s_user_rank_name"));
		%>
		<input type="button" onclick="logout();" value="Logout">
	</div>
</body>
</html>