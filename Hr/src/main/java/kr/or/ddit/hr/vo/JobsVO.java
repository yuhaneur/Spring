package kr.or.ddit.hr.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "jobId")
public class JobsVO {
	private String jobId;
	private String jobTitle;
	private Long minSalary;
	private Long maxSalary;
}
