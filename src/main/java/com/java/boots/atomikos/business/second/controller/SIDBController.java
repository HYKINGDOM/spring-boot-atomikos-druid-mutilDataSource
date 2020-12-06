package com.java.boots.atomikos.business.second.controller;


import com.java.boots.atomikos.business.second.service.SIDBDataImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SIDBController {

    @Autowired
    private SIDBDataImp sidbDataImp;

    @GetMapping("/getSecond")
    public Object getFirstDbData() {
        return sidbDataImp.getSIdbData();
    }


}
