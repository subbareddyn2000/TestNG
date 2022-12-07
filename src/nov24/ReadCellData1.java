package nov24;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadCellData1 {
	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("E://Book.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws =wb.getSheet("EmpData");
		@SuppressWarnings("unused")
		int rc = ws.getLastRowNum();
		String fname = ws.getRow(9).getCell(0).getStringCellValue();
		String mname = ws.getRow(7).getCell(1).getStringCellValue();
		String lname = ws.getRow(4).getCell(2).getStringCellValue();
		System.out.println(fname+"  "+mname+"   "+lname);
		fi.close();
		wb.close();
	}
}
