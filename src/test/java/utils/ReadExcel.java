package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public static String readData(String excelPath, String sheetNum, int rowNum, String columnNum) throws IOException {
        File src = new File(excelPath);
        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh1 = wb.getSheetAt(Integer.parseInt(sheetNum));

        String data = sh1.getRow(rowNum).getCell(Integer.parseInt(columnNum)).getStringCellValue();
        return data;
    }
}

