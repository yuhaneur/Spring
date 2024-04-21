package kr.or.ddit.alba.service;

import java.util.List;

import kr.or.ddit.alba.ServiceResult;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.vo.AlbaModel;

public interface AlbaService {
	public List<AlbaModel> retrieveAlbaList(PaginationInfo paging);
	public AlbaModel retrieveAlba(String alId);
	public ServiceResult createtAlba(AlbaModel alba);
	public ServiceResult modifyAlba(AlbaModel alba);
	public int removeAlba(String alId);
}
