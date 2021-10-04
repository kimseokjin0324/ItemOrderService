package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    // select *from user where account=? << test03,test04....등등이 들어옴
    Optional<User> findByAccount(String account);

    // select * from user where email=?
    Optional<User> findByEmail(String email);
    //여러가지 조건으로 검색할때ㅣ
    //select * from user where account=? and email=?
    Optional<User> findByAccountAndEmail(String account,String email);
}
