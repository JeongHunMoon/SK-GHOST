package com.example.Moon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // 웹어플리케이션에서 /hello 라고 요청이 들어오면 아래 메소드가 호출된다.

    @GetMapping("page1")
    public String method1(Model model) {
        model.addAttribute( "data", "안녕!!");
        return "page1";
    }

    @GetMapping("/path/page2")
    public String method2(Model model) {
        model.addAttribute( "data", "안녕!!");
        return "/path/page2";
    }

    @GetMapping("hello-mvcc")
    // http://localhost:8080/hello-mvc?name=123
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //HTTP에서 바디에 reutnr 내용을 직접 넣는 것임.
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        
    }
    class Hello {
        private String name;

        public String getName(){
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
