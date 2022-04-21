package task.day3;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormattingSample {
	
	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("E:\\Java Greens\\DataDrivenFrameWork\\TestData.xlsx");
		Workbook w=new XSSFWorkbook(file);
		Sheet s = w.getSheet("Sheet1");
		System.out.println("Data reading without Formatting :\n");
		for (Row row : s) {
			for (Cell cell : row) {
				System.out.printf(cell+"\t");
			}
			System.out.println("\n");
		}
		System.out.println("Data reading with Formatting :\n");
		for (Row row : s) {
			for (Cell cell : row) {
				if (cell.getCellType()==1) {
					String stringCellValue = cell.getStringCellValue();
					System.out.print(stringCellValue+"\t");
				}else if (cell.getCellType()==0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
						String format = simpleDateFormat.format(dateCellValue);
						System.out.print(format+"\t");
					}
				 else {
					 double numericCellValue = cell.getNumericCellValue();
					 long l=(long)numericCellValue;
					 String valueOf = String.valueOf(l);
					 System.out.print(valueOf+"\t");
				}
			}
		}
			System.out.println("\n");
	}
		}
	}
