package com.example.astyxserver.Controller;

import com.example.astyxserver.Model.User;
import com.example.astyxserver.Response.BaseResponse;
import com.example.astyxserver.Service.CustomUserDetailsService;
import com.example.astyxserver.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder, CustomUserDetailsService customUserDetailsService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/registration")
    public ResponseEntity<BaseResponse> registration(@RequestBody User data) {
        try {
            userService.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Пользователь успешно зарегистрирован!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<BaseResponse> activate(@PathVariable String code) {
        boolean isActivated = userService.activate(code);
        if (isActivated) {
            return ResponseEntity.ok(new BaseResponse(true, "Пользователь успешно активирован!"));
        } else {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "Пользователь уже активирован, либо код активации не найден!"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(HttpServletRequest request, @RequestBody User data){
        User user = userService.findUserByUsername(data.getUsername());
        if (user != null && passwordEncoder.matches(data.getPassword(), user.getPassword()) && user.isActive()){
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(data.getUsername());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            return ResponseEntity.ok(new BaseResponse(true, "Вы успешно авторизовались!"));
        }
        else{
            return ResponseEntity.badRequest().body(new BaseResponse(false,"Не правильный логин или пароль"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<BaseResponse> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok(new BaseResponse(true, "Вы успешно вышли из системы!"));
    }

//    @GetMapping("/user")
//    public ResponseEntity<BaseResponse> getUserInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        return ResponseEntity.ok(new BaseResponse(true, "Информация о пользователе " + username));
//    }
}
