package com.cos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.demo.repository.MemberRepository;

public class MyBatisController {
	
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	
}
