<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/JavaScript"
	src=http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js></script>
<html>
<style>
#tr_center {
	text-align: center;
}
</style>
<script>
	function transportCostAdd() {
		var trAddForm = document.tr_add_form;
		var numberCheck = /^[0-9]+$/;

		if (trAddForm.transStartPoint_in.value == '') {
			alert('区間(開始)の内容を入力してください。');
			trAddForm.transStartPoint_in.focus();
		} else if (trAddForm.transEndPoint_in.value == '') {
			alert('区間(到着)の内容を入力してください。');
			trAddForm.transEndPoint_in.focus();
		} else if (trAddForm.transPlan_in.value == '') {
			alert('乗物の内容を入力してください。');
			trAddForm.transPlan_in.focus();
		} else if (trAddForm.transCost_in.value == '') {
			alert('金額の内容を入力してください。');
			trAddForm.transCost_in.focus();
		} else if (!numberCheck.test(trAddForm.transCost_in.value)) {
			alert('金額は半角数字しか入力できません。');
			trAddForm.transCost_in.focus();
		} else if (!numberCheck.test(trAddForm.transAdvanceCost_in.value) && trAddForm.transAdvanceCost_in.value != '') {
			alert('前渡金は半角数字しか入力できません。');
			trAddForm.transAdvanceCost_in.focus();
		} else {
			document.tr_add_form.submit();
		}
	}

	function checkZen(value) {
		for(var i=0 ; i< value.length ; i++) {
			var c = value.charCodeAt(i);
			if((c >= 0xff61 && c <= 0xff9f) || c < 256) {
				return false;
			}
		}
		return true;
	}
	
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>月次書類作成画面</title>
</head>
<body>
	<h2>月次書類作成画面</h2>
	<h3>
		交通費作成状態(<span id="documentYear"><s:property
				value="#request.documentYear" /></span>年<span id=documentMonth><s:property
				value="#request.documentMonth" /></span>月)
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
			<td id="tr_center"><s:property value="ts_InfoVO.user_id" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.user_id" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.user_id" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.user_id" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.doc_ym" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.req_day" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.auth_user" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.cpl_day" /></td>
			<td><s:property value="ts_InfoVO.trp_reject_reason" /></td>
		</tr>
	</table>

	<s:form name="tr_add_form" action="InsertTR_Info" method="POST"
		enctype="multipart/form-data" theme="simple">
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
							<td><s:select name="kinmu_day" list="transDate_in" /></td>
							<td><s:textfield id="transStartPoint_in" name="kukan_start"
									cssStyle="width: 110px; " maxlength="23" /></td>
							<td><s:textfield id="transEndPoint_in" name="kukan_stop"
									cssStyle="width: 110px; " maxlength="23" /></td>
							<td><s:select name="round_trip" list="#{'01':'往復','02':'片道'}"/></td>
							<td><s:textfield id="transDestination_in" name="dest_area"
									cssStyle="width: 110px; " maxlength="20" /></td>
							<td><s:textfield id="transPlan_in" name="trp_shurui"
									cssStyle="width: 165px; " maxlength="20" /></td>
							<td><s:textfield id="transCost_in" name="trp_cost"
									cssStyle="width: 60px; " maxlength="7" /></td>
							<td><s:textfield id="transAdvanceCost_in" name="mae_money"
									cssStyle="width: 60px; " maxlength="7" /></td>
						</tr>
					</table>
					<table width="823px" style="table-layout: fixed">
						<tr>
							<td><font size="2">*定期券購入は乗物に入力してください。</font></td>
							<td align="right"><input type="button"
								onclick="transportCostAdd();" value="登録" /> <input
								type="button" onclick="transportCostUpdate();" value="修正" /> <input
								type="button" onclick="transportCostDelete();" value="削除" /></td>
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
					style="overflow-y: scroll; overflow-x: hidden; width: 1150px; height: 200px;">
					<table rules="all" border="1">
						<s:iterator value="tr_InfoVOList" status="trList">
							<tr>
								<td id="tr_center" style="width: 40px"><input type="radio"
									name="transCheck_out" /></td>
								<td id="tr_center" style="width: 180px"><s:property
										value="kinmu_day" /></td>
								<td id="tr_center" style="width: 160px;"><s:property
										value="kukan_start" /></td>
								<td id="tr_center" style="width: 160px;"><s:property
										value="kukan_stop" /></td>
								<td id="tr_center" style="width: 80px;"><s:property
										value="round_trip" /></td>
								<td id="tr_center" style="width: 160px;"><s:property
										value="dest_area" /></td>
								<td id="tr_center" style="width: 160px;"><s:property
										value="trp_shurui" /></td>
								<td id="tr_center" style="width: 80px;"><s:property
										value="trp_cost" /></td>
								<td id="tr_center" style="width: 80px;"><s:property
										value="mae_money" /></td>
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
					</tr>
					<s:iterator value="HD_InfoVOList" status="hdList">
						<tr>
							<td><a href="url"><s:property value="trk_dt" /></a></td>
							<td id="tr_center"><s:property value="hld_rsn_category" />:<s:property
									value="hld_rsn_item" /></td>
							<td style="font-size: 14px"><s:property
									value="hld_rsn_category" /></td>
							<td id="tr_center"><s:property value="hld_status" /></td>
							<td id="tr_center"><s:property value="req_day" /></td>
							<td id="tr_center"><s:property value="auth_user" /></td>
							<td id="tr_center"><s:property value="cpl_day" /></td>
							<td style="font-size: 14px"><s:property
									value="hld_reject_reason" /></td>
							<td><input type="button" value="修正"></td>
							<td><input type="button" value="削除"></td>
						</tr>
					</s:iterator>
				</table></td>
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