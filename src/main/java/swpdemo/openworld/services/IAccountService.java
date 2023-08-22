package swpdemo.openworld.services;

import swpdemo.openworld.model.Account;

public interface IAccountService {
    Account getAccountByUsernameAndPassword(String username, String password);

}
