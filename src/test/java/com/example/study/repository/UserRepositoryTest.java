package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        String account="Test03";
        String password="Test03";
        String status="REGISTERED";
        String email="Test01@gamil.com";
        String phoneNumber="010-1111-3333";
        LocalDateTime registeredAt=LocalDateTime.now();
        LocalDateTime createdAt=LocalDateTime.now();
        String createdBy="AdminServer";



        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User u =User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        User newUser=userRepository.save(user);

        Assert.assertNotNull(newUser);

    }
    @Test
    @Transactional
    public void read(){

        User user=userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("---------------주문묶음-----------------");
            System.out.println("수령인:"+orderGroup.getRevName() );
            System.out.println("총금액:"+orderGroup.getTotalPrice());
            System.out.println("수령지:"+orderGroup.getRevAddress());
            System.out.println("총수량:"+orderGroup.getTotalQuantity());
            System.out.println("---------------주문상세-----------------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너 사 이름 : "+orderDetail.getItem().getPartner().getName());
                System.out.println("파트너 사 카테고리 : "+orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " +  orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " +  orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착 예정일자 : " + orderDetail.getArrivalDate());

               ;
            });

        });
        Assert.assertNotNull(user);
    }


    @Test
    @Transactional
    public void update(){
        Optional<User> user=userRepository.findById(2L);
        //반드시 유저가 있을수도 있고 없을수도 있으니까 ifPresent를 통해서 있는지 확인
        user.ifPresent(selectuser->{
            selectuser.setAccount("pppp");
            selectuser.setUpdatedAt(LocalDateTime.now());
            selectuser.setUpdatedBy("update method()");

            userRepository.save(selectuser);
        });
    }
    @Test
    @Transactional
    public void delete(){
        Optional<User> user=userRepository.findById(3L);

        Assert.assertTrue(user.isPresent());//true

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });
        Optional<User> deleteUser=userRepository.findById(3L);
        Assert.assertFalse(deleteUser.isPresent());//false
    }
}
