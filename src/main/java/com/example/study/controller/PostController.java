package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

//    @RequestMapping(method= RequestMethod.POST,path="/postMethod") 아래 와 동일함
    //HTML <Form>
    //ajax 검색때 사용됨
    //http post body->data
    //json,xml,multipart-form(파일을 올릴때)/text-plain
    @PostMapping(value = "/postMethod")
    public String postMethod(@RequestBody SearchParam searchParam){
        return "ok";
    }
}
