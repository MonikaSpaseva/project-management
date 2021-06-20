package mk.monika.projectmanagement.services;

import mk.monika.projectmanagement.dto.EmployeeProject;
import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo employeeRepo;

    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getAll(){
        return  employeeRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects(){
        return  employeeRepo.employeeProjects();
    }
}
