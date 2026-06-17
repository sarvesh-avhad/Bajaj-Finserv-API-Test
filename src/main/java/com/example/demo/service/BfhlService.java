package com.example.demo.service;

import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.ResponseDTO;

public interface BfhlService{

    ResponseDTO process(RequestDTO request,
                        String requestId);
}