package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    @RequestMapping("")
    public void hi(){
        log.info("/samle/");
        log.info("--------------------");
    }
    @GetMapping("doA")
    public void doA(){
        log.info("doA called..........");
        log.info("--------------------");
    }
    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basic(){
        log.info("GET || POST] /sample/basic/");
        log.info("-----------------------");
    }
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        log.info("/ex01 " + dto);
        return "ex01";
    }
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        log.info("name: " + name);
        log.info("age: " + age);
        return "ex02";
    }
}
