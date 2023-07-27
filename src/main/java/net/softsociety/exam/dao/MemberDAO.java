package net.softsociety.exam.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Member;

/**
 * 회원정보 관련 매퍼
 */
@Mapper
public interface MemberDAO {
	
	public void join(Map<String, String> request);
	
	public int check(Map<String, String> request);
}
