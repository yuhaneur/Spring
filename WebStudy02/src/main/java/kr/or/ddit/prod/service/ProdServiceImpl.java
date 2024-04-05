package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements ProdService {
	private ProdDAO dao = new ProdDAOImpl();

	@Override
	public List<ProdVO> retrieveProdList() {
		return dao.selectProdList();
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PkNotFoundException {
		ProdVO prod = dao.selectProd(prodId);
		if(prod==null) throw new PkNotFoundException(500);
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
