package kr.or.ddit.adrs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.adrs.dao.AdrsDao;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.person.exception.PkNotFoundException;
import kr.or.ddit.vo.AdrsVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdrsServiceImpl implements AdrsService{
	
	private final AdrsDao dao;
	@Override
	public ServiceResult insertAdrs(AdrsVO adrs) {
		if(dao.selectAdrs(adrs.getAdrsNo())!=null) {
			throw new PkNotFoundException(400);
		}
		int cnt = dao.insertAdrs(adrs);
		return cnt>0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public List<AdrsVO> selectAdrsList() {
		return dao.selectAdrsList();
	}

	@Override
	public AdrsVO selectAdrs(int adrsNo) {
		AdrsVO adrs= dao.selectAdrs(adrsNo);
		if(adrs==null)throw new PkNotFoundException(400);
		return adrs;
		
	}

}
