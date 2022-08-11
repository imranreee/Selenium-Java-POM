package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Al Imran on 28/11/2020.
 */
public class ReadExcelNumber {

    public static int readData(String excelPath, String sheetNum, int rowNum, String columnNum) throws IOException {
        File src = new File(excelPath);
        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh1 = wb.getSheetAt(Integer.parseInt(sheetNum));

        int data = (int) sh1.getRow(rowNum).getCell(Integer.parseInt(columnNum)).getNumericCellValue();
        return data;
    }
}
