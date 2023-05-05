package com.example.astyxserver.Response;

import com.example.astyxserver.Model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserListResponse extends BaseResponse{
    private List<User> data;
    public UserListResponse(List<User> data){
        super(true, "Пользователи");
        this.data = data;
    }

    public UserListResponse(Optional<User> data){
        super(true,"Пользователь");
        this.data = data.map(Collections::singletonList).orElse(Collections.emptyList());
    }
}
