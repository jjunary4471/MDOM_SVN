<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/JavaScript"
	src=http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js></script>
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>月次書類管理システム</title>
</head>
<body>
<iframe src="header/header.jsp" height="80px" width="100%" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0>
</iframe>
	<s:form theme="simple" action="reviewMonthlyDoc">
		<h1><p align="center">月次書類確認一覧画面</p></h1><br>
		
		<h2><p style="margin-left: 150px">交通費明細表</p></h2>		
		<p align="right"style="margin-right: 160px;">並べ替え
			<select style="width: 90px">
				<option>社員名順</option>
				<option>所属部署順</option>
				<option>職級</option>
				<option>月次書類状態</option>
				<option>依頼実施日</option>
			</select>
		
			<s:submit value="検索"></s:submit>	
		</p>	
	
	<table rules="all" border="1" style="margin-left: 220px; width: 70%">
		<tr style="width: 448px; height: 44px">
			<td width="5%" align="center">選択</td>
			<td align="center">社員番号</td>
			<td align="center">社員名</td>
			<td align="center">所属部署</td>
			<td align="center" style="width: 8px;">職位</td>
			<td align="center">月次書類状態</td>
			<td align="center">依頼実施日</td>
			<td align="center">確認者</td>
			<td align="center">確認完了日</td>
		</tr>
		<tr>
			<td align="center"><s:checkbox name="chk01"/></td>
			<td align="center" style="height: 9px;">70551290</td>
			<td align="center" style="height: 9px;">徐東駿</td>
			<td align="center" style="height: 9px;" align="center">GCNSSI2D</td>
			<td align="center" style="height: 9px;" align="center">MB</td>
			<td style="height: 9px; padding-left: 8px" align="left">1：作成中</td>
			<td align="center" style="height: 9px;" align="center">2016/07/05</td>
			<td align="center" style="height: 9px;" align="center">高反尺</td>
			<td align="center" style="height: 9px;" align="center">2016/07/07</td>
		</tr>
		<tr>
			<td align="center"><s:checkbox name="chk02"/></td>
			<td align="center" style="height: 9px;">70551291</td>
			<td align="center" style="height: 9px;">徐西駿</td>
			<td align="center" style="height: 9px;" align="center">GCNSSI2D</td>
			<td align="center" style="height: 9px;" align="center">MB</td>
			<td style="height: 9px; padding-left: 8px" align="left">0：未着手</td>
			<td align="center" style="height: 9px;" align="center">2016/07/05</td>
			<td align="center" style="height: 9px;" align="center">高反尺</td>
			<td align="center" style="height: 9px;" align="center">2016/07/07</td>
		</tr>
		<tr>
			<td align="center"><s:checkbox name="chk03"/></td>
			<td align="center" style="height: 9px;">70551292</td>
			<td align="center" style="height: 9px;">徐南駿</td>
			<td align="center" style="eight: 9px;" align="center">GCNSSI2D</td>
			<td align="center" style="height: 9px;" align="center">MB</td>
			<td style="height: 9px; padding-left: 8px" align="left">2：確認依頼済</td>
			<td align="center" style="height: 9px;" align="center">2016/07/05</td>
			<td align="center" style="height: 9px;" align="center">高反尺</td>
			<td align="center" style="height: 9px;" align="center">2016/07/07</td>
		</tr>
		<tr>
			<td align="center" align="center"><s:checkbox name="chk04"/></td>
			<td align="center" style="height: 9px;">70551293</td>
			<td align="center" style="height: 9px;">徐北駿</td>
			<td align="center" style="height: 9px;" align="center">GCNSSI2D</td>
			<td align="center" style="height: 9px;" align="center">MB</td>
			<td style="height: 9px; padding-left: 8px" align="left">3：確認完了</td>
			<td align="center" style="height: 9px;" align="center">2016/07/05</td>
			<td align="center" style="height: 9px;" align="center">高反尺</td>
			<td align="center" style="height: 9px;" align="center">2016/07/07</td>
		</tr>
	</table>
	
	<table style="margin-left: 350px; margin-top: 10px; width: 60%">
		<tr align="right">
			<td><s:submit value="書類確認"></s:submit></td>
		</tr>
	</table>
	
	<br><h2><p style="margin-left: 150px">休暇申請・報告書</p></h2>
		<p align="right" style="margin-right: 160px">並べ替え
			<select style="width: 90px">
				<option>社員名順</option>
				<option>所属部署</option>
				<option>開始日順</option>
				<option>休暇区分</option>
			</select>
			
		<s:submit value="検索"></s:submit>	
		</p>	
	
		<table rules="all" border="1" style="margin-left: 220px; width: 70%">
		<tr style="width: 448px; height: 44px">
			<td align="center" style="height: 9px;">社員番号</td>
			<td align="center" style="height: 9px;">社員名</td>
			<td align="center" style="height: 9px;">月次状態年月</td>
			<td align="center" style="height: 9px">所属部署</td>
			<td align="center" style="height: 9px;">開始日</td>
			<td align="center" style="height: 9px;">終了日</td>
			<td align="center" style="height: 9px;">休暇区分</td>
			<td align="center" style="width: 20%; height: 9px;">休暇事由</td>
			<td align="center" style="height: 9px;"></td>
		</tr>
		<tr>
			<td align="center" style="height: 9px;">70551290</td>
			<td align="center" style="height: 9px;">徐東駿</td>
			<td align="center" style="height: 9px;">16年07月</td>
			<td align="center" style="eight: 9px;" align="center">GCNSSI2D</td>			
			<td align="center" style="height: 9px;" align="center">2016/07/01</td>
			<td align="center" style="height: 9px;" align="center">2016/07/01</td>
			<td style="height: 9px; padding-left: 8px">短期：全日休暇</td>
			<td style="height: 9px; padding-left: 8px">健康検診</td>
			<td align="center" style="height: 9px;" align="center"><s:submit value="表示"></s:submit></td>
		</tr>
		<tr>
			<td align="center" style="height: 9px;">70551291</td>
			<td align="center" style="height: 9px;">徐西駿</td>
			<td align="center" style="height: 9px;">16年07月</td>
			<td align="center" style="eight: 9px;" align="center">GCNSSI2D</td>			
			<td align="center" style="height: 9px;" align="center">2016/07/01</td>
			<td align="center" style="height: 9px;" align="center">2016/07/01</td>
			<td style="height: 9px; padding-left: 8px">短期：全日休暇</td>
			<td style="height: 9px; padding-left: 8px">新人教育</td>
			<td align="center" style="height: 9px;" align="center"><s:submit value="表示"></s:submit></td>
		</tr>
		<tr>
			<td align="center" style="height: 9px;">70551292</td>
			<td align="center" style="height: 9px;">徐南駿</td>
			<td align="center" style="height: 9px;">16年07月</td>
			<td align="center" style="eight: 9px;" align="center">GCNSSI2D</td>			
			<td align="center" style="height: 9px;" align="center">2016/07/02</td>
			<td align="center" style="height: 9px;" align="center">2016/07/02</td>
			<td style="height: 9px; padding-left: 8px">短期：全日休暇</td>
			<td style="height: 9px; padding-left: 8px">代休</td>
			<td align="center" style="height: 9px;" align="center"><s:submit value="表示"></s:submit></td>
		</tr>
		<tr>
			<td align="center" style="height: 9px;">70551293</td>
			<td align="center" style="height: 9px;">徐北駿</td>
			<td align="center" style="height: 9px;">16年07月</td>
			<td align="center" style="eight: 9px;" align="center">GCNSSI2D</td>			
			<td align="center" style="height: 9px;" align="center">2016/07/03</td>
			<td align="center" style="height: 9px;" align="center">2016/07/04</td>
			<td style="height: 9px; padding-left: 8px">長期：全日休暇</td>
			<td style="height: 9px; padding-left: 8px">年末年始</td>
			<td align="center" style="height: 9px;" align="center"><s:submit value="表示"></s:submit></td>
		</tr>
	</table>	
	</s:form>
	
</body>
</html>