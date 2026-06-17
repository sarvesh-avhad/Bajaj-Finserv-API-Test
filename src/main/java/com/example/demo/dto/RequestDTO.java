package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RequestDTO {

    @NotNull
    private List<String> data;
}