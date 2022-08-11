package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteExcel {
    static XSSFWorkbook xssfWorkbook;
    static XSSFSheet xssfSheet;
    public static void writeData(String excelPath, int sheetNum, int rowNum, int columnNum, String value) throws Exception {
        File src = new File(excelPath);
        FileInputStream fileInputStream = new FileInputStream(src);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheetAt(sheetNum);

        xssfSheet.getRow(rowNum).createCell(columnNum).setCellValue(value);
        FileOutputStream fileOutputStream = new FileOutputStream(src);

        xssfWorkbook.write(fileOutputStream);
        xssfWorkbook.close();
    }
}

