package util;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	XSSFWorkbook workBook = null;
	XSSFSheet sourceSheet = null;
	XSSFSheet workSheet = null;
	XSSFRow sourceRow = null;
	XSSFRow workRow = null;

	public ExcelUtil(XSSFWorkbook workBook, XSSFSheet workSheet) {
		this.workBook = workBook;
		this.workSheet = workSheet;
	}

	public void shiftrow(int row, XSSFRow sourceRow) {
		try {
			workSheet.shiftRows(row, workSheet.getLastRowNum(), 1, true, true);
			XSSFRow newWorkRow = workSheet.createRow(row);
			XSSFRow sourceWorkRow = sourceRow;
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
//				switch (oldCell.getCellType()) {
//				case XSSFCell.CELL_TYPE_BLANK:
//					newCell.setCellValue(oldCell.getStringCellValue());
//					break;
//				case XSSFCell.CELL_TYPE_BOOLEAN:
//					newCell.setCellValue(oldCell.getBooleanCellValue());
//					break;
//				case XSSFCell.CELL_TYPE_ERROR:
//					newCell.setCellErrorValue(oldCell.getErrorCellValue());
//					break;
//				case XSSFCell.CELL_TYPE_FORMULA:
//					newCell.setCellFormula(oldCell.getCellFormula());
//					break;
//				case XSSFCell.CELL_TYPE_NUMERIC:
//					newCell.setCellValue(oldCell.getNumericCellValue());
//					break;
//				case XSSFCell.CELL_TYPE_STRING:
//					newCell.setCellValue(oldCell.getRichStringCellValue());
//					break;
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inputDay(int row, String doc_year, String doc_month) {
		DateCalulator dc = new DateCalulator();
		int lastDay = dc.getLastDay(doc_year, doc_month);
		int startDay = 1;
		workRow = workSheet.getRow(row++);
		workRow.getCell(0).setCellValue(String.valueOf(startDay));
		for (++startDay; startDay <= lastDay; startDay++) {
			shiftrow(row, sourceRow);
			workRow = workSheet.getRow(row++);
			workRow.getCell(0).setCellValue(startDay);
			workRow.getCell(1).setCellFormula(
					"CHOOSE(WEEKDAY(DATE(西暦,月,A" + row + "),1),\"日\",\"月\",\"火\",\"水\",\"木\",\"金\",\"土\")");
			workRow.getCell(9).setCellFormula("J" + (row - 1) + "-H" + row + "+I" + row);
		}
	}

}
