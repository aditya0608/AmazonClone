package com.aditya.employeeservice.controller;


import com.aditya.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveDepartment(@RequestBody EmployeeDTO employeeDTO)
    {
       EmployeeDTO employeeDTO1= employeeService.saveEmployee(employeeDTO);
       return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponseDTO> getDepartment(@PathVariable Long employeeId) throws URISyntaxException {
        ApiResponseDTO apiResponseDTO=employeeService.getEmployeetById(employeeId);
        return new ResponseEntity<>(apiResponseDTO,HttpStatus.OK);
    }
}
