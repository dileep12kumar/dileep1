package GenaricLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this calss conatains resuable methods to perfrom actions on excel file
 * @author Dileep
 *
 */
public class ExcelUtiliy 
{
	private Workbook workbook;
	private DataFormatter df;
	
	public void ExcelInti(String filepath) 
	{
		FileInputStream fis=null;
		try {
			
			fis=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/**
	 * this method is used to read single data from excel
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 */
	public String ReadDataFromExcel(String sheetName, int rownum, int cellnum) {
		df=new DataFormatter();
		return df.formatCellValue(workbook.getSheet(sheetName).getRow(rownum).getCell(cellnum));
		
	}
	/**
	 * this method is used to read multiple dat from Excel
	 * @param sheetname
	 * @return
	 */
    public Map<String, String> ReadDataFromExcel( String sheetname)
    {
    	Map<String, String> map=new HashMap<String, String>();
    	df=new DataFormatter();
    	Sheet sheet= workbook.getSheet(sheetname);
    	for (int i = 0; i <= sheet.getLastRowNum(); i++)
    	{
    		String key=df.formatCellValue(sheet.getRow(i).getCell(0));
    		String value=df.formatCellValue(sheet.getRow(i).getCell(1));
    		map.put(key, value);
		
		}
		return map;
		
    	
    }
    /**
     * this methd used write ns save data from Excel
     * @param sheetname
     * @param rownum
     * @param cellnum
     * @param value
     * @param Excelpath
     */
    
    public void WriteTOExcel(String sheetname, int rownum, int cellnum, Date value, String Excelpath) {
    	Cell cell=workbook.getSheet(sheetname).getRow(rownum).createCell(cellnum);
    	cell.setCellValue(value);
    	
    	FileOutputStream fos=null;
    	
    	try {
			fos=new FileOutputStream(Excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    /**
     * this method is used to close
     */
    
    public void closeExcel() {
    	try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
