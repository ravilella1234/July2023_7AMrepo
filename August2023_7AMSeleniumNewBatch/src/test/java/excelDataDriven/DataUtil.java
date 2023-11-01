package excelDataDriven;

import java.util.Hashtable;

public class DataUtil 
{
	
	public static Object[][] getTableData(ExcelAPI e,String sheetName,String testName) throws Exception
	{
			//To find the matching testcase RowNumber
			int testStartRowNum = 0;
			while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testName))
			{
				testStartRowNum++;
			}
			System.out.println("Test Start row Number is : " +  testStartRowNum);
			
			
			int colStartRowNum = testStartRowNum+1;
			int dataStartRowNum = testStartRowNum+2;
			
			//Calculate the rows of Data
			int rows = 0;
			while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
			{
				rows++;
			}
			System.out.println("Total rows are : " + rows);
			
			//Calculate the cols of data
			int cols = 0;
			while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
			{
				cols++;
			}
			System.out.println("total cols are : " + cols);
			
			//Read the test data
			int dataRow =0;
			Hashtable<String, String> table = null;
			Object[][] data = new Object[rows][1];
			for(int rNum =dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
			{
				table = new Hashtable<String, String>();
				for(int cNum=0;cNum<cols;cNum++)
				{
					//System.out.println(e.getCellData(sheetName, cNum, rNum));
					//data[dataRow][cNum] = e.getCellData(sheetName, cNum, rNum);
					String key = e.getCellData(sheetName, cNum, colStartRowNum);
					String value = e.getCellData(sheetName, cNum, rNum);
					table.put(key, value);
				}
				data[dataRow][0] = table;
				dataRow++;
			}
		  
		return data;
	}

}
