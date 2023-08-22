package swpdemo.openworld.services.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.repository.IAccountRepository;
import swpdemo.openworld.services.IAccountService;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

    @Override
    public Account getAccountByUsernameAndPassword(String username, String password) {
        return accountRepository.findAccountByUsernameAndPassword(username, password);
    }
}
