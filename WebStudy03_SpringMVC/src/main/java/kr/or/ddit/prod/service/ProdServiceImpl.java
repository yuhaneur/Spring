package kr.or.ddit.prod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdServiceImpl implements ProdService {
	private final ProdDAO dao;

	@Override
	public List<ProdVO> retrieveProdList() {
		return dao.selectProdList();
	}

	@Override
	public ProdVO retrieveProd(String prodId) {
		ProdVO prod = dao.selectProd(prodId);
		return prod;
	}

	@Override
	public ServiceResult createProd(ProdVO prod) {
		return dao.insertProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL; 
	}


	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		return dao.updateProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL; 
	}
}
