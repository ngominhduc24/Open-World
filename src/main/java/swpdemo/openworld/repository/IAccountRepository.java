package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swpdemo.openworld.model.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>{
    Account findAccountByUsernameAndPassword(String username, String password);
}
