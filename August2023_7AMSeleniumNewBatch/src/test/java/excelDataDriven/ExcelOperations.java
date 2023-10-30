package excelDataDriven;

public class ExcelOperations 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\testdata1.xlsx");
		int rcount = e.getRowCount("login");
		System.out.println(rcount);
		
		int ccount = e.columnCount("login");
		System.out.println(ccount);
		
		System.out.println(e.getCellData("login", 0, 1));
		
		System.out.println(e.getCellData("login", "Password", 1));
		
		e.setCellData("login", 4, 1, "Passed");
		
	}

}
