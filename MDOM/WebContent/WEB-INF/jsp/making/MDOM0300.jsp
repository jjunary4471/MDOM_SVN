<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
#tr_center {
	text-align: center;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>月次書類作成画面</title>
</head>
<body>
	<h2>月次書類作成画面</h2>
	<h3>
		交通費作成状態(20<s:property value="#request.documentYear" />年<s:property value="#request.documentMonth" />月)
	</h3>
	<input type="button" value="今月書類" />
	<font size="2">*対象月が前月の場合、クリックしてください。</font>
	<br>
	<table width="1100px" rules="all" border="1"
		style="table-layout: fixed">
		<tr style="width: 1100px; height: 30px;">
			<td id="tr_center" style="width: 80px;">社員番号</td>
			<td id="tr_center" style="width: 80px;">社員名</td>
			<td id="tr_center" style="width: 80px;">所属部署</td>
			<td id="tr_center" style="width: 80px;">職位</td>
			<td id="tr_center" style="width: 180px;">月次書類状態</td>
			<td id="tr_center" style="width: 80px;">依頼実施日</td>
			<td id="tr_center" style="width: 80px;">確認者</td>
			<td id="tr_center" style="width: 80px;">確認完了日</td>
			<td id="tr_center" style="width: 320px;">差し戻し理由</td>
		</tr>
		<tr style="width: 1100px; height: 20px;">
			<td id="tr_center"><s:property value="documentInfo.USER_ID" /></td>
			<td id="tr_center"><s:property value="documentInfo.USER_ID" /></td>
			<td id="tr_center"><s:property value="documentInfo.USER_ID" /></td>
			<td id="tr_center"><s:property value="documentInfo.USER_ID" /></td>
			<td id="tr_center"><s:property value="documentInfo.TRNS_STATUS" /></td>
			<td id="tr_center"><s:property value="documentInfo.REQ_DAY" /></td>
			<td id="tr_center"><s:property value="documentInfo.AUTH_USER" /></td>
			<td id="tr_center"><s:property
					value="documentInfo.TRP_REJECT_REASON" /></td>
			<td><s:property value="documentInfo.USER_ID" /></td>
		</tr>
	</table>

	<s:form theme="simple">
		<table width="900px" style="table-layout: fixed">
			<tr>
				<td style="height: 95px">
					<h3>
						交通費登録<font style="font-weight: normal; font-size: 12px;">
							「*」は必須</font>
					</h3>
					<table>
						<tr>
							<td id="tr_center" style="width: 80px">勤務日 *</td>
							<td id="tr_center" style="width: 110px;">区間（開始） *</td>
							<td id="tr_center" style="width: 110px;">区間（到着） *</td>
							<td id="tr_center" style="width: 90px;">往復/片道 *</td>
							<td id="tr_center" style="width: 110px;">行先</td>
							<td id="tr_center" style="width: 165px;">乗物 *</td>
							<td id="tr_center" style="width: 60px;">金額 *</td>
							<td id="tr_center" style="width: 60px;">前渡金</td>
						</tr>

						<tr>
							<td><s:select list="{20160701,20160702}" /></td>
							<td><s:textfield cssStyle="width: 110px; " /></td>
							<td><s:textfield cssStyle="width: 110px; " /></td>
							<td><s:select list="{'往復','片道'}" /></td>
							<td><s:textfield cssStyle="width: 110px; " /></td>
							<td><s:textfield cssStyle="width: 165px; " /></td>
							<td><s:textfield cssStyle="width: 60px; " /></td>
							<td><s:textfield cssStyle="width: 60px; " /></td>
						</tr>
					</table>
					<table width="823px" style="table-layout: fixed">
						<tr>
							<td><font size="2">*定期券購入は乗物に入力してください。</font></td>
							<td align="right"><s:submit value="追加"></s:submit> <s:submit
									value="修正"></s:submit> <s:submit value="削除"></s:submit></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>

	<table style="width: 1140px;" style="table-layout: fixed">
		<tr>
			<td style="height: 95px"><h3>交通費明細一覧</h3>
				<table rules="all" border="1">
					<tr style="height: 30px;">
						<td id="tr_center" style="width: 40px">選択</td>
						<td id="tr_center" style="width: 180px">勤務日</td>
						<td id="tr_center" style="width: 160px;">区間(開始)</td>
						<td id="tr_center" style="width: 160px;">区間(到着)</td>
						<td id="tr_center" style="width: 80px;">往復/片道</td>
						<td id="tr_center" style="width: 160px;">行先</td>
						<td id="tr_center" style="width: 160px;">乗物</td>
						<td id="tr_center" style="width: 80px;">金額</td>
						<td id="tr_center" style="width: 80px;">前渡金</td>
					</tr>
				</table>
				<div
					style="overflow-y: scroll; overflow-x: hidden; width: 1140px; height: 200px;">
					<table rules="all" border="1">
					<s:iterator value="tr_InfoVOList" status="trList">
					<tr>
						<td id="tr_center" style="width: 40px"><s:property value="user_id"/></td>
						<td id="tr_center" style="width: 180px"><s:property value="kinmu_day"/></td>
						<td id="tr_center" style="width: 160px;">区間(開始)</td>
						<td id="tr_center" style="width: 160px;">区間(到着)</td>
						<td id="tr_center" style="width: 80px;">往復/片道</td>
						<td id="tr_center" style="width: 160px;">行先</td>
						<td id="tr_center" style="width: 160px;">乗物</td>
						<td id="tr_center" style="width: 80px;">金額</td>
						<td id="tr_center" style="width: 80px;">前渡金</td>
					</tr>
					</s:iterator>
					</table>
				</div></td>
			<table width="1140px" style="table-layout: fixed">
				<tr>
					<td align="right"><s:submit value="交通費確認"></s:submit></td>
				</tr>
			</table>
		</tr>
	</table>
	<table style="width: 1140px;">
		<tr>
			<td style="width: 1140px; height: 95px"><h3>休暇申請・報告書一覧</h3>
				<table rules="all" border="1">
					<tr style="height: 30px;">
						<td id="tr_center" style="width: 160px;">作成日</td>
						<td id="tr_center" style="width: 150px;">休暇区分</td>
						<td id="tr_center" style="width: 150px;">休暇理由</td>
						<td id="tr_center" style="width: 90px;">書類状態</td>
						<td id="tr_center" style="width: 90px;">依頼実施日</td>
						<td id="tr_center" style="width: 80px;">確認者</td>
						<td id="tr_center" style="width: 90px;">確認完了日</td>
						<td id="tr_center" style="width: 280px;">差し戻し理由</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><a href="url">2016年12月10日（水）</a></td>
						<td id="tr_center">短期：全日休暇</td>
						<td style="font-size:14px">一二三四五六七八九十</td>
						<td id="tr_center">2：承認要請</td>
						<td id="tr_center">2016/07/05</td>
						<td id="tr_center">高反尺</td>
						<td id="tr_center">2016/07/07</td>
						<td style="font-size:14px">一二三四五六七八九十一二三四五六七八</td>
						<td><input type="button" value="修正"></td>
						<td><input type="button" value="削除"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="1140px" style="table-layout: fixed">
					<tr>
						<td><font size="2">*作成日アンカーをクリックすると、休暇申請・報告書確認画面に移動します。</font></td>
						<td><s:submit value="新規作成"></s:submit></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>