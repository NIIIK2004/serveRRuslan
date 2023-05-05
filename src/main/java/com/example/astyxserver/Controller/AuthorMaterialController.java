package com.example.astyxserver.Controller;

import com.example.astyxserver.Model.AuthorMaterial;
import com.example.astyxserver.Response.AuthorMaterialListResponse;
import com.example.astyxserver.Response.BaseResponse;
import com.example.astyxserver.Service.AuthorMaterialService;
import com.example.astyxserver.Service.CourseService;
import com.example.astyxserver.Service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorMaterialController {
    private final AuthorMaterialService authorMaterialService;
    private final CourseService courseService;
    private final TestService testService;

    public AuthorMaterialController(AuthorMaterialService authorMaterialService, CourseService courseService, TestService testService) {
        this.authorMaterialService = authorMaterialService;
        this.courseService = courseService;
        this.testService = testService;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAllUser(){
        return ResponseEntity.ok(new AuthorMaterialListResponse(authorMaterialService.findAll()));
    }

    @PostMapping("/save")
    public ResponseEntity<BaseResponse> saveAuthorMaterial(@RequestBody AuthorMaterial data) {
        try {
            authorMaterialService.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Материал успешно добавлен!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> updateAuthorMaterial(@RequestBody AuthorMaterial data) {
        try {
            authorMaterialService.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Материал успешно обновлен!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable Long id) {
        try {
            authorMaterialService.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Пользователь успешно удален!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/findUserMaterial")
    public ResponseEntity<BaseResponse> findMaterialByUser(){
        return ResponseEntity.ok(new AuthorMaterialListResponse(authorMaterialService.findByUser()));
    }
}
