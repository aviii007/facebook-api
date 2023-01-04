package com.example.facebookapp.facebookapi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private  boolean status;
    private  T data;
}
