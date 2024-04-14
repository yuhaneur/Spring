package kr.or.ddit.hr.vo;

import lombok.EqualsAndHashCode;

import lombok.Data;

@Data
@EqualsAndHashCode(of = "regionId")
public class RegionsVO {
	private Long regionId;
	private String regionName;
	
	private CountriesVO countries;
	private LocationsVO locations;
	private EmployeesVO employees;
}
