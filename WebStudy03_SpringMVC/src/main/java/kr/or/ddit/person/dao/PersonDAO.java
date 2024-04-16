package kr.or.ddit.person.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.PersonVO;

/**
 *	Persistence(지속성있는) Layer : persistence 영역에 저장된 raw data를 domain 객체로 매핑하는 역할을 담당하는 객체.
 * 
 */

@Mapper
public interface PersonDAO {

	public List<PersonVO> selectPersonList();

	public PersonVO selectPerson(String id);

}