package com.java.boots.atomikos.business.testController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestDemoController {

    @Autowired
    private TestDemoInterface testDemoInterface;


    @GetMapping("/testDemo")
    public Object getFirstDbData() {
        return testDemoInterface.testInsert();
    }

    @GetMapping("/testDemoNoTransactional")
    public Object getTransactional() {
        return testDemoInterface.testInsertNotTransactional();
    }
}
