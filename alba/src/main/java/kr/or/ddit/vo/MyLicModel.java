package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"alId","licCode"})
public class MyLicModel implements Serializable{
	private String alId;
	private String licCode;
	private String licDate;
	private String licJmg;
	private LicenceModel licence;
	
}
