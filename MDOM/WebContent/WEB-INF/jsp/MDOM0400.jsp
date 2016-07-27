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

// 텍스트 박스 기존 데이터로 초기화 
////////////////////////////////////////////////////////////////////////

<% 
	String hldFlag = (String)request.getAttribute("hld_flag");
	String hldMngNo = (String)request.getAttribute("hld_mng_no");

	String nowDate = (String)request.getAttribute("nowDate");
	String user_field = (String)request.getAttribute("user_field");
	String user_pj = (String)request.getAttribute("user_pj");
	String user_jpnum = (String)request.getAttribute("user_jpnum");
	String user_etcnum = (String)request.getAttribute("user_etcnum");
	String user_visa = (String)request.getAttribute("user_visa");
	
	String hldReason = (String)request.getAttribute("hldReason");
	String hldStart = (String)request.getAttribute("hldStart");
	String hldEnd = (String)request.getAttribute("hldEnd");
	String hldCategory = (String)request.getAttribute("hldCategory");
	String hldItem = (String)request.getAttribute("hldItem");
	
	
%>

var typeChk;

var shortSelected;
var longSelected;
var etcSelected;

var bigKubun;
var smallKubun;

var hldReason;
var hldStart;
var hldEnd;
var hldField;
var hldPjname;
var hldJpnum;
var hldEtcnum;
var hldVisa;

var categoryChk = hldWrite.holidayType;
var shortItemChk = hldWrite.shortHolidayType;
var longItemChk = hldWrite.longHolidayType;
var etcItemChk = hldWrite.etcHolidayType;


function setData() {
	
	if(<%=hldFlag%> == 1) {
		
		typeChk = "1";
		
		document.getElementById("holidayBtn").value = "修正";
		
		document.getElementById("holidayReason").value = "<%=hldReason%>";
		document.getElementById("holidayStart").value = "<%=hldStart%>";
		document.getElementById("holidayEnd").value = "<%=hldEnd%>";
		document.getElementById("holidayField").value = "<%=user_field%>";
		document.getElementById("holidayPjname").value = "<%=user_pj%>";
		document.getElementById("holidayJpnum").value = "<%=user_jpnum%>";
		document.getElementById("holidayEtcnum").value = "<%=user_etcnum%>";
		document.getElementById("holidayVisa").value = "<%=user_visa%>";
				
		if(<%=hldCategory%> == 01) {
			categoryChk[0].checked = true;
			bigKubun = "01";

			if(<%=hldItem%> == 10) {
				smallKubun = "10";
				shortItemChk[0].checked = true;
			}else if(<%=hldItem%> == 11) {
				smallKubun = "11";
				shortItemChk[1].checked = true;
			}else if(<%=hldItem%> == 12) {
				smallKubun = "12";
				shortItemChk[2].checked = true;
			}else if(<%=hldItem%> == 13) {
				smallKubun = "13";
				shortItemChk[3].checked = true;
			}else if(<%=hldItem%> == 14) {
				smallKubun = "14";
				shortItemChk[4].checked = true;
			}else if(<%=hldItem%> == 15) {
				smallKubun = "15";
				shortItemChk[5].checked = true;
			}
			
			document.getElementById("short").style.display = "";
			document.getElementById("long").style.display = "none";
			document.getElementById("etc").style.display = "none";
			
		}else if(<%=hldCategory%> == 02) {
			bigKubun = "02";
			categoryChk[1].checked = true;
			
			if(<%=hldItem%> == 20) {
				smallKubun = "20";
				longItemChk[0].checked = true;
			}else if(<%=hldItem%> == 21) {
				smallKubun = "21";
				longItemChk[1].checked = true;
			}else if(<%=hldItem%> == 22) {
				smallKubun = "22";
				longItemChk[2].checked = true;
			}else if(<%=hldItem%> == 23) {
				smallKubun = "23";
				longItemChk[3].checked = true;
			}else if(<%=hldItem%> == 24) {
				smallKubun = "24";
				longItemChk[4].checked = true;
			}
			
			document.getElementById("short").style.display = "none";
			document.getElementById("long").style.display = "";
			document.getElementById("etc").style.display = "none";
			
		}else if(<%=hldCategory%> == 99) {
			bigKubun = "99";
			categoryChk[2].checked = true;
			smallKubun = "30";
			etcItemChk.checked = true;
			
			document.getElementById("short").style.display = "none";
			document.getElementById("long").style.display = "none";
			document.getElementById("etc").style.display = "";
		}
		
	}else {
		
		typeChk = "0";
		
		document.getElementById("holidayStart").value = "<%=nowDate%>";
		document.getElementById("holidayEnd").value = "<%=nowDate%>";
		document.getElementById("holidayField").value = "<%=user_field%>";
		document.getElementById("holidayPjname").value = "<%=user_pj%>";
		document.getElementById("holidayJpnum").value = "<%=user_jpnum%>";
		document.getElementById("holidayEtcnum").value = "<%=user_etcnum%>";
		document.getElementById("holidayVisa").value = "<%=user_visa%>";
	}

}

