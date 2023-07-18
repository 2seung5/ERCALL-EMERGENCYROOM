package com.ercall.server.controller;

import com.ercall.server.dto.ErTriageResponseDto;
import com.ercall.server.service.ErTriageService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ErTriageController {

    private final ErTriageService erTriageService;

    @GetMapping("/ertriage") //콜 리스트 조회
    public List<ErTriageResponseDto> findAll(Model model){

        return erTriageService.findAll();
    }

    @GetMapping("/ertriage/{erTriageId}") //중증도 분류표 상세조회
    public ErTriageResponseDto findById(@PathVariable final Long erTriageId){
        return erTriageService.findById(erTriageId);
    }
}
