package com.example.demo3.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SignRepositoryTest {
    @Autowired
    private SigninRepository signRepository;

    @Test
   void findAll(){
        System.out.println(signRepository.findAll());
   }
}