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
import swpdemo.openworld.util.GooglePojo;

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
        // Check username is phonenumber or email
        String username = accountDTO.getUsername();
        profile.setEmail(username.contains("@") ? username : null);
        profile.setPhone(username.contains("@") ? null : username);
        profile.setAccountId(newAccount.getId());
        profile.setAvatarUrl(default_imageURL);
        profileRepository.save(profile);

        return account;
    }

    public Account registerAccount(GooglePojo googlePojo) {
        String username = googlePojo.getEmail();
        String name = username.replace("@gmail.com", "");
        name = name.replace("@fpt.edu.vn", "");
        String password = googlePojo.getId();

        //save to account
        Account newAccount = new Account();
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        newAccount.setStatus(1);
        newAccount.setRole(1);
        newAccount.setCreateDate(new java.sql.Date(System.currentTimeMillis()));
        Account newAcc = accountRepository.save(newAccount);;
        //save to profile
        Profile newProfile = new Profile();
        newProfile.setAccountId(newAcc.getId());
        newProfile.setFullName(name);
        newProfile.setAvatarUrl(googlePojo.getPicture());
        profileRepository.save(newProfile);
        return newAcc;
    }
}
