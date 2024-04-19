package kr.or.ddit.case07.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class BankInfoVO {
	@NotBlank
	private String bankNo;
	@NotBlank
	private String bankName;
	@NotBlank
	private String bankUserName;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate bankDate;
}
