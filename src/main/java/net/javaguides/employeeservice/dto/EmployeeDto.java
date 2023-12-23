package net.javaguides.employeeservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotNull(message = "employee first name cannot be null")
    private String firstName;
    @NotNull(message = "employee last name cannot be null")
    private String lastName;
    @NotNull(message = "employee department name cannot be null")
    private String departmentName;
}
