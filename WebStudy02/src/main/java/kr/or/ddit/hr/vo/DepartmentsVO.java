package kr.or.ddit.hr.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "departmentId")
public class DepartmentsVO {
	private Long departmentId;
	private String departmentName;
	private Long managerId;
	private Long locationId;
	
	private EmployeesVO employees;
	private JobHistoryVO jobHistory;
}
