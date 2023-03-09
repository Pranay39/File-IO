package com.programs.File.IO.helper;

import com.programs.File.IO.entity.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }
        return false;
    }

    public static List<Employee> convertExcelToListOfEmployees(InputStream is){
        List<Employee> list = new ArrayList<>();
        try{
           XSSFWorkbook workbook =  new XSSFWorkbook(is);
           XSSFSheet sheet = workbook.getSheet("Sheet1");

           int rowNum = 0;
           Iterator<Row> iterator = sheet.iterator();

           while(iterator.hasNext()){
               Row row = iterator.next();
               if(rowNum == 0){
                   rowNum++;
                   continue;
               }

               Iterator<Cell> cells =  row.iterator();
               int cid = 0;
               Employee employee = new Employee();


               while(cells.hasNext()){
                   Cell cell = cells.next();

                   if(cell != null) {

                       switch (cid) {
//                       case 0 :
//                           employee.setId((int) cell.getNumericCellValue());
//                           break;
                           case 0:
                               employee.setFirstName(cell.getStringCellValue());
                               break;
                           case 1:
                               employee.setLastName(cell.getStringCellValue());
                               break;
                           case 2:
                               employee.setGender(cell.getStringCellValue());
                               break;
                           case 3:
                               employee.setCountry(cell.getStringCellValue());
                               break;
                           case 4:
                               employee.setAge((int) cell.getNumericCellValue());

                           case 5:
                               employee.setNo((int) cell.getNumericCellValue());
                           default:
                               break;
                       }
                       cid++;
                   }
               }
               list.add(employee);
           }

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
