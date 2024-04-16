package kr.or.ddit.hr.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "employeeId")
public class RetrieVO {
	private Long employeeId;
	private Long departmentId;
	private String hireDate;
	private String retireDate;
	
	private EmployeesVO employee;
}

