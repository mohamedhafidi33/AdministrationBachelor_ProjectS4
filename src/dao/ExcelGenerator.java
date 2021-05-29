package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {
	public Map<Integer, List<String>> excelData(String link) throws IOException {
		FileInputStream file = new FileInputStream(new File(link));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Map<Integer, List<String>> data = new HashMap<>();
		int i = 0;
		for (Row row : sheet) {
			List <String> listRow=new ArrayList<String>();
		    data.put(i, listRow);
		    for (Cell cell : row) {
		    	 System.out.println(cell.getStringCellValue().toString());
		        switch (cell.getCellTypeEnum()) {
		            case STRING: listRow.add(cell.getStringCellValue()); 
                    //System.out.print("\t"); 
                    break;
		            case NUMERIC:listRow.add(cell.getStringCellValue()); 
                    //System.out.print("\t"); 
                    break;
		            case BOOLEAN: listRow.add(cell.getStringCellValue()); 
                    //System.out.print("\t"); 
                    break;
		            case FORMULA:listRow.add(cell.getStringCellValue());
                    //System.out.print("\t"); 
                    break;
		            default: data.get(new Integer(i)).add(" ");
		        }
		    }
		    i++;
		}
//		Stream.of(data.keySet().toString())
//        .forEach(System.out::println);
		return data;
	}
	
}
