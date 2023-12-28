package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {

	@DataProvider(name = "AddEmployee")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/testData/TestData.xlsx";
		int rownum = XLUtils.getRowCount(path, "AddEmployee");
		int colcount = XLUtils.getCellCount(path, "AddEmployee", 1);
		String addEmpdata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				addEmpdata[i - 1][j] = XLUtils.getCellData(path, "AddEmployee", i, j);// 1 0
			}
		}
		return addEmpdata;
	}

}
