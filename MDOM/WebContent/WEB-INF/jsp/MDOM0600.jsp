<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/JavaScript"
	src=http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>月次書類確認画面</title>
</head>
<body>
<h1>交通費明細表類確認画面</h1>
	<h3>
		(<span id="documentYear"><s:property
				value="#request.documentYear" /></span>年<span id=documentMonth><s:property
				value="#request.documentMonth" /></span>月)</h3>
	<table style="width: 1000px;">
		<tr>
			<td style="width: 900px; height: 95px"><h3>交通費明細一覧</h3>
				<table rules="all" border="1">
					<tr>
						<td style="width: 50px" align="center">日</td>
						<td style="width: 50px;" align="center">曜</td>
						<td style="width: 200px;" align="center">区 間</td>
						<td style="width: 60px;" align="center">行 先</td>
						<td style="width: 180px;" align="center">乗 物</td>
						<td style="width: 80px;" align="center">金 額</td>
						<td style="width: 80px;" align="center">前渡金</td>
						<td style="width: 100px;" align="center">残 高</td>
					</tr>
					</table>
					<div style="overflow-y: scroll; overflow-x: hidden; width: 1150px; height: 195px;">
					<table id="tr_Review_List_Table" rules="all" border="1">
						<s:iterator value="tr_ReviewVOList">
							<tr>
							<td style="display: none">
									<s:property value="kinmubi" />
							</td>
							<td style="display: none">
									<s:property value="yobi" />
							</td>
							<td style="display: none">
									<s:property value="kukan" />
							</td>
							<td style="display: none">
									<s:property value="ikisaki" />
							</td>
							<td style="display: none">
									<s:property value="norimono" />
							</td>
							<td style="display: none">
									<s:property value="kingaku" />
							</td>
							<td style="display: none">
									<s:property value="maekin" />
							</td>
							<td style="display: none">
									<s:property value="zandaka" />
							</td>							
							</tr>
						</s:iterator>
					</table>
					</div>
				</td>
		</tr>

	</table>
	<s:form>
		<table style="width: 820px;">
			<tr align="right">
				<td><input type="button" value="印刷"> <input
					type="button" value="交通費確認依頼"></td>
			</tr>
		</table>
	</s:form>
	<br>
	<s:form theme="simple">
		<table style="width: 921px;">
			<tr>
				<td style="width: 808px; height: 95px"><h3>休暇申請・報告書一覧</h3>
					<table rules="all" border="1">
						<tr>
							<td style="width: 160px;" align="center">開始日</td>
							<td style="width: 160px;" align="center">終了日</td>
							<td style="width: 120px;" align="center">休暇区分</td>
							<td style="width: 280px;" align="center">休暇理由</td>
							<td style="width: 40px;" align="center">書類状態</td>
						</tr>
						<tr>
							<td>2016年7月3日（水）</td>
							<td>2016年7月3日（水）</td>
							<td>短期：全日休暇</td>
							<td>チャズンナム</td>
							<td>2：承認要請</td>
						</tr>
						<tr>
							<td>2016年7月3日（水）</td>
							<td>2016年7月3日（水）</td>
							<td>長期：年末年始</td>
							<td>体調不良</td>
							<td>3：承認完了</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br>
</body>
</html>