package com.aditya.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/{departmentId}")
     DepartmentDTO getDepartment(@PathVariable String departmentId);
}
