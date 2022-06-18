package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestBookService {
	
	//필드
	@Autowired
	public GuestBookDao guestbookDao;
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	
	//리스트
	public List<GuestBookVo> guestbookList(){
	
	List<GuestBookVo> getguestbookList = guestbookDao.guestbookList();
	
	return getguestbookList;
	}
	
	//등록
	public int guestbookInsert(GuestBookVo guestbookVo) {
		
		int count = guestbookDao.guestInsert(guestbookVo);
		return count;
	}
	//삭제할정보
	public GuestBookVo getGuest(int no) {
		
		GuestBookVo guestList = guestbookDao.getGuest(no);
		
		return guestList;
	}
	
	//삭제
	public int guestbookDelete(GuestBookVo guestbookVo) {
		int count = guestbookDao.guestDelete(guestbookVo);
		
		return count;
	}
}
