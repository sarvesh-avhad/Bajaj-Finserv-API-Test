package com.example.demo.controller;

import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.BfhlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BfhlController {

    private final BfhlService bfhlService;

    @GetMapping("/health")
    public String health() {
        return "UP";
    }

    @PostMapping("/bfhl")
    public ResponseEntity<ResponseDTO> processData(
            @RequestHeader("X-Request-Id") String requestId,
            @Valid @RequestBody RequestDTO request) {

        return ResponseEntity.ok(
                bfhlService.process(request, requestId)
        );
    }
}