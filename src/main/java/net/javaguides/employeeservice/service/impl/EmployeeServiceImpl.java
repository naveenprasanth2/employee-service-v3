package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.inter.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employeeRepository.save(AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto)));
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(AutoEmployeeMapper.MAPPER::mapToEmployeeDto).toList();
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartmentName(String departmentName) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getDepartmentName()
                        .equalsIgnoreCase(departmentName))
                .map(AutoEmployeeMapper.MAPPER::mapToEmployeeDto)
                .toList();
    }


}
