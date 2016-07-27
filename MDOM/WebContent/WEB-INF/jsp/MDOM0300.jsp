<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="bean.TS_InfoVO"%>
<%@ page import="util.DateCalulator"%>
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
</style>

<script>
	// 今月書類作成イベント
	function currentMonthWrite() {
		var status =<%=request.getAttribute("documentStatus")%>;
		var currentMonth =<%=request.getAttribute("currentMonth")%>;
		var documentMonth =<%=request.getAttribute("documentMonth")%>;
		if (documentMonth == currentMonth) {
		} else if (status == "1") {
		} else {
			document.currentMonthBtn.submit();
		}
	}
	// 交通費入力有効性チェック
	function transportCheck() {
		var trAddForm = document.tr_add_form;
		var numberCheck = /^[0-9]+$/;
		var returnInt = 0;
		if (trAddForm.transDate_in.value == '') {
			alert('勤務日を入力してください。');
			trAddForm.transDate_in.focus();
		} else if (!numberCheck.test(trAddForm.transDate_in.value)) {
			alert('勤務日は半角数字しか入力できません。');
			trAddForm.transDate_in.focus();
		} else if (Number(trAddForm.transDate_in.value) < 1
				|| Number(trAddForm.transDate_in.value) >
<%=request.getAttribute("documentLastDay")%>
	) {
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
			returnInt = 1;
		}
		return returnInt;
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
	// 交通費登録イベント
	function transportCostAdd() {
		var check = transportCheck();
		if (check == 1) {
			$('input[id="tr_add_form_flag_in"]').val("0");
			document.tr_add_form.submit();
		}
	}
	// 交通費更新ボタンイベント
	function transportCostUpdate() {
		var doc_ym_in = $('input[id="doc_ym_in"]').val();
		var mesai_no_in = $('input[id="mesai_no_in"]').val();
		var transDate_in = $('input[id="transDate_in"]').val();
		var transDate_check_in = $('input[id="transDate_check_in"]').val();
		var check = transportCheck();
		if (check == 1) {
			if (doc_ym_in == "" || mesai_no_in == "") {
			} else if (transDate_check_in != transDate_in) {
				alert("勤務日がチェックした交通費情報と異なります。")
			} else {
				$('input[id="tr_add_form_flag_in"]').val("1");
				document.tr_add_form.submit();
			}
		}
	}
	// 交通費削除ボタンイベント
	function transportCostDelete() {
		var doc_ym_in = $('input[id="doc_ymd_in"]').val();
		var mesai_no_in = $('input[id="mesai_no_in"]').val();
		if (doc_ym_in != "" || mesai_no_in != "") {
			if (confirm("選択した交通費を削除しますか？") == true) {

				$('input[id="tr_add_form_flag_in"]').val("2");
				document.tr_add_form.submit();
			}
		}
	}
	// 交通費確認ボタンイベント
	function transportReview() {
		document.tr_review_form.submit();
	}
	// 休暇申請・報告書確認アンカーイベント
	function holidayReview() {
		document.hd_Review_form.submit();
	}
	// 休暇申請・報告書登録ボタンイベント
	function holidayAdd() {
		document.hd_add_form.submit();
	}
	// 休暇申請・報告書更新ボタンイベント
	function holidayUpdate() {
		document.hd_update_form.submit();
	}
	// 休暇申請・報告書削除ボタンイベント
	function holidayDelete() {
		if (confirm("選択した休暇申請・報告書を削除しますか？") == true) {
			$("form[name=hd_delete_form]").submit();
		}
	}
	// 交通費ラジオボタンチェックイベント
	function transportRadioCheck(index) {
		var transDate_in = $('#transDate_in');
		var transDate_check_in = $('input[id="transDate_check_in"]');
		var transStartPoint_in = $('#transStartPoint_in');
		var transEndPoint_in = $('#transEndPoint_in');
		var round_trip_in = $('#round_trip_in');
		var transDestination_in = $('#transDestination_in');
		var transPlan_in = $('#transPlan_in');
		var transCost_in = $('#transCost_in');
		var transAdvanceCost_in = $('#transAdvanceCost_in');
		var mesai_no_in = $('input[id="mesai_no_in"]');

		var transDate_out			= $.trim($('td[name="kinmu_day_out"]')[index].innerText);
		var transStartPoint_out		= $.trim($('td[name="transStartPoint_out"]')[index].innerText);
		var transEndPoint_out		= $.trim($('td[name="transEndPoint_out"]')[index].innerText);
		var transRound_out			= $.trim($('td[name="transRound_out"]')[index].innerText);
		var transDestination_out	= $.trim($('td[name="transDestination_out"]')[index].innerText);
		var transPlan_out			= $.trim($('td[name="transPlan_out"]')[index].innerText);
		var transCost_out			= $.trim($('td[name="transCost_out"]')[index].innerText);
		var transAdvanceCost_out	= $.trim($('td[name="transAdvanceCost_out"]')[index].innerText);
		var mesai_no_out			= $.trim($('td[name="mesai_no_out"]')[index].innerText);
		
		transDate_out.trim();
		transStartPoint_out = transStartPoint_out.trim();
		transEndPoint_out.trim();
		transRound_out.trim();
		transDestination_out.trim();
		transPlan_out.trim();
		transCost_out.trim();
		transAdvanceCost_out.trim();
		mesai_no_out.trim();

		transDate_in.val(transDate_out);
		transDate_check_in.val(transDate_out);
		transStartPoint_in.val(transStartPoint_out);
		transEndPoint_in.val(transEndPoint_out);
		round_trip_in.val(transRound_out).attr("selected", "selected");
		transDestination_in.val(transDestination_out);
		transPlan_in.val(transPlan_out);
		transCost_in.val(transCost_out);
		transAdvanceCost_in.val(transAdvanceCost_out);
		mesai_no_in.val(mesai_no_out);

	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>月次書類作成画面</title>
</head>
<body>
<iframe src="header/header.jsp" height="80px" width="100%" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0>
</iframe>
	<h2>月次書類作成画面</h2>
	<h3>
		交通費作成状態(<span id="documentYear"><s:property
				value="#request.documentYear" /></span>年<span id=documentMonth><s:property
				value="#request.documentMonth" /></span>月)
	</h3>
	<%--																		--%>
	<%--							今月書類ボタン押下							--%>
	<%--	event		onclick="currentMonthWrite()"							--%>
	<%--	form		name="currentMonthBtn" 									--%>
	<%--				action="currentMonth"									--%>
	<%--	parameter	doc_ym="documentDate"									--%>
	<%--																		--%>
	<s:form name="currentMonthBtn" action="currentMonth" method="POST"
		enctype="multipart/form-data" theme="simple">
		<s:hidden name="current_doc_ym" value="%{documentDate}" />
		<input type="button" onclick="currentMonthWrite()" value="今月書類" />
	</s:form>
	<font size="2">*対象月が前月の場合、クリックしてください。</font>
	<br>
	<table width="1100px" rules="all" border="1"
		style="table-layout: fixed">
		<tr style="width: 1100px; height: 30px;">
			<td id="tr_align_center" style="width: 80px;">社員番号</td>
			<td id="tr_align_center" style="width: 80px;">社員名</td>
			<td id="tr_align_center" style="width: 80px;">所属部署</td>
			<td id="tr_align_center" style="width: 80px;">職位</td>
			<td id="tr_align_center" style="width: 180px;">月次書類状態</td>
			<td id="tr_align_center" style="width: 80px;">依頼実施日</td>
			<td id="tr_align_center" style="width: 80px;">確認者</td>
			<td id="tr_align_center" style="width: 80px;">確認完了日</td>
			<td id="tr_align_center" style="width: 320px;">差し戻し理由</td>
		</tr>

		<tr style="width: 1100px; height: 20px;">
			<td id="tr_align_center">
				<s:property value="#session.s_user_id" />
			</td>
			<td id="tr_align_center">
				<s:property value="#session.s_user_name" />
			</td>
			<td id="tr_align_center">
				<s:property value="#session.s_user_dept_name" />
			</td>
			<td id="tr_align_center">
				<s:property value="#session.s_user_rank_name" />
			</td>
			<td id="tr_align_center">
				<s:property value="ts_InfoVO.trns_status" />:<s:property value="ts_InfoVO.trns_status_name" />
			</td>
			<td id="tr_align_center">
				<s:property value="ts_InfoVO.req_day" />
			</td>
			<td id="tr_align_center">
				<s:property value="ts_InfoVO.auth_user" />
			</td>
			<td id="tr_align_center">
				<s:property value="ts_InfoVO.cpl_day" />
			</td>
			<td>
				<s:property value="ts_InfoVO.trp_reject_reason" />
			</td>
		</tr>
	</table>

	<%--																		--%>
	<%--						交通費追加ボタン押下								--%>
	<%--						交通費修正ボタン押下								--%>
	<%--						交通費削除ボタン押下								--%>
	<%--	event		onclick	="transportCostAdd()"							--%>
	<%--	form		name	="tr_add_form" 									--%>
	<%--				action	="insertTR_Info"								--%>
	<%--	parameter	doc_ym	="documentDate"									--%>
	<%--				mesai_no="mesai_no_out"									--%>
	<%--				tr_add_form_flag	登録の場合、”0”						--%>
	<%--									修正の場合、”1”						--%>
	<%--									削除の場合、”2”						--%>
	<%--				kinmu_day												--%>
	<%--				kukan_start												--%>
	<%--				kukan_stop												--%>
	<%--				mesai_no												--%>
	<%--				round_trip												--%>
	<%--				dest_area												--%>
	<%--				trp_shurui												--%>
	<%--				trp_cost												--%>
	<%--				mae_money												--%>
	<%--				dest_area												--%>
	<%--																		--%>
	<s:form name="tr_add_form" action="insertTR_Info" method="POST"
		enctype="multipart/form-data" theme="simple">
		<s:hidden id="transDate_check_in" name="transDate_check" />
		<s:hidden id="doc_ym_in" name="doc_ym" value="%{documentDate}" />
		<s:hidden id="mesai_no_in" name="mesai_no" />
		<s:hidden id="tr_add_form_flag_in" name="tr_add_form_flag" value="0" />
		<table width="900px" style="table-layout: fixed">
			<tr>
				<td style="height: 95px">
					<h3>
						交通費登録<font style="font-weight: normal; font-size: 12px;">
							「*」は必須</font>
					</h3>
					<table>
						<tr>
							<td id="tr_align_center" style="width: 90px">勤務日 *</td>
							<td id="tr_align_center" style="width: 110px;">区間（開始） *</td>
							<td id="tr_align_center" style="width: 110px;">区間（到着） *</td>
							<td id="tr_align_center" style="width: 90px;">往復/片道 *</td>
							<td id="tr_align_center" style="width: 110px;">行先</td>
							<td id="tr_align_center" style="width: 165px;">乗物 *</td>
							<td id="tr_align_center" style="width: 60px;">金額 *</td>
							<td id="tr_align_center" style="width: 60px;">前渡金</td>
						</tr>
						<tr>
							<td id="tr_vertical_center">
								<s:property value="#request.documentYear" />
								<s:property value="#request.documentMonth" />
								<s:textfield id="transDate_in" name="kinmu_day"
									cssStyle="width: 20px; " maxlength="2" />
							</td>
							<td id="tr_vertical_center">
								<s:textfield id="transStartPoint_in" name="kukan_start"
									cssStyle="width: 110px; " maxlength="23" />
							</td>
							<td id="tr_vertical_center">
								<s:textfield id="transEndPoint_in" name="kukan_stop"
									cssStyle="width: 110px; " maxlength="23" />
							</td>
							<td id="tr_vertical_center">
								<s:select cssStyle="width:90px;" id="round_trip_in"
									name="round_trip" list="#{'00':'片道','01':'往復'}" />
							</td>
							<td id="tr_vertical_center">
								<s:textfield id="transDestination_in" name="dest_area"
									cssStyle="width: 110px; " maxlength="20" />
							</td>
							<td id="tr_vertical_center">
								<s:textfield id="transPlan_in" name="trp_shurui"
									cssStyle="width: 165px; " maxlength="20" />
							</td>
							<td id="tr_vertical_center">
								<s:textfield id="transCost_in" name="trp_cost"
									cssStyle="width: 60px; " maxlength="7" />
							</td>
							<td id="tr_vertical_center">
								<s:textfield id="transAdvanceCost_in" name="mae_money"
									cssStyle="width: 60px; " maxlength="7" />
							</td>
						</tr>
					</table>
					<table width="853px" style="table-layout: fixed">
						<tr>
							<td>
								<font size="2">*定期券購入は乗物に入力してください。</font>
							</td>
							<td align="right">
								<input type="button" onclick="transportCostAdd();" value="登録" />
								<input type="button" onclick="transportCostUpdate();" value="修正" />
								<input type="button" onclick="transportCostDelete();" value="削除" />
							</td>
						</tr>
					</table>
				</td>

			</tr>
		</table>
	</s:form>

	<table style="width: 1140px;" style="table-layout: fixed">
		<tr>
			<td style="height: 95px">
				<h3>交通費明細一覧</h3>
				<table rules="all" border="1">
					<tr style="height: 30px;">
						<td id="tr_align_center" style="width: 40px">選択</td>
						<td id="tr_align_center" style="width: 180px">勤務日</td>
						<td id="tr_align_center" style="width: 160px;">区間(開始)</td>
						<td id="tr_align_center" style="width: 160px;">区間(到着)</td>
						<td id="tr_align_center" style="width: 80px;">往復/片道</td>
						<td id="tr_align_center" style="width: 160px;">行先</td>
						<td id="tr_align_center" style="width: 160px;">乗物</td>
						<td id="tr_align_center" style="width: 80px;">金額</td>
						<td id="tr_align_center" style="width: 80px;">前渡金</td>
					</tr>
				</table>
				<div
					style="overflow-y: scroll; overflow-x: hidden; width: 1150px; height: 195px;">
					<table id="tr_Info_List_Table" rules="all" border="1">
						<s:iterator value="tr_InfoVOList" status="trList">
							<tr name="tr_Info_List_Tr">
								<td name="doc_ym_out" style="display: none">
									<s:property value="doc_ym" />
								</td>
								<td name="mesai_no_out" style="display: none">
									<s:property value="mesai_no" />
								</td>
								<td name="kinmu_day_out" style="display: none">
									<s:property value="kinmu_day" />
								</td>
								<td id="tr_align_center" style="width: 40px">
									<input type="radio" name="transCheck_out"
										onclick="transportRadioCheck(this.value)"
										value="<s:property value='%{#trList.index}' />" />
								</td>
								<td id="tr_align_center" name="transDate_out"
									style="width: 180px">
									<s:property value="documentYear" />年<s:property value="documentMonth" />月<s:property value="kinmu_day" />日
									(<s:property value="week_day"/>)
								</td>
								<td id="tr_align_center" name="transStartPoint_out"
									style="width: 160px">
									<s:property value="kukan_start" />
								</td>
								<td id="tr_align_center" name="transEndPoint_out"
									style="width: 160px;">
									<s:property value="kukan_stop" />
								</td>
								<td id="tr_align_center" name="transRound_out"
									style="width: 80px;">
									<s:property value="round_trip_name" />
								</td>
								<td id="tr_align_center" name="transDestination_out"
									style="width: 160px;">
									<s:property value="dest_area" />
								</td>
								<td id="tr_align_center" name="transPlan_out"
									style="width: 160px;">
									<s:property value="trp_shurui" />
								</td>
								<td id="tr_align_center" name="transCost_out"
									style="width: 80px;">
									<s:property value="trp_cost" />
								</td>
								<td id="tr_align_center" name="transAdvanceCost_out"
									style="width: 80px;">
									<s:property value="mae_money" />
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</td>
			<table width="1135px" style="table-layout: fixed">
				<%--																		--%>
				<%--						交通費確認ボタン押下								--%>
				<%--	event		onclick	="transportCostAdd()"							--%>
				<%--	form		name	="tr_review_form" 								--%>
				<%--				action	="--------------"								--%>
				<%--	parameter	doc_ym	="documentDate"									--%>
				<%--																		--%>
				<s:form name="tr_review_form" action="reviewTR_Info" method="POST"
					enctype="multipart/form-data" theme="simple">
					<s:hidden name="doc_year" value="%{documentYear}" />
					<s:hidden name="doc_month" value="%{documentMonth}" />
					<s:hidden name="tr_InfoVOList" value="%{tr_InfoVOList}" />
					<s:hidden name="hd_InfoVOList" value="%{hd_InfoVOList}" />
					<tr>
						<td align="right">
							<input type="button" onclick="transportReview()" value="交通費確認" />
						</td>
					</tr>
				</s:form>
			</table>
		</tr>
	</table>
	<table style="width: 1140px;">
		<tr>
			<td style="width: 1140px; height: 95px">
				<h3>休暇申請・報告書一覧</h3>
				<table rules="all" border="1">
					<tr style="height: 30px;">
						<td id="tr_align_center" style="width: 150px;">作成日</td>
						<td id="tr_align_center" style="width: 170px;">休暇区分</td>
						<td id="tr_align_center" style="width: 150px;">休暇理由</td>
						<td id="tr_align_center" style="width: 90px;">書類状態</td>
						<td id="tr_align_center" style="width: 90px;">依頼実施日</td>
						<td id="tr_align_center" style="width: 80px;">確認者</td>
						<td id="tr_align_center" style="width: 90px;">確認完了日</td>
						<td id="tr_align_center" style="width: 280px;">差し戻し理由</td>
					</tr>

					<%--																		--%>
					<%--						作成日アンカーを押下								--%>
					<%--	event		onclick	="holidayReview()"								--%>
					<%--	form		name	="hd_review_form" 								--%>
					<%--				action	="--------------"								--%>
					<%--	parameter	trk_dt	="HD_InfoVOList.trk_dt"							--%>
					<%--																		--%>
					<s:iterator value="hd_InfoVOList" status="hdList">
						<form name="hd_review_form" action="--------------" method="POST"
							enctype="multipart/form-data" theme="simple">
							<s:hidden name="mk_day" value="mk_day" />
						<tr>
							<td id="tr_align_center">
								<a href="javascript:holidayReview()" onclick="return false">
								<s:property value="documentYear" />年<s:property value="documentMonth" />月<s:property value="kyuka_day" />日(<s:property value="week_day"/>)</a>
							</td>
							</form>
							<td id="tr_align_center">
								<s:property value="hld_kbn_category_name" />
								:
								<s:property value="hld_kbn_item_name" />
							</td>
							<td style="font-size: 14px">
								<s:property value="hld_rsn" />
							</td>
							<td id="tr_align_center">
								<s:property value="hld_status_name" />
							</td>
							<td id="tr_align_center">
								<s:property value="req_day" />
							</td>
							<td id="tr_align_center">
								<s:property value="auth_user" />
							</td>
							<td id="tr_align_center">
								<s:property value="cpl_day" />
							</td>
							<td style="font-size: 14px">
								<s:property value="hld_reject_reason" />
							</td>

							<%--																		--%>
							<%--						休暇申請・報告書修正ボタン押下						--%>
							<%--	event		onclick		="holidayUpdate()"							--%>
							<%--	form		name		="hd_update_form" 							--%>
							<%--				action		="intoHLDEdit"								--%>
							<%--	parameter	hld_mng_no	="hld_mng_no"								--%>
							<%--																		--%>
							<%--						休暇申請・報告書削除ボタン押下						--%>
							<%--	event		onclick		="holidayDelete()"							--%>
							<%--	form		name		="hd_delete_form" 							--%>
							<%--				action		="deleteHD_Info"							--%>
							<%--	parameter	hld_mng_no	="hld_mng_no"								--%>
							<%--																		--%>
							<td>
								<s:form name="hd_update_form" action="intoHLDEdit"
									method="POST" enctype="multipart/form-data" theme="simple">
									<s:hidden name="hld_flag" value="1" />
									<s:hidden name="hld_mng_no" value="%{hld_mng_no}" />
									<s:submit value="修正" action="intoHLDEdit"/>
								</s:form>
							</td>
							
							<td>
								<s:form name="hd_delete_form" action="deleteHD_Info" onsubmit="return false"
									method="POST" enctype="multipart/form-data" theme="simple">
									<s:hidden name="hld_mng_no" value="%{hld_mng_no}" />
									<s:submit onclick="holidayDelete()" value="削除"/>
								</s:form>
							</td>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="1138px" style="table-layout: fixed">
					<tr>
						<%--																		--%>
						<%--					休暇申請・報告書作成ボタン押下							--%>
						<%--	event		onclick	="holidayAdd()"									--%>
						<%--	form		name	="hd_add_form" 									--%>
						<%--				action	="intoHldWrite"									--%>
						<%--	parameter															--%>
						<%--																		--%>
						<td>
							<font size="2">*作成日アンカーをクリックすると、休暇申請・報告書確認画面に移動します。</font>
						</td>
						<s:form name="hd_add_form" action="intoHLDWrite" method="POST"
							enctype="multipart/form-data" theme="simple">
							<td align="right">
								<s:hidden name="hld_flag" value="0" />
								<input type="button" onclick="holidayAdd()" value="新規作成">
							</td>
						</s:form>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>