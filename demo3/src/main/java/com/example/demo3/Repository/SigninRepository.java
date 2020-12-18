package com.example.demo3.Repository;

import com.example.demo3.Entity.Signin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SigninRepository extends JpaRepository<Signin,Integer> {
}
