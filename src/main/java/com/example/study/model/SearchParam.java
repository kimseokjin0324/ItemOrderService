package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {
    private String account;
    private String email;
    private int page;

//    //{ "account" : "","email" :"","page" : 0} 스프링에서 잭슨을 통해서 JSON형태로 바꿔줄것임
//
// 롬복을 사용하면 아래 부분들을 만들 필요가 없음(생산성을 높여줌)
//    public SearchParam(){
//
//    }
//    public SearchParam(String account){
//        this.account=account;
//
//    }
//
//    public SearchParam(String account, String email, int page) {
//        this.account = account;
//        this.email = email;
//        this.page = page;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
}
