package com.cos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class IndexController {
	
	
	@Autowired
	Test t;
	
	
	
	// http://localhost:8080/
	@GetMapping({"","/"})   //get 방식으로 들어올 때 "", / 이면 index()함수를 탄다 
	public @ResponseBody String index() {
		System.out.println(t.num);
	
		
		return "Hello"; // ViewResolver
						// RequestDispatcher를 할 필요 없이 해줌.
		
	}
	
	
	// x-www-form-urlencoded => key = value
	@PostMapping({"/form"})   
	public @ResponseBody String form(String username, String password, String email) {
		System.out.println(username); // RequestgetParameter가 내부에 있다
		System.out.println(password);
		System.out.println(email);
	
		return "User"; 
						
		
	}
	
	// x-www-form-urlencoded => key = value
	@PostMapping({"/form/model"})   
	public @ResponseBody String formModel(User user) { // 오브젝트로 받는게 좋다
		System.out.println(user.getUsername()); // RequestgetParameter가 내부에 있다
		System.out.println(user.getPassword()); // MIME TYPE from-url-encoded일 때만 받을 수 있다. (폼 유형 데이터)
		System.out.println(user.getEmail());    // json은 안됨.
	
		return "User"; 
						
		
	}
	
	
	@GetMapping({"/form/model"})   
	public @ResponseBody String formModelGet(User user) { 
		System.out.println(user.getUsername()); 
		System.out.println(user.getPassword()); 
		System.out.println(user.getEmail());    
	
		return "User"; 
						
		
	}
	
	
	// json => {"key" : "value"}  json데이터는 get방식으로 못 받는다.
	@PostMapping({"/json/model"})   
	public @ResponseBody User jsonModel(@RequestBody User user) { 
		
		System.out.println(user.getUsername()); 
		System.out.println(user.getPassword()); 
		System.out.println(user.getEmail());    
	
		return user; // ViewResolver 작동금지 => Jackson 작동.
						
		
	}
	
}
