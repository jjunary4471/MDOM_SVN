<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月次書類管理システム</title>
<style type="text/css">
#center { position:absolute; top:30%; left:40%; width:500px; height:800px; overflow:hidden; margin-top:-150px; margin-left:-100px;}
</style>

<script>
</script>

</head>
<body>
	<form name="hldWrite" action="holidayWrite" onsubmit='return validate();' accept-charset="UTF-8">
	<div id="center">
		<table style="width: 921px;">
			<tr>
				<td style="width: 808px; height: 95px"><h3>休暇申請・報告書 作成</h3>
				
				<table rules="all" border="1">
					<tr>
						<td style="width:180px;">氏　　　名</td>
						<td style="width:300px;"><%out.println(session.getAttribute("s_user_name")); %></td>
					</tr>
					<tr>
						<td style="width:180px;">所　　　属</td>
						<td style="width:300px;"><%out.println(session.getAttribute("s_user_dept_name")); %></td>
					</tr>
					<tr>
						<td style="width:180px;">職　　　位</td>
						<td style="width:300px;"><%out.println(session.getAttribute("s_user_rank_name")); %></td>
					</tr>
				</table>
				<br><br><br>
				
					<table rules="all" border="1">
						「※」は必須入力
						<tr>
							<td style="width: 180px;">休 暇 区 分※</td>
							<td style="width: 300px;">
							<input type="radio" name="holidayType" value="短期" onclick="div_show(this.value,'short');">短期
						 	<input type="radio" name="holidayType" value="長期" onclick="div_show(this.value,'long');">長期 
						 	<input type="radio" name="holidayType" value="他" onclick="div_show(this.value,'etc');">他 
						 <br>
								<div id="short" style="display: none">
									<input type="radio" name="shortHolidayType" value="全日休暇" onclick="shortHLDType();">1．全日休暇
									<input type="radio" name="shortHolidayType" value="半日休暇(午前)" onclick="shortHLDType();">2-1．半日休暇(午前)
									<input type="radio" name="shortHolidayType" value="半日休暇(午後)" onclick="shortHLDType();">2-2．半日休暇(午後)
									<br> <input type="radio" name="shortHolidayType" value="遅刻" onclick="shortHLDType();">3．遅刻
									<input type="radio" name="shortHolidayType" value="早退" onclick="shortHLDType();">4．早退
									<input type="radio" name="shortHolidayType" value="振替休暇" onclick="shortHLDType();">5．振替休暇
								</div>
								<div id="long" style="display: none">
									<input type="radio" name="longHolidayType" value="夏期休暇" onclick="longHLDType();">6．夏期休暇
									<input type="radio" name="longHolidayType" value="年末・年始休暇" onclick="longHLDType();">7．年末・年始休暇
									<br> <input type="radio" name="longHolidayType" value="慶弔休暇(結婚)" onclick="longHLDType();">8-1．慶弔休暇(結婚)
									<input type="radio" name="longHolidayType" value="慶弔休暇(葬儀)" onclick="longHLDType();">8-2．慶弔休暇(葬儀)
									<input type="radio" name="longHolidayType" value="慶弔休暇(他)" onclick="longHLDType();">8-3．慶弔休暇(他)
								</div>
								<div id="etc" style="display: none">
									<input type="radio" name="etcHolidayType" value="帰社" onclick="etcHLDType();">9．帰社
								</div>
								</td>
						</tr>
						<tr>
							<td style="width: 180px;">休 暇 事 由※</td>
							<td><input style="width: 300px;" type="text" name="holidayReason" id="holidayReason" maxlength="40"></td>
						</tr>
						<tr>
							<td style="width: 180px;">休 暇 期 間(開始日)※</td>
							<td>
								<input style="width: 300px;" type="text" name="holidayStart" id="holidayStart" maxlength="8">
							</td>
						</tr>
						<tr>
							<td style="width: 180px;">休 暇 期 間(終了日)※</td>
							<td>
								<input style="width: 300px;" type="text" name="holidayEnd" id="holidayEnd" maxlength="8">
							</td>
						</tr>
						<tr>
							<td rowspan="2">特 記 事 項※</td>
							<td style="width: 180px;">現場<br>
								<input style="width: 300px;" type="text" name="holidayField" id="holidayField" maxlength="20">
							</td>
						</tr>
						<tr>
							<td style="width: 180px;">プロジェクト名<br>
								<input style="width: 300px;" type="text" name="holidayPjname" id="holidayPjname" maxlength="20">
							</td>
						</tr>
						<tr>
							<td rowspan="2">緊 急 連 絡 先</td>
							<td style="width: 180px;">日本<br>
								<input style="width: 300px;" type="text" name="holidayJpnum" id="holidayJpnum" maxlength="12">
							</td>
						</tr>
						<tr>
							<td style="width: 180px;">日本外<br>
								<input style="width: 300px;" type="text" name="holidayEtcnum" id="holidayEtcnum" maxlength="12">
							</td>
						</tr>		
						<tr>
							<td>ビザの有効期限※</td>
							<td><input style="width: 300px;" type="text" name="holidayVisa" id="holidayVisa" maxlength="8">
							</td>
						</tr>
					</table>
					</td>
			</tr>
		</table>
		<input type="hidden" name="bigKubun" value="">
		<input type="hidden" name="smallKubun" value="">
		<input type="hidden" name="typeCheck" value="">
		<input type="hidden" name="editDocNum" value="">
		<input name="holidayBtn" id="holidayBtn" style="margin-left: 445px;" type="submit" value="登録">
	</div>
	</form>
</body>
</html>