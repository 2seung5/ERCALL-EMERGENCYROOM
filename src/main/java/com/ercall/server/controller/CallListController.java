package com.ercall.server.controller;

import com.ercall.server.dto.ErTriageResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ertriage")
public class CallListController {

    @GetMapping("/calllist")
    public String showCallList(){
        return "CallList/calllist";
    }

    @GetMapping("/calllist/{erTriageId}")
    public String showErTraige(@PathVariable final Long erTriageId, Model model ){
        model.addAttribute("ErTriageId",erTriageId);
        return "CallList/showertriage";
    }

}
