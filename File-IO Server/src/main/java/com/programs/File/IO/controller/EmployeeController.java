package com.programs.File.IO.controller;

import com.programs.File.IO.entity.Employee;
import com.programs.File.IO.helper.ExcelHelper;
import com.programs.File.IO.service.ExcelService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

//import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/employee/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws InterruptedException {

        Thread.sleep(5000);

        if(ExcelHelper.checkExcelFormat(file)){
            this.excelService.save(file);
            return ResponseEntity.ok("File Uploaded Successfully!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only");
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.excelService.getAllEmployees();
    }
}
