package kr.or.ddit.case5.person.exception;

/**
 * PK 로 조회한 데이터가 없을때 발생시킴.
 *
 */
public class PkNotFoundException extends ResponseStatusException{

	public PkNotFoundException(int status) {
		super(status, "해당 데이터가 존재하지 않습니다.");
		
	}

}
