package kr.or.ddit.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.hr.dao.HrDao;
import kr.or.ddit.hr.vo.DepartmentsVO;
import kr.or.ddit.hr.vo.EmployeesVO;
import kr.or.ddit.hr.vo.RegionsVO;
import kr.or.ddit.hr.vo.RetrieVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HrServiceImpl implements HrService{
	private final HrDao dao;
	@Override
	public List<RegionsVO> regionsList() {
		
		return dao.regionsList();
	}

	@Override
	public List<DepartmentsVO> departEmployeesList() {
		return dao.departEmployeesList();
	}

	@Override
	public EmployeesVO detailEmployee() {
		return dao.detailEmployee();
	}

	@Override
	public int updateEmployee() {
		return dao.updateEmployee();
	}

	@Override
	public int updateRetire() {
		return dao.updateRetire();
	}

	@Override
	public List<RetrieVO> retireList() {
		return dao.retireList();
	}

}
