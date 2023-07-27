package net.softsociety.exam.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.exam.dao.MemberDAO;
import net.softsociety.exam.domain.Member;

@Service
public class MemberSeviceImpl implements MemberService {
	
	@Autowired
	MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void join(Map<String, String> request) {
		
		dao.join(request);
	}
		
		

	@Override
	public int check(Map<String, String> request) {
		// TODO Auto-generated method stub
		int n = dao.check(request);
		return n;
	}

	
	
	
	
   

}
