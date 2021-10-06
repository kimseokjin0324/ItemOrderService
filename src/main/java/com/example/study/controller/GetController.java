package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method= RequestMethod.GET,path = "/getMethod")
    public String getRequest(){
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:8080/api/getParameter
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pwd){
        String password="bbbb";

        System.out.println("id: "+id);
        System.out.println("password: "+password);

        return id+pwd;
    }

    /**
     * HTTP-GET Method
     * 주소창에 파라미터가 노출됨
     * 브라우저에서 주소에 대한 캐시가 이루어 지므로 정보를 얻을때만 사용함
     * @param searchParam
     * @return
     */
    //Localhost:8080/api/getmultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiparameter")
    public SearchParam getMultiParameter(SearchParam searchParam){

        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        //{ "account" : "","email" :"","page" : 0}
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){
        // json형태로 {"resultCode": "OK" , "description": "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
