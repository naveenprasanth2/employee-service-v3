package net.javaguides.employeeservice.service.inter;

import net.javaguides.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
    List<EmployeeDto> getEmployeesByDepartmentName(String departmentName);
}
