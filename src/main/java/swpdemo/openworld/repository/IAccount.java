package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swpdemo.openworld.model.Account;

@Repository
public interface IAccount extends JpaRepository<Account, Integer>{
}
