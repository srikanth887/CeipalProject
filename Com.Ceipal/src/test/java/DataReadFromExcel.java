import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadFromExcel {
	


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		File file=new File("C:\\Users\\srika\\Desktop\\Money.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		
       XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		System.out.println("Last row- "+lastRow);
		for(int i=0; i<=lastRow; i++)
		{
		XSSFRow row = sheet.getRow(i);
		int lastCell = row.getLastCellNum();
		for(int j=0; j<lastCell; j++)
		{
		
		XSSFCell cell = row.getCell(j);
		String value = cell.getStringCellValue();
		System.out.println(value);
		}
		
	/*	HSSFWorkbook hw=new HSSFWorkbook(fis);
		HSSFSheet hs=hw.getSheet("Worksheet");
		
		 HSSFRow row2=hs.getRow(1);
	        
	        //Create a cell object to retreive cell at index 5
	        HSSFCell cell=row2.getCell(4);
	        
	        //Get the address in a variable
	        String address= cell.getStringCellValue();
	        
	        //Printing the address
	        System.out.println("Address is :"+ address);
		*/
		

	}
	}
	
	
		
		



}