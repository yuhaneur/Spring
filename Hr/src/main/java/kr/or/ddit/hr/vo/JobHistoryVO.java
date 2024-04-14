package kr.or.ddit.hr.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "employeeId")
public class JobHistoryVO {
	private Long employeeId;
	private String startDate;
	private String endDate;
	private String jobId;
	private Long departmentId;
}
