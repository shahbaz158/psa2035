package crm.com.controller;


import crm.com.entity.Employee;
import crm.com.paylod.EmployeeDto;
import crm.com.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(

    @RequestBody Employee employee

    ){
       Employee emp= employeeService.addEmployee(employee);

        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(
            @RequestParam Long id
    ){
             employeeService.DeleteEmployee(id);
             return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto
    ){
        employeeService.updateEmployee(id,dto);
        return new ResponseEntity<>("updated",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee(

    ){
       List<Employee> employees = employeeService.getEmployee();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
}
