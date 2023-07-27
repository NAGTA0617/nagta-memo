package net.softsociety.exam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.service.MemberService;

/**
 * 회원 정보 관련 콘트롤러
 */

@Slf4j
@RequestMapping("member")
@Controller
public class MemberController {
	@Autowired
	MemberService service;
//회원가입창
	@GetMapping("join")
	public String join() {
		return "join";
	}
//아이디 중복체크
	@PostMapping("join")
	@ResponseBody //객체를 반환할 때 사용함.*ajax쓸때 참고(화면 전환이 아님)
	public Map<String, String> join(@RequestParam Map<String, String> request) {
		int c = service.check(request);
		Map<String, String> resultMap = new HashMap<>();
		if(c > 0) {
			resultMap.put("result", "N");
			resultMap.put("msg", "중복된아이디");
			
			return resultMap;
		}
		
		service.join(request);
		resultMap.put("result", "Y");
		resultMap.put("msg", "사용가능");
		
		log.debug("{}", c);
		return resultMap;
	}
	
	@GetMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	@PostMapping("login")
	public String login() {
		return "redirect:/";
	}
	

}
