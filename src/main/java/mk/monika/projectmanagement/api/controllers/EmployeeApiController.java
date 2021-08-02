package mk.monika.projectmanagement.api.controllers;

import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

    @Autowired
    IEmployeeRepo employeeRepo;

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeId(@PathVariable("id") Long id) {

        Optional<Employee> employeeById = employeeRepo.findById(id);
        return employeeById.orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Valid Employee employee) {
        return employeeRepo.save(employee);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody @Valid Employee employee) {
        return employeeRepo.save(employee);
    }

    @PatchMapping(path = "/{id}")
    public Employee partialUpdate(@PathVariable("id") Long id, @RequestBody @Valid Employee patchEmployee) {
        Employee emp = employeeRepo.findById(id).get();

        if (patchEmployee.getFirstName() != null) {
            emp.setFirstName(patchEmployee.getFirstName());
        }

        if (patchEmployee.getLastName() != null) {
            emp.setLastName(patchEmployee.getLastName());
        }

        if (patchEmployee.getEmail() != null) {
            emp.setEmail(patchEmployee.getEmail());
        }

        return employeeRepo.save(emp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
       try {
           employeeRepo.deleteById(id);
       } catch (EmptyResultDataAccessException e) {
           System.out.println(e.getMessage());
       }
    }

    @GetMapping(params = {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageAndSize = PageRequest.of(page, size);
        return employeeRepo.findAll(pageAndSize);
    }
}
