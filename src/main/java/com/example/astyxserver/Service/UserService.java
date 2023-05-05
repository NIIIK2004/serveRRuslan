package com.example.astyxserver.Service;

import com.example.astyxserver.Model.User;
import com.example.astyxserver.Repo.UserRepo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final MailSender mailSender;

    private final UserRepo userRepo;

    public UserService(PasswordEncoder passwordEncoder, MailSender mailSender, UserRepo userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
        this.userRepo = userRepo;
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public void delete(Long id){
        this.userRepo.deleteById(id);
    }

    public void save(User user) throws IOException {
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setNumber(user.getNumber());
        user.setFile(user.getFile());
        user.setDate(user.getDate());
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(user.getRoles());
        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString());

        userRepo.save(user);

        if (user.getEmail() != null && !user.getEmail().isEmpty()){
            String message = String.format("Привет, %s! \n" +
                            "http://localhost:8080/api/auth/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSender.send(user.getEmail(), "Код активации", message);
        }
    }

    public boolean activate(String code) {
        User user = userRepo.findByActivationCode(code);
        if (user == null){
            return false;
        }
        user.setActivationCode(null);
        user.setActive(true);
        userRepo.save(user);
        return true;
    }

    public void banUser(User user){
        user.setActive(false);
        userRepo.save(user);
    }

    public User findUserByUsername(String username){
        return userRepo.findByUsername(username);
    }
}