////////////////////////////////////////////////////////////////////////






	// 대항목 라디오 버튼 클릭 시 소항목 라디오 버튼 출력
	//////////////////////////////////////////////////////////////////////////////////////
	function div_show(s, ss) {
		if (s == "短期") {
			document.getElementById(ss).style.display = "";
			document.getElementById("long").style.display = "none";
			document.getElementById("etc").style.display = "none";
			bigKubun = "01";
		} else if (s == "長期") {
			document.getElementById(ss).style.display = "";
			document.getElementById("short").style.display = "none";
			document.getElementById("etc").style.display = "none";
			bigKubun = "02";
		} else if (s == "他") {
			document.getElementById(ss).style.display = "";
			document.getElementById("short").style.display = "none";
			document.getElementById("long").style.display = "none";
			bigKubun = "99";
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////
	
	// 소항목 라디오 버튼 값 구하기 
	//////////////////////////////////////////////////////////////////////////////////////
	function shortHLDType() {
		
		longSelected = null;
		etcSelected = null;
		
		size = document.hldWrite.elements['shortHolidayType'].length;
		
		for(var i=0; i < size; i++) {
			if(document.hldWrite.elements['shortHolidayType'][i].checked) {
				shortSelected = document.hldWrite.elements['shortHolidayType'][i].value;
				smallKubun = shortSelected;
				break;
			}
		}
	}
	
	function longHLDType() {
		
		shortSelected = null;
		etcSelected = null;
		
		size = document.hldWrite.elements['longHolidayType'].length;
		
		for(var i=0; i < size; i++) {
			if(document.hldWrite.elements['longHolidayType'][i].checked) {
				longSelected = document.hldWrite.elements['longHolidayType'][i].value;
				smallKubun = longSelected;
				break;
			}
		}
	}
	
	function etcHLDType() {
		
		shortSelected = null;
		longSelected = null;
		
		etcSelected = document.hldWrite.elements['etcHolidayType'].value;
		smallKubun = etcSelected;
	}
	//////////////////////////////////////////////////////////////////////////////////////
	
	
	// 등록 버튼 클릭 시 유효성 체크
	function validate() {
		hldReason = document.getElementById("holidayReason").value;
		hldStart = document.getElementById("holidayStart").value;
		hldEnd = document.getElementById("holidayEnd").value;
		hldField = document.getElementById("holidayField").value;
		hldPjname = document.getElementById("holidayPjname").value;
		hldVisa = document.getElementById("holidayVisa").value;
		
		// 필수 항목 입력란이 공백일 경우
		if(hldReason == "" || hldStart == "" || hldEnd == "" || hldField == ""
				|| hldPjname == "" || hldVisa == "" 
				|| (shortSelected == null && longSelected == null && etcSelected == null))
		{
			alert('必須項目を入力して下さい。');
			return false;
		}else{
			// 휴가 날짜 길이 체크
			//////////////////////////////////////////////////////////////////////////////////////
			if(hldStart.length < 8) {
				alert('休暇期間(開始日)は半角8桁(例:20160709)で入力して下さい。');
				return false;
			}else if(hldEnd.length < 8) {
				alert('休暇期間(終了日)は半角8桁(例:20160709)で入力して下さい。');
				return false;
			}
			//////////////////////////////////////////////////////////////////////////////////////
			
			// 휴가 날짜 전각반각 체크
			//////////////////////////////////////////////////////////////////////////////////////
			for(var i=0; i < hldStart.length; i++) {
				var startCheck = hldStart.charCodeAt(i);
				var endCheck = hldEnd.charCodeAt(i);
				
				if((startCheck <= 0xff61 && startCheck >= 0xff9f) || startCheck > 256) {
					alert('休暇期間(開始日)は半角8桁(例:20160709)で入力して下さい。');
					return false;
				}else if((endCheck <= 0xff61 && endCheck >= 0xff9f) || endCheck > 256) {
					alert('休暇期間(終了日)は半角8桁(例:20160709)で入力して下さい。');
					return false;
				}
			}
			//////////////////////////////////////////////////////////////////////////////////////

			// 휴가 날짜 유효성 체크
			//////////////////////////////////////////////////////////////////////////////////////
			var startYear = hldStart.substring(0,4);
			var startMonth = hldStart.substring(4,6);
			var startDay = hldStart.substring(6,8);
			
			if(startYear < 1900 || startYear > 3000) {
				alert('休暇期間(開始日)を正しく入力して下さい。');
				return false;
			}
			
			if(startMonth < 1 || startMonth > 12) {
				alert('休暇期間(開始日)を正しく入力して下さい。');
				return false;
			}
			
			var startMaxDay = new Date(new Date(startYear, startMonth, 1) - 86400000).getDate();
			if(startDay < 1 || startDay > startMaxDay){
				alert('休暇期間(開始日)を正しく入力して下さい。');
				return false;
			}
			
			var endYear = hldEnd.substring(0,4);
			var endMonth = hldEnd.substring(4,6);
			var endDay = hldEnd.substring(6,8);
			
			if(endYear < 1900 || endYear > 3000) {
				alert('休暇期間(終了日)を正しく入力して下さい。');
				return false;
			}
			
			if(endMonth < 1 || endMonth > 12) {
				alert('休暇期間(終了日)を正しく入力して下さい。');
				return false;
			}
			
			var endMaxDay = new Date(new Date(endYear, endMonth, 1) - 86400000).getDate();
			if(endDay < 1 || endDay > endMaxDay) {
				alert('休暇期間(終了日)を正しく入力して下さい。');
				return false;
			}
			//////////////////////////////////////////////////////////////////////////////////////
			
			// 휴가 완료일이 시작일보다 과거일 경우
			//////////////////////////////////////////////////////////////////////////////////////
			if(startYear > endYear) {
				alert('休暇期間(開始日)または休暇期間(終了日)を正しく入力して下さい。');
				return false;
			}
			
			if(startMonth > endMonth) {
				alert('休暇期間(開始日)または休暇期間(終了日)を正しく入力して下さい。');
				return false;
			}else if(startMonth == endMonth) {
				if(startDay > endDay) {
					alert('休暇期間(開始日)または休暇期間(終了日)を正しく入力して下さい。');
					return false;	
				}
			}
			//////////////////////////////////////////////////////////////////////////////////////
		}
		
		// 휴가 구분 대항목, 소항목 코드 번호 입력
		
		if(smallKubun == "全日休暇") {
			smallKubun = "10";
		}else if(smallKubun == "午前半休") {
			smallKubun = "11";
		}else if(smallKubun == "午後半休") {
			smallKubun = "12";
		}else if(smallKubun == "遅刻") {
			smallKubun = "13";
		}else if(smallKubun == "早退") {
			smallKubun = "14";
		}else if(smallKubun == "振替休暇") {
			smallKubun = "15";
		}else if(smallKubun == "夏期休暇") {
			smallKubun = "20";
		}else if(smallKubun == "年末・年始休暇") {
			smallKubun = "21";
		}else if(smallKubun == "慶弔休暇(結婚)") {
			smallKubun = "22";
		}else if(smallKubun == "慶弔休暇(葬儀)") {
			smallKubun = "23";
		}else if(smallKubun == "慶弔休暇(他)") {
			smallKubun = "24";
		}else if(smallKubun == "帰社") {
			smallKubun = "30";
		}
		
		document.hldWrite.bigKubun.value = bigKubun;
		document.hldWrite.smallKubun.value = smallKubun;
		document.hldWrite.typeCheck.value = typeChk;
		document.hldWrite.editDocNum.value = <%=hldMngNo%>;
		
	}
	
</script>

</head>
<body onload='setData()'>
<iframe src="header/header.jsp" height="80px" width="100%" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0>
</iframe>
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