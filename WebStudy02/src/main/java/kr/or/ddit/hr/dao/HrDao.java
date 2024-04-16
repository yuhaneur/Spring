package kr.or.ddit.hr.dao;

import java.util.List;

import kr.or.ddit.hr.vo.CountriesVO;
import kr.or.ddit.hr.vo.DepartmentsVO;
import kr.or.ddit.hr.vo.EmployeesVO;
import kr.or.ddit.hr.vo.RegionsVO;
import kr.or.ddit.hr.vo.RetrieVO;

public interface HrDao {
	/**
	 * 대륙기준 부서까지 조회
	 */
	public List<RegionsVO> regionsList();
	
	/**
	 * 부서별 직원조회
	 */
	public List<DepartmentsVO> departEmployeesList();
	
	/**
	 * 직원 상세조회 (부서명, 업무명포함)
	 */
	public EmployeesVO detailEmployee();
	
	/**
	 * 선택한 직원 담당업무 or 소속 부서 변경
	 */
	public int updateEmployee();
	
	/**
	 * 선택한 직원 퇴사 처리
	 */
	public int updateRetire();
	
	/**
	 * 퇴사자 리스트
	 */
	public List<RetrieVO> retireList();
}
