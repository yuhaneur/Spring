package kr.or.ddit.vo;

import lombok.Data;

@Data
public class MyLicModel {
	private String alId;
	private String licCode;
	private String licDate;
	private String licJmg;
	
	private LicenceModel licence;
}
