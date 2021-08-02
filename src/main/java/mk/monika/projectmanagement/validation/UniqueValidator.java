package mk.monika.projectmanagement.validation;

import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

    @Autowired
    IEmployeeRepo employeeRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        System.out.println("Entered Value...");
        Employee employee = employeeRepo.findByEmail(value);
        return employee == null;
    }
}
