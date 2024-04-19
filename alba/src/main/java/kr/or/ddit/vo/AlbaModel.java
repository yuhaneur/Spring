package kr.or.ddit.vo;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "alId")
@ToString
public class AlbaModel implements Serializable{
	@NotBlank
	private String alId;
	@NotBlank
	private String alName;
	@NotNull
	private Long alAge;
	@NotBlank
	private String alZip;
	@NotBlank
	private String alAddr1;
	@NotBlank
	private String alAddr2;
	@NotBlank
	@Pattern(regexp = "\\d{3}-\\d{3,4}-\\d{4}")
	private String alHp;
	@NotBlank
	private String grCode;
	@NotBlank
	private String alGen;
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
	private String alMail;
	private String alCareer;
	private String alSpec;
	private String alDesc;
	private String alImg;
	
	private GradeModel grade;
	private List<MyLicModel> mylic;
	
	
}
