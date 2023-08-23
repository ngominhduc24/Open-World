package swpdemo.openworld.services.servicesimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swpdemo.openworld.dto.AccountDTO;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.model.Profile;
import swpdemo.openworld.repository.IAccountRepository;
import swpdemo.openworld.repository.IProfileRepository;
import swpdemo.openworld.services.IAccountService;

@Service
public class AccountService implements IAccountService {
    String default_imageURL = "https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg";
    ModelMapper mapper = new ModelMapper();

    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    IProfileRepository profileRepository ;

    @Override
    public Account getAccountByUsernameAndPassword(String username, String password) {
        return accountRepository.findAccountByUsernameAndPassword(username, password);
    }

    @Override
    public Account registerNewAccount(AccountDTO accountDTO) {
        // Save Account to database
        Account account = mapper.map(accountDTO,Account.class);
        account.setStatus(1);
        account.setRole(1);
        long millis = System.currentTimeMillis();   // get current date and set to account createDate
        account.setCreateDate(new java.sql.Date(millis));
        Account newAccount = accountRepository.save(account);

        // Save Profile to database
        Profile profile = new Profile();
        profile.setAccountId(1);
        profile = mapper.map(accountDTO,Profile.class);
        profile.setAccountId(newAccount.getId());
        profile.setAvatarUrl(default_imageURL);
        profileRepository.save(profile);

        return account;
    }
}
