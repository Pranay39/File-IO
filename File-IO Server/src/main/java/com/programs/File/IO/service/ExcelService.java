package com.programs.File.IO.service;

import com.programs.File.IO.entity.Employee;
import com.programs.File.IO.helper.ExcelHelper;
import com.programs.File.IO.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public void save(MultipartFile file){
        try {
            List<Employee> employees = ExcelHelper.convertExcelToListOfEmployees(file.getInputStream());
            this.employeeRepo.saveAll(employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Employee> getAllEmployees(){
        return this.employeeRepo.findAll();
    }
}
