package kr.or.ddit.case10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case10")
public class FileUploadController {
	@Value("file:D:/02.saveFolder/")
	private Resource saveFolder;
	
	@GetMapping("upload4")
	public String formHandler4() {
		
		return "case10/fileForm4";
	}
	@PostMapping("upload4")
	public String uploadProcess4(
			@Valid @ModelAttribute("co") Case10CommandObject co
			,BindingResult errors
			,RedirectAttributes redirectAttributes) throws IOException {
		log.info("uploader : {}",co.getUploader());
		log.info("count : {}",co.getCount());
		
		List<UploadFileVO> voList = co.getVoList();
		redirectAttributes.addFlashAttribute("co", co);
		for(UploadFileVO fileVO : voList) {
			// 폴더의 자식을 만들떄 크리에이트 릴래이티브씀
			Resource saveRes =  saveFolder.createRelative(fileVO.getSaveName());
			FileUtils.copyInputStreamToFile(fileVO.getFile().getInputStream(), saveRes.getFile());
			log.info("{} 업로드 완료, DB 에 저장할 메타데이터 : {}", fileVO.getFileName(),fileVO);
		}
		
		
		return "redirect:/case10/upload4";
	}
	@GetMapping("upload3")
	public String formHandler3() {
		
		return "case10/fileForm3";
	}
	@PostMapping("upload3")
	public String uploadProcess3(
			@RequestParam String[] uploader
			,@RequestParam int count
			,@RequestPart(required = false, name = "uploadFile") MultipartFile[] uploadFiles
			,RedirectAttributes redirectAttributes) throws IOException {
		log.info("uploader : {}",uploader);
		log.info("count : {}",count);
		List<UploadFileVO> voList = new ArrayList<>();
		redirectAttributes.addFlashAttribute("voList", voList);
		for(MultipartFile uploadFile : uploadFiles) {
			if(uploadFile==null || uploadFile.isEmpty()) continue;
			String mime = uploadFile.getContentType();
			if(!mime.startsWith("image/")) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			String fileName = uploadFile.getOriginalFilename();
			String saveName = UUID.randomUUID().toString();
			long fileSize = uploadFile.getSize();
			UploadFileVO fileVO = new UploadFileVO(fileName, saveName, fileSize);
			// 폴더의 자식을 만들떄 크리에이트 릴래이티브씀
			Resource saveRes =  saveFolder.createRelative(saveName);
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), saveRes.getFile());
			log.info("{} 업로드 완료, DB 에 저장할 메타데이터 : {}", fileName,fileVO);
			voList.add(fileVO);
		}
		
		
		return "redirect:/case10/upload3";
	}
	
	@GetMapping("upload2")
	public String formHandler2() {
		
		return "case10/fileForm1";
	}
	@PostMapping("upload2")
	public String uploadProcess2(
			@RequestParam String uploader
			,@RequestParam int count
			,@RequestPart MultipartFile uploadFile
			,RedirectAttributes redirectAttributes) throws IOException {
		log.info("uploader : {}",uploader);
		log.info("count : {}",count);
		if(uploadFile!=null && !uploadFile.isEmpty()) {
			String mime = uploadFile.getContentType();
			if(!mime.startsWith("image/")) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			String fileName = uploadFile.getOriginalFilename();
			String saveName = UUID.randomUUID().toString();
			long fileSize = uploadFile.getSize();
			UploadFileVO fileVO = new UploadFileVO(fileName, saveName, fileSize);
			// 폴더의 자식을 만들떄 크리에이트 릴래이티브씀
			Resource saveRes =  saveFolder.createRelative(saveName);
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), saveRes.getFile());
			redirectAttributes.addFlashAttribute("fileVO", fileVO);
			log.info("{} 업로드 완료, DB 에 저장할 메타데이터 : {}", fileName,fileVO);
		}
		return "redirect:/case10/upload2";
	}
	
	@GetMapping("upload1")
	public String formHandler1() {
		return "case10/fileForm1";
	}
	@PostMapping("upload1")
	public String uploadProcess1(
			@RequestParam String uploader
			,@RequestParam int count
			,MultipartHttpServletRequest req) throws IOException {
		log.info("uploader : {}",uploader);
		log.info("count : {}",count);
		
		MultipartFile uploaderFile = req.getFile("uploadFile");
		String fileName = uploaderFile.getOriginalFilename();
		String saveName = UUID.randomUUID().toString();
		long fileSize = uploaderFile.getSize();
		UploadFileVO fileVO = new UploadFileVO(fileName, saveName, fileSize);
		// 폴더의 자식을 만들떄 크리에이트 릴래이티브씀
		Resource saveRes =  saveFolder.createRelative(saveName);
		FileUtils.copyInputStreamToFile(uploaderFile.getInputStream(), saveRes.getFile());
		log.info("{} 업로드 완료, DB 에 저장할 메타데이터 : {}", fileName,fileVO);
		return "redirect:/case10/upload1";
	}
}
