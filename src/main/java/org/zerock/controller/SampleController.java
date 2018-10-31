package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

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
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids")ArrayList<String> ids){
        log.info("ids: " + ids);
        return "ex02List";
    }
    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids){
        log.info("array ids: " + Arrays.toString(ids));
        return "ex02Array";
    }
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);
        return "ex02Bean";
    }
    //TodoDTO에 DateTimeFormat 적용시 얘는 필요 없다.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
    }
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";
    }
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page){
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "/sample/ex04";
    }
    @GetMapping("/ex05")
    public void ex05(){
        log.info("/ex05........");
    }
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06() {
        log.info("/ex06........");
        SampleDTO dto = new SampleDTO();
        dto.setAge(26);
        dto.setName("1ilsang");
        return dto;
    }
    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() {
        log.info("/ex07.........");
        String msg = "{\"name\": \"이상철\"}";
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }
    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload........");
    }
    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        files.forEach(file -> {
            log.info("---------------------");
            log.info("name: " + file.getOriginalFilename());
            log.info("size: " + file.getSize());
        });
    }
}
