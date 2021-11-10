package com.example.student.profile.excelExport;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.student.profile.model.StudentsDetails;

public class UserExcelExporter {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<StudentsDetails> listStudent;
	
	public UserExcelExporter(List<StudentsDetails> listStudent) {
		this.listStudent=listStudent;
		workbook = new XSSFWorkbook();
		
	}
	private void createCell(Row row, int columncout,Object value, CellStyle style) {
		sheet.autoSizeColumn(columncout);
		Cell cell = row.createCell(columncout);
		 if (value instanceof Long) {
			cell.setCellValue((Long) value);
		}else if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		}else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		}else {
			cell.setCellValue((String) value);
		}
		 cell.setCellStyle(style);
	}
	
	private void writeHeaderLine() {
		sheet = workbook.createSheet("Student");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(20);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		createCell(row, 0, "Student Information", style);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
		font.setFontHeightInPoints((short)(10));
		
		row = sheet.createRow(1);
		
		createCell(row, 0, "Student ID", style);
		createCell(row, 1, "firstName", style);
		createCell(row, 2, "lastName", style);
		createCell(row, 3, "address", style);
		
		
	}

	private void writeDataLines() {
		int rowCount =2;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for (StudentsDetails studentsDetails : listStudent) {
		Row row = sheet.createRow(rowCount++);
		int columnCount = 0;
				createCell(row, columnCount++, studentsDetails.getStudentId(), style);
				createCell(row, columnCount++, studentsDetails.getFirstName(), style);
				createCell(row, columnCount++, studentsDetails.getLastName(), style);
				createCell(row, columnCount++, studentsDetails.getAddress(), style);

	}
	}
		
	
		public void export(HttpServletResponse response) throws IOException {
			writeHeaderLine();
			writeDataLines();
			
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
			
		}
		
		
		
	
	
	
}
