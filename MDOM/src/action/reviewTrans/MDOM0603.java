package action.reviewTrans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import bean.TR_InfoVO;
import dao.MDOM0301_DAO;
import util.DateCalulator;
import util.ExcelUtil;

public class MDOM0603 implements Action, Preparable {
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	//
	List<TR_InfoVO> tr_InfoVOList = null;
	String doc_year = null;
	String doc_month = null;
	//
	XSSFWorkbook workBook = null;
	XSSFSheet sourceSheet = null;
	XSSFSheet workSheet = null;
	XSSFRow sourceRow = null;
	XSSFRow workRow = null;
	int sheet = 0;
	int dateRow = 0;
	int userRow = 2;
	int transRow = 5;
	//

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		tr_InfoVOList = new ArrayList<TR_InfoVO>();
	}

	@Override
	public String execute() throws Exception {
		log.info("==============================================================");
		log.info("==========MDOM0603 execute start==============================");
		InputStream fis = new FileInputStream("F:\\project\\TransportExcelFile.xlsm");
		FileOutputStream fos = new FileOutputStream("F:\\project\\test.xlsm");
		try {
			ArrayList<Map<String, Integer>> list = null;
			Map<String, Integer> map = null;
			// セッション取得
			String user_name = String.valueOf(session.get("s_user_name"));
			user_name = user_name.substring(0, 1) + " " + user_name.substring(1);
			String user_department = String.valueOf(session.get("s_user_dept_name"));
			// パラメーター取得
			MDOM0301_DAO mdom0301_dao = new MDOM0301_DAO();
			Map<String, String> param = new HashMap<String, String>();
			param.put("user_id", "10000001");
			param.put("doc_ym", "201607");
			tr_InfoVOList = mdom0301_dao.getTRInfoList(tr_InfoVOList, param);
			// EXCEL ==================================================
			workBook = new XSSFWorkbook(fis);
			//
			// 参照シート
			//
			sourceSheet = workBook.getSheetAt(1);
			sourceRow = sourceSheet.getRow(5);
			//
			// 作成シート
			//
			workSheet = workBook.getSheetAt(0);
			// 年月日
			workRow = workSheet.getRow(dateRow);
			workRow.getCell(2).setCellValue(doc_year);
			workRow.getCell(4).setCellValue(doc_month);
			// ユーザー情報
			workRow = workSheet.getRow(userRow);
			workRow.getCell(2).setCellValue(user_department);
			workRow.getCell(8).setCellValue(user_name);
			// 交通費情報
			DateCalulator dc = new DateCalulator();
			int lastDay = dc.getLastDay(doc_year, doc_month); // 最後の日取得
			int startDay = 1;		// 1日
			int beforeDay = 0;		// Excelに最後で入力した日
			int rownum = 5;			// カレンダー開始行
			int iteratorCheck = 0;	// 交通費情報の残り判定
			Iterator<TR_InfoVO> iterator = tr_InfoVOList.iterator();
			TR_InfoVO tr_InfoVO = null;
			if (iterator.hasNext()) {
				tr_InfoVO = iterator.next();
			}
			ExcelUtil excelUtil = new ExcelUtil(workBook, workSheet);
			String weekDayFormula = "CHOOSE(WEEKDAY(DATE(西暦,月,A" + (rownum + 1)
					+ "),1),\"日\",\"月\",\"火\",\"水\",\"木\",\"金\",\"土\")";
			String balanceFormula = "-H" + (rownum + 1) + "+I" + (rownum + 1);
			String totalBalanceFormula = null;
			String totalCostFormula = null;
			DataFormat format = workBook.createDataFormat();
			CellStyle style = workBook.createCellStyle();
			style.setDataFormat(format.getFormat("¥#,##0;\"¥\"#,##0"));
			for (int day = startDay; day <= lastDay; day++) {
				excelUtil.shiftrow(rownum, sourceRow);
				workRow = workSheet.getRow(rownum);
				if (iteratorCheck == 0) {
					int kinmu_day = Integer.parseInt(tr_InfoVO.getKinmu_day());
					String kukan_start = tr_InfoVO.getKukan_start();
					String kukan_stop = tr_InfoVO.getKukan_stop();
					String round_trip = tr_InfoVO.getRound_trip();
					String dest_area = tr_InfoVO.getDest_area();
					String trp_shurui = tr_InfoVO.getTrp_shurui();
					Double trp_cost = Double.parseDouble(tr_InfoVO.getTrp_cost());
					String mae_money = tr_InfoVO.getMae_money();
					if (round_trip.equals("00")) {
						round_trip = "⇒";
					} else {
						round_trip = "⇔";
					}
					if (day == kinmu_day) { // カレンダーの日と交通費の日が同じ場合
						workRow.getCell(0).setCellValue(kinmu_day);								// 勤務日
						workRow.getCell(2).setCellValue(kukan_start + round_trip + kukan_stop); // 区間
						workRow.getCell(5).setCellValue(dest_area); 							// 行先
						workRow.getCell(6).setCellValue(trp_shurui);							// 乗物
						workRow.getCell(7).setCellValue(trp_cost);								// 金額
						if (mae_money != null && !mae_money.trim().isEmpty()) {
							workRow.getCell(8).setCellValue(Double.parseDouble(mae_money));		// 前渡金
						}
						workRow.getCell(1).setCellFormula(weekDayFormula);						// 残高
						workRow.getCell(9).setCellFormula(balanceFormula);						// 合計
						if (iterator.hasNext()) {
							tr_InfoVO = iterator.next();
						} else {
							iteratorCheck = 1;
						}
						beforeDay = day;
					} else if (beforeDay == kinmu_day) { // 前日と交通費の日が同じ場合
						workRow.getCell(0).setCellValue("");
						workRow.getCell(1).setCellValue("");
						workRow.getCell(2).setCellValue(kukan_start + round_trip + kukan_stop);
						workRow.getCell(5).setCellValue(dest_area);
						workRow.getCell(6).setCellValue(trp_shurui);
						workRow.getCell(7).setCellValue(trp_cost);
						if (mae_money != null && !mae_money.trim().isEmpty()) {
							workRow.getCell(8).setCellValue(Double.parseDouble(mae_money));
						}
						workRow.getCell(9).setCellFormula(balanceFormula);
						if (iterator.hasNext()) {
							tr_InfoVO = iterator.next();
						} else {
							iteratorCheck = 1;
						}
						day--;
					} else { // その以外の場合
						workRow.getCell(0).setCellValue(day);
						workRow.getCell(9).setCellFormula(balanceFormula);
						beforeDay = day;
					}
				} else {
					// その以外の場合
					workRow.getCell(0).setCellValue(day);
					workRow.getCell(1).setCellFormula(weekDayFormula);
					workRow.getCell(9).setCellFormula(balanceFormula);
				}
				rownum++;
				balanceFormula = "J" + rownum + "-H" + (rownum + 1) + "+I" + (rownum + 1); // 最後の行以外に設定すつ関数
				weekDayFormula = "CHOOSE(WEEKDAY(DATE(西暦,月,A" + (rownum + 1)
						+ "),1),\"日\",\"月\",\"火\",\"水\",\"木\",\"金\",\"土\")";
			}
			// 合計
			totalBalanceFormula = "J" + rownum;						// 関数
			workRow = workSheet.getRow(rownum);						// 行取得
			workRow.getCell(9).setCellFormula(totalBalanceFormula);	// 関数設定
			// 金額合計
			rownum++;												// 金額行番号
			totalCostFormula = "SUM(H5:H" + workRow + ")";			// 関数
			workRow = workSheet.getRow(rownum); 					// 行取得
			workRow.getCell(7).setCellFormula(totalBalanceFormula);	// 関数設定

			workBook.write(fos);	// Excelファイル作成
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		} finally {
			try {
				fis.close();
				fos.close();
				log.info("==============================================================");
				log.info("==========MDOM0603 execute end================================");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setTr_InfoVOList(List<TR_InfoVO> tr_InfoVOList) {
		this.tr_InfoVOList = tr_InfoVOList;
	}

	public void setDoc_year(String doc_year) {
		this.doc_year = doc_year;
	}

	public void setDoc_month(String doc_month) {
		this.doc_month = doc_month;
	}

}
