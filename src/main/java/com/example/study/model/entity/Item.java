package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;
    //1:N
    //FetchType=LAZY=지연로딩,EAGER=즉시로딩
    //LAZY = select * from item where id=?

    //EAGER = 추천하는 타입은 아님 1:1 일때만 추천하는 방식
    // item_id=order_detail.item_id
    // user_id=order_detail.user_id
    //where item.id=?
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
