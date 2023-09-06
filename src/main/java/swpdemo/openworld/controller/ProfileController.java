package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.model.Profile;
import swpdemo.openworld.services.servicesimpl.FriendshipService;
import swpdemo.openworld.services.servicesimpl.ProfileService;
import swpdemo.openworld.services.servicesimpl.UserPostService;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @Autowired
    UserPostService userPostService;

    @Autowired
    FriendshipService friendshipService;

    @GetMapping
    public String profilePage(Model model, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        Profile profile = profileService.GetProfileByAccountId(account.getId());
        model.addAttribute("profile", profile);

        // Get list Image
        final int numberOfImg = 9;
        model.addAttribute("listUrlImg", userPostService.getPostByAccountId(account.getId(), numberOfImg));

        // Get list friend
        final int numberOfFriend = 9;
        model.addAttribute("listFriend", friendshipService.getListProfileNameAndAvtFriend(account.getId(), numberOfFriend));
        return ("profile");
    }

    @PostMapping("/update")
    public String update(@RequestParam("photo") MultipartFile photo, HttpSession session) {
        if (photo.isEmpty()) {
            return "redirect:/profile";
        }
        Path path = Paths.get("upload/");
        try {
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            if(photo.getOriginalFilename() != null){
                Account account = (Account) session.getAttribute("account");
                Profile profile = profileService.GetProfileByAccountId(account.getId());
                profile.setAvatarUrl("profile/getImg/" + photo.getOriginalFilename());
                profileService.updateProfile(account.getId(), profile);
            }
        } catch (Exception e) {

        }
        return "redirect:/profile";
    }

    @RequestMapping(value = "getImg/{photo}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImg(@PathVariable("photo") String photo) {
        if (!photo.equals("") || photo != null) {
            try {
                Path filename = Paths.get("upload", photo);
                byte[] buffer = Files.readAllBytes(filename);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                System.out.println(ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/jpg"))
                        .body(byteArrayResource));
                return  ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/jpg"))
                        .body(byteArrayResource);
            } catch (Exception e){

            }
        }
        return ResponseEntity.badRequest().build();
    }

}
