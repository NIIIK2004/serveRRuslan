package com.example.astyxserver.Controller;

import com.example.astyxserver.Model.User;
import com.example.astyxserver.Response.BaseResponse;
import com.example.astyxserver.Response.UserListResponse;
import com.example.astyxserver.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAllUser(){
        return ResponseEntity.ok(new UserListResponse(userService.findAll()));
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> updateUser(@RequestBody User data) {
        try {
            userService.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Пользователь успешно обновлен!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/ban")
    public ResponseEntity<BaseResponse> banUser(@RequestBody User data) {
        try {
            userService.banUser(data);
            return ResponseEntity.ok(new BaseResponse(true, "Пользователь забанен!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Пользователь успешно удален!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}
