package mk.monika.projectmanagement;

import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.entities.Project;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import mk.monika.projectmanagement.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
public class Main {

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IEmployeeRepo employeeRepo;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
