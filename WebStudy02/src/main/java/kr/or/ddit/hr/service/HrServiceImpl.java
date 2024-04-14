package kr.or.ddit.hr.service;

import java.util.List;

import kr.or.ddit.hr.dao.HrDao;
import kr.or.ddit.hr.vo.DepartmentsVO;
import kr.or.ddit.hr.vo.EmployeesVO;
import kr.or.ddit.hr.vo.RegionsVO;
import kr.or.ddit.hr.vo.RetrieVO;

public class HrServiceImpl implements HrService{
	private final HrDao dao;
	@Override
	public List<RegionsVO> regionsList() {
		
		return null;
	}

	@Override
	public List<DepartmentsVO> departEmployeesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeesVO detailEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEmployee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRetire() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RetrieVO> retireList() {
		// TODO Auto-generated method stub
		return null;
	}

}
