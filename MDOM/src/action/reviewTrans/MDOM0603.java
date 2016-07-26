package action.reviewTrans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bean.TR_InfoVO;
import util.DateCalulator;

public class MDOM0603 implements Action, Preparable, ModelDriven<List<TR_InfoVO>> {
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	private Map<String, Object> parameter = null;
	//
	List<TR_InfoVO> tr_InfoVOList = null;
	//
	XSSFWorkbook workBook = null;
	XSSFSheet workSheet = null;
	XSSFRow workRow = null;
	int sheet = 0;
	int dateRow = 0;
	int userRow = 2;
	int transRow = 5;
	//

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		parameter = context.getParameters();
		tr_InfoVOList = new ArrayList<TR_InfoVO>();
	}

	@Override
	public List<TR_InfoVO> getModel() {
		return tr_InfoVOList;
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
			user_name = user_name.substring(0, 1) + " " + user_name.substring(2);
			String user_department = String.valueOf(session.get("s_user_department"));
			// パラメーター取得
			String doc_ym = String.valueOf(parameter.get("doc_ym"));
			String doc_year = doc_ym.substring(0, 4);
			String doc_month = String.valueOf(Integer.getInteger(doc_ym.substring(4)));
			//
			workBook = new XSSFWorkbook(fis);
			workSheet = workBook.getSheetAt(0);
			// 年月日
			workRow = workSheet.getRow(dateRow);
			workRow.createCell(2).setCellValue(doc_year);
			workRow.createCell(4).setCellValue(doc_month);
			// ユーザー情報
			workRow = workSheet.getRow(userRow);
			workRow.createCell(2).setCellValue(user_department);
			workRow.createCell(8).setCellValue(user_name);
			// 
			inputDay(5, doc_year, doc_month);
			// 交通費情報
			DateCalulator dc = new DateCalulator();
			int lastDay = dc.getLastDay(doc_year, doc_month);
			int startDay = 1;
			int beforeDay = 0;
			int rownum = 5;
			Iterator<TR_InfoVO> iterator = tr_InfoVOList.iterator();
			iterator.hasNext();
			for(int day=startDay ; day<=lastDay ; day++) {
				TR_InfoVO tr_InfoVO = iterator.next();
				workRow = workSheet.getRow(rownum);
				int kinmu_day = Integer.parseInt(tr_InfoVO.getKinmu_day());
				String kukan_start = tr_InfoVO.getKukan_start();
				String kukan_stop = tr_InfoVO.getKukan_stop();
				String round_trip = tr_InfoVO.getRound_trip();
				String dest_area = tr_InfoVO.getDest_area();
				String trp_shurui = tr_InfoVO.getTrp_shurui();
				String trp_cost = tr_InfoVO.getTrp_cost();
				String mae_money = tr_InfoVO.getMae_money();
				if (round_trip.equals("00"))
					round_trip = "⇒";
				else
					round_trip = "⇔";
				if(kinmu_day == beforeDay) { // 日が以前の行と同じ場合
					shiftrow(rownum);
					workRow.getCell(2).setCellValue(kukan_start + round_trip + kukan_stop);
					workRow.getCell(3).setCellValue(dest_area);
					workRow.getCell(4).setCellValue(trp_shurui);
					workRow.getCell(5).setCellValue(trp_cost);
					workRow.getCell(6).setCellValue(mae_money);
					workRow.getCell(1).setCellFormula("CHOOSE(WEEKDAY(DATE(西暦,月,A" + rownum + "),1),\"日\",\"月\",\"火\",\"水\",\"木\",\"金\",\"土\")");
					workRow.getCell(9).setCellFormula("J" + (rownum-1) + "-H" + rownum + "+I" + rownum);
					day--;
					iterator.hasNext();
				}else if(kinmu_day != day) { // 日が異なる場合
					shiftrow(rownum);
					workRow.getCell(0).setCellValue(kinmu_day);
					workRow.getCell(2).setCellValue(kukan_start + round_trip + kukan_stop);
					workRow.getCell(3).setCellValue(dest_area);
					workRow.getCell(4).setCellValue(trp_shurui);
					workRow.getCell(5).setCellValue(trp_cost);
					workRow.getCell(6).setCellValue(mae_money);
					workRow.getCell(1).setCellFormula("CHOOSE(WEEKDAY(DATE(西暦,月,A" + rownum + "),1),\"日\",\"月\",\"火\",\"水\",\"木\",\"金\",\"土\")");
					workRow.getCell(9).setCellFormula("J" + (rownum-1) + "-H" + rownum + "+I" + rownum);
					iterator.hasNext();
				}else { // 順番の日と異なる場合
					shiftrow(rownum);
					workRow.getCell(0).setCellValue(day);
					workRow.getCell(5).setCellValue("");
					workRow.getCell(6).setCellValue("");
					workRow.getCell(1).setCellFormula("CHOOSE(WEEKDAY(DATE(西暦,月,A" + rownum + "),1),\"日\",\"月\",\"火\",\"水\",\"木\",\"金\",\"土\")");
					workRow.getCell(9).setCellFormula("J" + (rownum-1) + "-H" + rownum + "+I" + rownum);
				}
			}
			/*
			Iterator<TR_InfoVO> iterator = tr_InfoVOList.iterator();
			while (iterator.hasNext()) {
				TR_InfoVO tr_InfoVO = iterator.next();
				workRow = workSheet.getRow(transRow);
				int kinmu_day = Integer.parseInt(tr_InfoVO.getKinmu_day());
				if (workDay > kinmu_day) {
					shiftrow(transRow);
				}
				workRow.createCell(0).setCellValue(workDay);

				String kukan_start = tr_InfoVO.getKukan_start();
				String kukan_stop = tr_InfoVO.getKukan_stop();
				String round_trip = tr_InfoVO.getRound_trip();
				if (round_trip.equals("00"))
					round_trip = "⇒";
				else
					round_trip = "⇔";
				String dest_area = tr_InfoVO.getDest_area();
				String trp_shurui = tr_InfoVO.getTrp_shurui();
				String trp_cost = tr_InfoVO.getTrp_cost();
				String mae_money = tr_InfoVO.getMae_money();
				workRow.createCell(2).setCellValue(kukan_start + round_trip + kukan_stop);
				workRow.createCell(3).setCellValue(dest_area);
				workRow.createCell(4).setCellValue(trp_shurui);
				workRow.createCell(5).setCellValue(trp_cost);
				workRow.createCell(6).setCellValue(mae_money);

			}*/

			
			workBook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
		return null;
	}

	public void inputDay(int row, String doc_year, String doc_month) {
		DateCalulator dc = new DateCalulator();
		int lastDay = dc.getLastDay(doc_year, doc_month);
		int startDay = 1;
		workRow = workSheet.getRow(row++);
		workRow.getCell(0).setCellValue(String.valueOf(startDay));
		for(++startDay ; startDay<=lastDay ; startDay++) {
			shiftrow(row);
			workRow = workSheet.getRow(row++);
			workRow.getCell(0).setCellValue(startDay);
			workRow.getCell(1).setCellFormula("CHOOSE(WEEKDAY(DATE(西暦,月,A" + row + "),1),\"日\",\"月\",\"火\",\"水\",\"木\",\"金\",\"土\")");
			workRow.getCell(9).setCellFormula("J" + (row-1) + "-H" + row + "+I" + row);
		}
	}
	
	public void shiftrow(int row) {
		workSheet.shiftRows(row, workSheet.getLastRowNum(), 1, true, true);
		XSSFRow newWorkRow = workSheet.createRow(row);
		XSSFRow sourceWorkRow = workSheet.getRow(row - 1);
		newWorkRow.setHeight(sourceWorkRow.getHeight());
		// 初めの行番号
		// 最後の行番号
		// 初めのColumn
		// 最後のColumn
		workSheet.addMergedRegion(new CellRangeAddress(row, row, 2, 4));
		for (int ci = 0; ci < sourceWorkRow.getLastCellNum(); ci++) {
			// Grab a copy of the old/new cell
			XSSFCell oldCell = sourceWorkRow.getCell(ci);
			XSSFCell newCell = newWorkRow.createCell(ci);

			// If the old cell is null jump to next cell
			if (oldCell == null) {
				newCell = null;
				continue;
			}

			// Copy style from old cell and apply to new cell
			XSSFCellStyle newCellStyle = workBook.createCellStyle();
			newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
			newCell.setCellStyle(newCellStyle);
			
			// If there is a cell comment, copy
			if (oldCell.getCellComment() != null) {
				newCell.setCellComment(oldCell.getCellComment());
			}

			// If there is a cell hyperlink, copy
			if (oldCell.getHyperlink() != null) {
				newCell.setHyperlink(oldCell.getHyperlink());
			}

			// Set the cell data type
			newCell.setCellType(oldCell.getCellType());

			// Set the cell data value
			switch (oldCell.getCellType()) {
			case XSSFCell.CELL_TYPE_BLANK:
				newCell.setCellValue(oldCell.getStringCellValue());
				break;
			case XSSFCell.CELL_TYPE_BOOLEAN:
				newCell.setCellValue(oldCell.getBooleanCellValue());
				break;
			case XSSFCell.CELL_TYPE_ERROR:
				newCell.setCellErrorValue(oldCell.getErrorCellValue());
				break;
			case XSSFCell.CELL_TYPE_FORMULA:
				newCell.setCellFormula(oldCell.getCellFormula());
				break;
			case XSSFCell.CELL_TYPE_NUMERIC:
				newCell.setCellValue(oldCell.getNumericCellValue());
				break;
			case XSSFCell.CELL_TYPE_STRING:
				newCell.setCellValue(oldCell.getRichStringCellValue());
				break;
			}
		}
	}
}
