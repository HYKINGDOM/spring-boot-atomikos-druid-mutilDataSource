package com.java.boots.atomikos.business.first.controller;


import com.java.boots.atomikos.business.first.service.RPDBDataImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class RPDBController {

    @Autowired
    private RPDBDataImp rpdbDataImp;

    @GetMapping("/getFirst")
    public Object getFirstDbData() {

        return rpdbDataImp.getRpDbData();
    }


}
