package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.hr.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	private MemberDAO dao = new MemberDAOImpl();
	
	@Override
	public ServiceResult createMember(MemberVO member) {
//		OK, FAIL, PKDUPLICATED
		if(dao.selectMember(member.getMemId())!=null) {
			return ServiceResult.PKDUPLICATED;
		}
		int cnt =dao.insertMember(member); 
		if(cnt>0) {
			return ServiceResult.OK;
		}else {
			return ServiceResult.FAIL;
		}
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		return dao.selectMemberList();
	}

	@Override
	public MemberVO retrieveMember(String memId) throws PkNotFoundException {
		MemberVO member = dao.selectMember(memId);
		if(member ==null) {
			throw new PkNotFoundException(500);
		}
		return member;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) throws PkNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO inputData) throws PkNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
