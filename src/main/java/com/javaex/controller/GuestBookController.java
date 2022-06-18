package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {
	@Autowired
	//필드
	private GuestBookService guestbookservice;
	
	//리스트
	@RequestMapping(value="/addList", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("addList");
		
		List<GuestBookVo> gList = guestbookservice.guestbookList();
		System.out.println(gList);
		model.addAttribute("gList", gList);
		return "addList";
	}
	//등록
	@RequestMapping(value="/add", method= {RequestMethod.POST, RequestMethod.GET})
	public String add(@RequestParam ("name") String name,
					@RequestParam ("password") String password,
					@RequestParam("content")String content) {
		GuestBookVo guestbookVo = new GuestBookVo(name, password, content);
		guestbookservice.guestbookInsert(guestbookVo);
		System.out.println("add");
		return "redirect:/addList";
	}
	//삭제폼
	@RequestMapping(value="/deleteForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String deleteForm() {
		System.out.println("deleteForm");
		return"deleteForm";
	}
	//삭제
	@RequestMapping(value="/delete", method = {RequestMethod.POST, RequestMethod.GET})
	public String delete(@RequestParam("no") int no,
						@RequestParam("password") String password) {
		System.out.println("delete");
		GuestBookVo guestbookVo = guestbookservice.getGuest(no);
		
		if(guestbookVo.getPassword().equals(password)) {
			guestbookservice.guestbookDelete(guestbookVo);
			
		}
		return "redirect:/addList";
		
	}
}