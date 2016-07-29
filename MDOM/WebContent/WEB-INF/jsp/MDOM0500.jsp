
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/JavaScript"
	src=http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js></script>
<html>
<style>
tr {
	font-size: 14px;
}

#tr_align_center {
	text-align: center;
}

#tr_vertical_center {
	vertical-align: middle;
}

#tr_center {
	text-align: center;
	vertical-align: middle;
}
</style>
<script>
	function checkBox_only(index){
	    var obj = $("input[name=trans_checkbox]");
	    for(var i=0; i<obj.length; i++){
	        if(obj[i] != index){
	            obj[i].checked = false;
	        }
	    }
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>月次書類管理システム</title>
</head>
<body>
<iframe src="header/header.jsp" height="80px" width="100%" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0>
</iframe>
	<s:form theme="simple" action="reviewMonthlyDoc">
		<h1><p align="center">月次書類確認一覧画面</p></h1><br>
		<table rules="all" style="margin-left: 220px; width: 70%">
			<tr align="right">
				<td>並べ替え
				<select style="width: 90px">
					<option>番号名順</option>
					<option>社員名順</option>
					<option>所属部署順</option>
					<option>職級</option>
					<option>月次書類状態</option>
					<option>依頼実施日</option>
				</select>
				<input type="submit" value="検索"/>
				</td>
			</tr>
		</table>
	</s:form theme="simple" action="reviewMonthlyDoc">
	<s:form>
	<table rules="all" border="1" style="margin-left: 220px; width: 70%">
		<tr id="tr_center" style="width: 448px; height: 44px">
			<td width="5%">選択</td>
			<td>社員番号</td>
			<td>社員名</td>
			<td>所属部署</td>
			<td>職位</td>
			<td>月次書類状態</td>
			<td>依頼実施日</td>
			<td>確認者</td>
			<td>確認完了日</td>
		</tr>
		<s:iterator value="ts_ConfirmVOList">
			<tr id="tr_center">
				<td><s:checkbox name="trans_checkbox" onclick="checkBox_only(this)"/></td>
				<td id="trans_id"><s:property value="user_id"/></td>
				<td id="trans_name"><s:property value="user_name"/></td>
				<td id="dept"><s:property value="user_department_name"/></td>
				<td id="rank"><s:property value="user_rank_name"/></td>
				<td id="state"><s:property value="trns_status"/>:<s:property value="trns_status_name"/></td>
				<td id="requestDate"><s:property value="req_day"/></td>
				<td id="confirmor"><s:property value="auth_user_name"/></td>
				<td id="confirmDate"><s:property value="cpl_day"/></td>	
			</tr>
		</s:iterator>
	</table>
	
	<table style="margin-left: 350px; margin-top: 10px; width: 60%">
		<tr align="right">
			<td><s:submit value="書類確認"></s:submit></td>
		</tr>
	</table>
	</s:form>
	<br>
	<h2 style="margin-left:150px;">休暇申請・報告書</h2>
	<table rules="all" style="margin-left: 220px; width: 70%">
		<tr align="right">
			<td>並べ替え
			<select style="width: 90px">
				<option>社員番号順</option>
				<option>社員名順</option>
				<option>所属部署</option>
				<option>開始日順</option>
				<option>休暇区分</option>
			</select>
			<input type="submit" value="検索"/>
			</td>
		</tr>
	</table>
			
			
				
		<table rules="all" border="1" style="margin-left: 220px; width: 70%">
			<tr id="tr_center" style="width: 448px; height: 44px">
				<td>社員番号</td>
				<td>社員名</td>
				<td>月次状態年月</td>
				<td>所属部署</td>
				<td>開始日</td>
				<td>終了日</td>
				<td>休暇区分</td>
				<td style="width: 20%;">休暇事由</td>
				<td></td>
			</tr>
			<s:iterator value="hd_ConfirmVOList">
				<tr id="tr_center" >
					<td><s:property value="user_id"/></td>
					<td><s:property value="user_name"/></td>
					<td><s:property value="mk_day"/></td>
					<td><s:property value="user_department_name"/></td>
					<td><s:property value="hld_start"/></td> <%--開始日 --%>
					<td><s:property value="hld_end"/></td>　<%--終了日 --%>
					<td><s:property value="hld_kbn_category_name"/>:<s:property value="hld_kbn_item_name"/></td>
					<td><s:property value="hld_rsn"/></td>
					<td>
					<s:form name="hd_review_form" action="parameterTest" method="POST"
						enctype="multipart/form-data" theme="simple">
						<s:hidden name="hld_flag" value="2" />
						<s:hidden name="user_id" value="%{user_id}" />
						<s:hidden name="hld_mng_no" value="%{hld_mng_no}" />
						<s:submit name="hldReviewBtn" value="表示" />
					</s:form>
					</td>
				</tr>
			</s:iterator>
		</table>
</body>
</html>