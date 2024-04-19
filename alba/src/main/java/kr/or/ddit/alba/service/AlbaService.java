package kr.or.ddit.alba.service;

import java.util.List;

import kr.or.ddit.vo.AlbaModel;

public interface AlbaService {
	public List<AlbaModel> retrieveAlbaList();
	public AlbaModel retrieveAlba();
	public int createtAlba(AlbaModel alba);
	public int modifyAlba(AlbaModel alba);
	public int removeAlba(String alId);
}
