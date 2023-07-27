package net.softsociety.exam.service;

import java.util.Map;

import net.softsociety.exam.domain.Member;

/** 
 * 회원정보 관련 서비스
 */
public interface MemberService {
	
	public void join(Map<String, String> request);

	public int check(Map<String, String> request);
}
