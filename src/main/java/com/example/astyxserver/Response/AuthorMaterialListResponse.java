package com.example.astyxserver.Response;

import com.example.astyxserver.Model.AuthorMaterial;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorMaterialListResponse extends BaseResponse{
    private List<AuthorMaterial> data;
    public AuthorMaterialListResponse(List<AuthorMaterial> data){
        super(true, "Авторские материалы");
        this.data = data;
    }

    public AuthorMaterialListResponse(Optional<AuthorMaterial> data){
        super(true,"Авторский материал");
        this.data = data.map(Collections::singletonList).orElse(Collections.emptyList());
    }
}
