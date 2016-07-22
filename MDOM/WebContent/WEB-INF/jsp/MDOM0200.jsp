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
</script>

</head>
<body>

<a href="#" onclick="writeDsp()"><img src="img/menu1.jpg" width="400px" class="menuStyle"></a>
<a href="#"><img src="img/menu2.jpg" width="400px" ></a>

</body>
</html>