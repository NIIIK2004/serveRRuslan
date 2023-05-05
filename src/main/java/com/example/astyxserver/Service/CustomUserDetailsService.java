package com.example.astyxserver.Service;

import com.example.astyxserver.Model.User;
import com.example.astyxserver.Repo.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null && user.isActive()) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
        } else if (user != null && !user.isActive()) {
            throw new UsernameNotFoundException("Пользователь не активирован");
        } else {
            throw new UsernameNotFoundException("Не правильный логин или пароль");
        }
    }
}