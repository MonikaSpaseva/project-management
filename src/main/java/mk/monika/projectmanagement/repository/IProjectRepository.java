package mk.monika.projectmanagement.repository;

import mk.monika.projectmanagement.dto.ProjectStage;
import mk.monika.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
//    @Override
//    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT p.stage as label, COUNT(*) as value " +
            "FROM project p " +
            "GROUP BY stage")

    List<ProjectStage> projectStage();

    Project findByProjectId(Long id);


}
