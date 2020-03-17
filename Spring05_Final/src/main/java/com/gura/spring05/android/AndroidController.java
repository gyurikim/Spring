package com.gura.spring05.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Controller
public class AndroidController {
	@Autowired
	private MemberDao memberDao;
	
	/*
	 * ["김구라","해골","원숭이"] 형식의 문자열이 응답되는 메소드
	 */
	//서버에 List<>를 보내면 ["xxx","xxx"] 이러한 문자열이 응답되고, 이 문자열은 안드로이드에서는 JSONArray로 응답된다
	@ResponseBody
	@RequestMapping("/android/getnames")
	public List<String> getNames(){
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		names.add("김규리");
		return names;
	}
	
	/*
	 * {"num":1,"name":"김구라","isMan":true}형식의 json문자열이 응답된다.
	 */
	@ResponseBody
	@RequestMapping("/android/getdetail")
	public Map<String, Object> getDetail(){
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		return map;
	}
	
	@ResponseBody//pom.xml문서에 작성해 두었던 '잭슨-데이터바인드' 라이브러리가 알아서 제이슨형식으로 데이터를 응답한다.
	@RequestMapping("/android/getmember")
	public List<Map<String,Object>> getMember() {
		return memberDao.getList2();
	}
	
	@ResponseBody
	@RequestMapping("/android/member/list")
	public List<Map<String,Object>> memberGetList(){
		return memberDao.memberGetList();
	}
	
	 /*
	  * Dto를 리턴해도 @ResponseBody 어노테이션을 붙여도 Map을 리턴한것과 동일하게 응답된다
	  * {"num":1,"name":"김구라","addr":"노량진"}
	  */
	@ResponseBody
	@RequestMapping("/android/member/detail")
	public MemberDto memberDetail(@RequestParam int num) {
		return memberDao.getData(num);
	}
	
	@ResponseBody
	@RequestMapping("/android/member/delete")
	public String memberDelete(@RequestParam int num) {
		memberDao.delete(num);
		return "{\"isSuccess\":true}"; 
	}	
	
	@ResponseBody
	@RequestMapping("/android/member/insert")
	public String memberInsert() {
		memberDao.insert(dto);
		return "{\"isSuccess\":true}"; 
	}	
}






