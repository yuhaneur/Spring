package kr.or.ddit.hr.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "employeeId")
public class EmployeesVO {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private Long salary;
	private Long commissionPct;
	private Long managerId;
	private Long departmentId;
	private String empName;
	
	private DepartmentsVO departments;
	private JobsVO jobs;
	private JobHistoryVO jobHistory;
	
}
