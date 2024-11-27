package crm.com.service;

import crm.com.entity.Employee;
import crm.com.paylod.EmployeeDto;
import crm.com.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    public Employee addEmployee(Employee employee){
       Employee emp = employeeRepository.save(employee);
       return emp;
    }


    public void DeleteEmployee(Long id) {

        employeeRepository.deleteById(id);
    }


    public void updateEmployee(Long id, EmployeeDto dto) {

        Optional<Employee> opEmp =employeeRepository.findById(id);
        Employee employee = opEmp.get();
        employee.setName(dto.getName());
        employee.setEmailId(dto.getEmailId());
        employee.setMobile(dto.getMobile());
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployee() {
     return  employeeRepository.findAll();
    }
}

