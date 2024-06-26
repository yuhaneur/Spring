package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= {"cartNo","cartProd"})
public class CartVO implements Serializable{
	private String cartMember;
	private String cartNo;
	private String cartProd;
	private long cartQty;
	private LocalDate cartDate;
	
	
	private MemberVO member; //Has A
	private ProdVO prod; // Has A
}
