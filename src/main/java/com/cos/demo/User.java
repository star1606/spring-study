package com.cos.demo;

import lombok.Data;

@Data
public class User {
	private String username;
	private String password;
	private String email;
}
// 스프링 컨텍스트에 등록하면 안된다 new 100번해야하는데 그러면 못함