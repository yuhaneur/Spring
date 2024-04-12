package kr.or.ddit.adrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.ddit.adrs.service.AdrsService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AdrsVO;
import kr.or.ddit.vo.PersonVO;

@Controller
public class AdrsController {
	@Autowired
	AdrsService service;
	
	public List<AdrsVO> adrsListToResponse(){
		List<AdrsVO> list = service.selectAdrsList();
		return list;
	}
	public AdrsVO adrsResponse(int id){
		AdrsVO adrs = service.selectAdrs(id);
		return adrs;
	}
	public String adrsInsert(AdrsVO adrsvo){
		ServiceResult result = service.insertAdrs(adrsvo);
		String text="등록실패";
		if(result.equals(ServiceResult.OK)) {
			text="등록성공";
		}
		return text;
	}
}
