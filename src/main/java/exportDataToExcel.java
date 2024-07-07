import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShortHexNumber;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class exportDataToExcel {

    public void exportData(ArrayList<Employee> list) throws IOException {
        Workbook myWorkBook = new XSSFWorkbook();
        Sheet mySheet = myWorkBook.createSheet("Sheet");

        Row row = mySheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Email");
        row.createCell(3).setCellValue("Job Title");
        row.createCell(4).setCellValue("Department");
        row.createCell(5).setCellValue("Salary");
int rowNumber =1;
        for(Employee employee : list){
            Row employeeRow = mySheet.createRow(rowNumber);
            employeeRow.createCell(0).setCellValue(employee.getId());
            employeeRow.createCell(1).setCellValue(employee.getName());
            employeeRow.createCell(2).setCellValue(employee.getEmail());
            employeeRow.createCell(3).setCellValue(employee.getJobTitle());
            employeeRow.createCell(4).setCellValue(employee.getDepartment());
            employeeRow.createCell(5).setCellValue(employee.getSalary());
            rowNumber++;
        }

        try{

            FileOutputStream fileOutputStream = new FileOutputStream("./output.xlsx");
            myWorkBook.write(fileOutputStream);

        }catch (Exception e){
            System.out.println(e);
        }finally{
            myWorkBook.close();
        }

    }


}
