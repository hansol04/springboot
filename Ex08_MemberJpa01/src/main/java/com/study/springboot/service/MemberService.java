package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	public Member insert(Member member) {
		// save() : jpa에서 insert메소드 
		//   		동일한 키가 있으면 update, 키가 없으면 insert
		
		Member result = memberRepository.save(member);
		return result;
	}
	public Optional<Member> select(Long id) {
		return memberRepository.findById(id);
	}
	public List<Member> selectAll() {
		return memberRepository.findAll();
	}
	/* jpa 메소드
	삭제시 : deleteById(id)
	업데이트시 : save(member)
	*/
	public Optional<Member> delete(Long id) {
		return memberRepository.deleteById(id);
	}
}
