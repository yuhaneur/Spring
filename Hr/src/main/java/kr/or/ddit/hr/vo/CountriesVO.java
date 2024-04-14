package kr.or.ddit.hr.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "countryId")
public class CountriesVO {
	private String countryId;
	private String countryName;
	private Long regionId;
}
