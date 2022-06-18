package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;
@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트
	public List<GuestBookVo> guestbookList(){
		List<GuestBookVo> getguestbookList = sqlSession.selectList("guestbook.selectList");
		System.out.println(getguestbookList);
		return getguestbookList;
	}
	//추가
	public int guestInsert(GuestBookVo guestbookVo) {
		System.out.println("GuestDao>guestInsert()");
		
		int count = sqlSession.insert("guestbook.guestInsert",guestbookVo);
		return count;
	}
	//1명 정보 가져오기
	public GuestBookVo getGuest(int no) {
		System.out.println("GuestDao>getGuest()");
		
		GuestBookVo guestbookVo = sqlSession.selectOne("guestbook.getGuest", no);
		return guestbookVo;
	}
	
	//삭제
	public int guestDelete(GuestBookVo guestbookVo) {
		System.out.println("GuestDao>guestDelete()");
		
		int count = sqlSession.delete("guestbook.guestDelete", guestbookVo);
		
		return count;
	}
	
}