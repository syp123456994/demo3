package com.example.demo3.controller;

import com.example.demo3.Entity.Signin;
import com.example.demo3.Repository.SigninRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signin")
public class SigninHandler {

    @Autowired
    private SigninRepository signRepository;

    //分页
    @GetMapping("/findAll/{page}/{size}")
    public Page<Signin> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return signRepository.findAll(pageable);
    }

    //添加数据
    @PostMapping("/save")
    public String save(@RequestBody Signin signin){
        Signin result=signRepository.save(signin);
        if (result!=null){
            return "success";
        }else{
            return "false";
        }
    }

}
