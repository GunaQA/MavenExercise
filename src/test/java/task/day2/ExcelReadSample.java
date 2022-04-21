package task.day2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadSample {
	
	public static void main(String[] args) throws IOException {
		FileInputStream file =new FileInputStream("E:\\Java Greens\\DataDrivenFrameWork\\TestData.xlsx");
		Workbook w= new XSSFWorkbook(file);
		Sheet s = w.getSheet("Sheet1");
		
		System.out.println("By Using Normal For Loop:");
		
		int physicalNumberOfRows = s.getPhysicalNumberOfRows();
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row r = s.getRow(i);

			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell cell = r.getCell(j);
				System.out.print(cell+"\t");
				
			}
			System.out.println("\n");
		}
		
		System.out.println("============================================");
		
		System.out.println("By Using Enhanced For Loop:");
		
		for (Row row : s) {
			for (Cell cell : row) {
				System.out.print(cell+"\t");
			}
			System.out.println("\n");
		}
		
		
	}

}
