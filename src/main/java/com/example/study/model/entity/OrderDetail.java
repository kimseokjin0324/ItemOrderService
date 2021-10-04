package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity //order_detail에 자동적으로 연결이됨
@ToString(exclude = {"user","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    //N(OrderDetail):1(User)
    @ManyToOne
    private User user;//하이버네이트에서 알아서 user_id를 찾아감

    //N(OrderDetail):1(Item)
    @ManyToOne
    private Item item;

}
