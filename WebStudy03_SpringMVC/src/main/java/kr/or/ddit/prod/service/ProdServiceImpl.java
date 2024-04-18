package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdServiceImpl implements ProdService {
	private final ProdDAO dao;
	@Value("/resources/prodImages/")
	private Resource prodImages;
	
	@PostConstruct
	public void init() throws IOException {
		if(!prodImages.exists()) {
			prodImages.getFile().mkdirs();
		}
	}
	
	private void processImage(ProdVO prod) {
		MultipartFile uploadFile = prod.getProdImage();
		String saveName = prod.getProdImg();
		if(uploadFile==null) return;
		try {
//			Resource saveRes = prodImages.createRelative(saveName);
			File saveFile = new File(prodImages.getFile(),saveName);
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), saveFile);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	@Override
	public List<ProdVO> retrieveProdList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectProdList(paging);
	}

	@Override
	public ProdVO retrieveProd(String prodId) {
		ProdVO prod = dao.selectProd(prodId);
		return prod;
	}

	@Override
	public ServiceResult createProd(ProdVO prod) {
		if(dao.insertProd(prod) > 0) {
			processImage(prod);
			return ServiceResult.OK;
		}else {
			return ServiceResult.FAIL;
		}
	}


	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		if(dao.updateProd(prod) > 0) {
			processImage(prod);
			return ServiceResult.OK;
		}else {
			return ServiceResult.FAIL;
		}
	}
}
