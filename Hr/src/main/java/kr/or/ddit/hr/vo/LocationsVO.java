package kr.or.ddit.hr.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "locationId")
public class LocationsVO {
	private Long locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
}
