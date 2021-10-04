package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.StudyApplicationTests;
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
        User user=new User();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser= userRepository.save(user);
        System.out.println("newUser = " + newUser);
    }
    @Test
    public void read(){
        Optional<User> user=userRepository.findById(2L);

        user.ifPresent(selectuser->{
            System.out.println("user = " + selectuser);
            System.out.println("email = " + selectuser.getEmail());
        });

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
