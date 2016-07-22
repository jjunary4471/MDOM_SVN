<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="bean.TS_InfoVO"%>
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

		if (trAddForm.transDate_in.value == '') {
			alert('勤務日を入力してください。');
			trAddForm.transDate_in.focus();
		} else if (!numberCheck.test(trAddForm.transDate_in.value)) {
			alert('勤務日は半角数字しか入力できません。');
			trAddForm.transDate_in.focus();
		} else if (Number(trAddForm.transDate_in.value) < 0
				|| Number(trAddForm.transDate_in.value) > <%=request.getAttribute("documentLastDay") %>) {
			alert('勤務日は今月の日を入力してください。');
			trAddForm.transDate_in.focus();
		} else if (trAddForm.transStartPoint_in.value == '') {
			alert('区間(開始)を入力してください。');
			trAddForm.transStartPoint_in.focus();
		} else if (trAddForm.transEndPoint_in.value == '') {
			alert('区間(到着)を入力してください。');
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
		} else if (!numberCheck.test(trAddForm.transAdvanceCost_in.value)
				&& trAddForm.transAdvanceCost_in.value != '') {
			alert('前渡金は半角数字しか入力できません。');
			trAddForm.transAdvanceCost_in.focus();
		} else {
			document.tr_add_form.submit();
		}
	}

	function checkZen(value) {
		for (var i = 0; i < value.length; i++) {
			var c = value.charCodeAt(i);
			if ((c >= 0xff61 && c <= 0xff9f) || c < 256) {
				return false;
			}
		}
		return true;
	}

	function currentMonthWrite() {
		var status =
<%TS_InfoVO ts_InfoVO = (TS_InfoVO) request.getAttribute("ts_InfoVO");
			out.print(ts_InfoVO.getTrns_status());%>
	+ '';
		var currentMonth =
<%=request.getAttribute("currentMonth")%>
	;
		var documentMonth =
<%=request.getAttribute("documentMonth")%>
	;
		if (documentMonth == currentMonth) {

		} else if (status == "1：作成中") {

		} else {
			document.currentMonthBtn.submit();
		}
	}

	function transportCheck(index) {
		var transDate_in = $('#transDate_in');
		var transStartPoint_in = $('#transStartPoint_in');
		var transEndPoint_in = $('#transEndPoint_in');
		var round_trip_in = $('#round_trip_in');
		var transDestination_in = $('#trtransDestination_inansDate_in');
		var transPlan_in = $('#transPlan_in');
		var transCost_in = $('#transCost_in');
		var transAdvanceCost_in = $('#transAdvanceCost_in');
		var doc_ym_in = $('#doc_ym_in');
		var mesai_no_in = $('#mesai_no_in');

		var transDate_out = $('td[name="transDate_out"]')[index].innerText;
		var transStartPoint_out = $('td[name="transStartPoint_out"]')[index].innerText;
		var transEndPoint_out = $('td[name="transEndPoint_out"]')[index].innerText;
		var transRound_out = $('td[name="transRound_out"]')[index].innerText;
		var transDestination_out = $('td[name="transDestination_out"]')[index].innerText;
		var transPlan_out = $('td[name="transPlan_out"]')[index].innerText;
		var transCost_out = $('td[name="transCost_out"]')[index].innerText;
		var transAdvanceCost_out = $('td[name="transAdvanceCost_out"]')[index].innerText;
		var doc_ym_out = $('td[name="doc_ym_out"]')[index].innerText;
		var mesai_no_out = $('td[name="mesai_no_out"]')[index].innerText;

		transDate_in.val(transDate_out);
		transStartPoint_in.val(transStartPoint_out);
		transEndPoint_in.val(transEndPoint_out);
		//round_trip_in.;
		transDestination_in.val(transDestination_out);
		transPlan_in.val(transCost_out);
		transCost_in.val(transCost_out);
		transAdvanceCost_in.val(transAdvanceCost_out);
		doc_ym_in.val(doc_ym_out);
		mesai_no_in.val(mesai_no_out);

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
	<s:form name="currentMonthBtn" action="currentMonth" method="POST"
		enctype="multipart/form-data" theme="simple">
		<s:hidden name="doc_ym" value="ts_InfoVO.doc_ym" />
		<s:param name="doc_ym">${ts_InfoVO.doc_ym}</s:param>
		<input type="button" onclick="currentMonthWrite()" value="今月書類" />
	</s:form>
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
			<td id="tr_center"><s:property value="#session['userName']" /></td>
			<td id="tr_center"><s:property value="#session['userDept']" /></td>
			<td id="tr_center"><s:property value="#session['userRank']" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.trns_status" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.req_day" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.auth_user" /></td>
			<td id="tr_center"><s:property value="ts_InfoVO.cpl_day" /></td>
			<td><s:property value="ts_InfoVO.trp_reject_reason" /></td>
		</tr>
	</table>

	<s:form name="tr_add_form" action="InsertTR_Info" method="POST"
		enctype="multipart/form-data" theme="simple">
		<s:hidden name="doc_ym" value="documentDate" />
		<table width="900px" style="table-layout: fixed">
			<tr>

				<td style="height: 95px">
					<h3>
						交通費登録<font style="font-weight: normal; font-size: 12px;">
							「*」は必須</font>
					</h3>
					<table>
						<tr>
							<td id="tr_center" style="width: 90px">勤務日 *</td>
							<td id="tr_center" style="width: 110px;">区間（開始） *</td>
							<td id="tr_center" style="width: 110px;">区間（到着） *</td>
							<td id="tr_center" style="width: 90px;">往復/片道 *</td>
							<td id="tr_center" style="width: 110px;">行先</td>
							<td id="tr_center" style="width: 165px;">乗物 *</td>
							<td id="tr_center" style="width: 60px;">金額 *</td>
							<td id="tr_center" style="width: 60px;">前渡金</td>
						</tr>
						<tr>
							<td><s:property value="#request.documentYear" /> <s:property
									value="#request.documentMonth" /> <s:textfield
									id="transDate_in" name="kinmu_day" cssStyle="width: 20px; "
									maxlength="2" /></td>
							<td><s:textfield id="transStartPoint_in" name="kukan_start"
									cssStyle="width: 110px; " maxlength="23" /></td>
							<td><s:textfield id="transEndPoint_in" name="kukan_stop"
									cssStyle="width: 110px; " maxlength="23" /></td>
							<td><s:select name="round_trip_in"
									list="#{'01':'往復','02':'片道'}" /></td>
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
		<s:hidden name="doc_ym_in" />
		<s:hidden name="mesai_no_in" />
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
					<table id="tr_Info_List_Table" rules="all" border="1">
						<s:iterator value="tr_InfoVOList" status="trList">
							<tr name="tr_Info_List_Tr">
								<td name="doc_ym_out" style="display: none"><s:property
										value="doc_ym" /></td>
								<td name="mesai_no_out" style="display: none"><s:property
										value="mesai_no" /></td>
								<td id="tr_center" style="width: 40px"><input type="radio"
									name="transCheck_out" onclick="transportCheck(this.value)"
									value="<s:property value='%{#trList.index}' />" /></td>
								<td id="tr_center" name="transDate_out" style="width: 180px"><s:property
										value="kinmu_day" /></td>
								<td id="tr_center" name="transStartPoint_out"
									style="width: 160px"><s:property value="kinmu_day" /></td>
								<td id="tr_center" name="transEndPoint_out"
									style="width: 160px;"><s:property value="kukan_stop" /></td>
								<td id="tr_center" name="transRound_out" style="width: 80px;"><s:property
										value="round_trip" /></td>
								<td id="tr_center" name="transDestination_out"
									style="width: 160px;"><s:property value="dest_area" /></td>
								<td id="tr_center" name="transPlan_out" style="width: 160px;"><s:property
										value="trp_shurui" /></td>
								<td id="tr_center" name="transCost_out" style="width: 80px;"><s:property
										value="trp_cost" /></td>
								<td id="tr_center" name="transAdvanceCost_out"
									style="width: 80px;"><s:property value="mae_money" /></td>
							</tr>
						</s:iterator>
					</table>
				</div></td>
			<table width="1140px" style="table-layout: fixed">
				<s:form name="---------------" action="---------------"
					method="POST" enctype="multipart/form-data" theme="simple">
					<tr>
						<td align="right"><s:submit value="交通費確認"></s:submit></td>
					</tr>
				</s:form>
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
							<td><form name="hollidayReview">
									<a href="url"><s:property value="trk_dt" />
								</form> </a></td>
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
							<td><s:form name="holidayUpdate" action="---------------"
									method="POST" enctype="multipart/form-data" theme="simple">
									<s:hidden name="hld_mng_no" value="hld_mng_no" />
									<input type="button" onclick="" value="修正">
								</s:form></td>
							<td><s:form name="holidayDelete" action="deleteHD_Info"
									method="POST" enctype="multipart/form-data" theme="simple">
									<s:hidden name="hld_mng_no" value="hld_mng_no" />
									<input type="button" onclick="" value="削除">
								</s:form></td>
						</tr>
					</s:iterator>
				</table></td>
		</tr>
		<tr>
			<td>
				<table width="1140px" style="table-layout: fixed">
					<tr>
						<td><font size="2">*作成日アンカーをクリックすると、休暇申請・報告書確認画面に移動します。</font></td>
						<s:form name="holidayAdd" action="intoHldWrite" method="POST"
							enctype="multipart/form-data" theme="simple">
							<td><s:submit value="新規作成"></s:submit></td>
						</s:form>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>