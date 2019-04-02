package com.billennium.bcvsaver.controller;

import com.billennium.bcvsaver.dto.CvDto;
import com.billennium.bcvsaver.service.impl.CvServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/cvs")
@ResponseStatus(HttpStatus.OK)
public class CvController {
    @Resource(name= "cvServiceImpl")
    private CvServiceImpl cvService;

    @PostMapping("/addCv")
    @ResponseStatus(HttpStatus.OK)
    public CvDto addCv(@RequestBody CvDto cvDto) {
        return cvService.addCv(cvDto);
    }
}
