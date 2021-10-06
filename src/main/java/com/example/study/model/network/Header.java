package com.example.study.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    //api 통신시간
    //@JsonProperty("transaction_time")이렇게 할수도 있음 but 하나하나 다 할수 없음
    //개발을 할때는 카멜 케이스 전문을 주고받을때는 설정을 줘서 편리하게 할 수 있다.
    private LocalDateTime transactionTime; // ISO, YYYY-MM-DD, HH:mm:ss

    // api 응답코드
    private String resultCode;

    // api 부가 설명
    private String description;

    private T data;

    //OK 정상적일때 호출
    public static  <T> Header <T> OK(){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    // DATA OK
    public static  <T> Header <T> OK(T data){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }
    //Error 비정상적일때 description을 매개변수로 받아서 프론트쪽에 알려줌
    public static  <T> Header <T> ERROR(String description){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }

}
