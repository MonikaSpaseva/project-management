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

//    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//
//            Employee employee1 = new Employee("Monika", "Spaseva", "monika.spaseva@hotmail.com");
//            Employee employee2 = new Employee("Spase", "Markovski", "smarkovski@gmail.com");
//            Employee employee3 = new Employee("Marijana", "Savikj", "manjichka@hotmail.com");
//
//            Employee employee4 = new Employee("Ronald", "Connor", "connor@gmail.com");
//            Employee employee5 = new Employee("Jim", "Salvator", "sal@gmail.com");
//            Employee employee6 = new Employee("Peter", "Henley", "henley@gmail.com");
//
//            Employee employee7 = new Employee("Richard", "Carson", "carson@gmail.com");
//            Employee employee8 = new Employee("Honor", "Miles", "miles@gmail.com");
//            Employee employee9 = new Employee("Tony", "Rogers", "rogers@gmail.com");
//
//
//            Project project1 = new Project("Large Production Deploy", "NOTSTARTED"," This requires all hands on deck for the final deployment of the software into production");
//            Project project2 = new Project("New Employee Budget", "COMPLETED", "Decide on a new employee bonus budget for the year and figure out who will be promoted");
//            Project project3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed");
//            Project project4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation");
//
//
//            // needs to set both sides of the relationship manually
//
//            project1.addEmployee(employee1);
//            project1.addEmployee(employee2);
//            project2.addEmployee(employee3);
//            project3.addEmployee(employee1);
//            project4.addEmployee(employee1);
//            project4.addEmployee(employee3);
//
//
//            // needs to set both sides of the relationship manually
//
//            employee1.setProjects(Arrays.asList(project1, project3, project4));
//            employee2.setProjects(Arrays.asList(project1));
//            employee3.setProjects(Arrays.asList(project2, project4));
//
//
//            // save employee in database
//
//            employeeRepo.save(employee1);
//            employeeRepo.save(employee2);
//            employeeRepo.save(employee3);
//            employeeRepo.save(employee4);
//            employeeRepo.save(employee5);
//            employeeRepo.save(employee6);
//            employeeRepo.save(employee7);
//            employeeRepo.save(employee8);
//            employeeRepo.save(employee9);
//
//
//            // save projects in the database
//
//            projectRepository.save(project1);
//            projectRepository.save(project2);
//            projectRepository.save(project3);
//            projectRepository.save(project4);
//
//
//        };
//    }
}
