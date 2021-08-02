package mk.monika.projectmanagement.repository;

import mk.monika.projectmanagement.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends PagingAndSortingRepository<UserAccount, Long> {

    @Override
    List<UserAccount> findAll();
}
