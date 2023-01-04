package com.example.facebookapp.facebookapi.util;

import com.example.facebookapp.facebookapi.model.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Data
@Service
public class ResponseManager<T> {
    public ApiResponse<T> success(T successMessage){
        return new ApiResponse<T>("Request successful",true,successMessage);
    }
    public ApiResponse<T> error(T errorMessage){
        return new ApiResponse<T>("Request failed",false,errorMessage);
    }
}
