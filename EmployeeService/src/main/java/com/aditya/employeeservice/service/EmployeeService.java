package com.aditya.employeeservice.service;


import com.aditya.employeeservice.entity.Employee;
import com.aditya.employeeservice.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
/*    @Autowired
    RestTemplate restTemplate;
    @Autowired
    WebClient webClient;*/

    @Autowired
    APIClient apiClient;

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertDTOToToEntity(employeeDTO);
        employeeRepo.save(employee);
        return employeeDTO;
    }

    public Employee convertDTOToToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setFName(employeeDTO.getFName());
        employee.setLName(employeeDTO.getLName());
        employee.setDepartmentCode(employeeDTO.getDepartmentCode());
        return employee;
    }
    public EmployeeDTO convertEntityToDto(Employee employee)
    {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setFName(employee.getFName());
        employeeDTO.setLName(employee.getLName());
        employeeDTO.setDepartmentCode(employee.getDepartmentCode());
        return employeeDTO;
    }
    public ApiResponseDTO getEmployeetById(Long employeeId) throws URISyntaxException {
        Employee employee=employeeRepo.getReferenceById(employeeId);
        System.out.println(employee.getDepartmentCode());
        /**
         * Communication using WebClient from webflux
         */
        /*DepartmentDTO departmentDTO=webClient.get()
                .uri(new URI("http://localhost:8080/api/departments/"+employee.getDepartmentCode()))
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();*/
        /**
         * Communication using RestTemplate
         * But RestTemplate is deprecated
         */
/*        ResponseEntity<DepartmentDTO> responseEntity=restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDTO.class);
        DepartmentDTO departmentDTO=responseEntity.getBody();*/
        DepartmentDTO departmentDTO=apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDTO employeeDTO=convertEntityToDto(employee);
        ApiResponseDTO apiResponseDTO=new ApiResponseDTO(departmentDTO,employeeDTO);
        return apiResponseDTO;
    }
}
