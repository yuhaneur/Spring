package kr.or.ddit.alba.service;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.alba.ServiceResult;
import kr.or.ddit.alba.dao.AlbaDAO;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.vo.AlbaModel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbaServiceImpl implements AlbaService {
	private final AlbaDAO dao;
	
	
	@Value("/resources/profiles/")
	private Resource alImages;
	
	@PostConstruct
	public void init() throws IOException {
		if(!alImages.exists()) {
			alImages.getFile().mkdirs();
		}
	}
	private void uploadImage(AlbaModel alba){
		MultipartFile uploadFile = alba.getAlImage();
		String saveName = alba.getAlImg();
		if(uploadFile==null) return;
		try {
			File saveFile = new File(alImages.getFile(),saveName);
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), saveFile);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	@Override
	public List<AlbaModel> retrieveAlbaList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectAlbaList(paging);
	}
	
	@Override
	public AlbaModel retrieveAlba(String alId) {
		AlbaModel alba = dao.selectAlba(alId);
		if(alba==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"그런 알바생은 없음");
		}
		return alba;
	}

	@Override
	public ServiceResult createtAlba(AlbaModel alba) {
		AlbaModel who =  dao.selectAlba(alba.getAlId());
		if(who == null) {
			int cnt = dao.insertAlba(alba);
			if( cnt>0) {
				uploadImage(alba);
				return ServiceResult.OK; 
			}else {
				return ServiceResult.FAIL;
			}
		}else {
			return ServiceResult.PKDUPLICATED;			
		}
		
	}

	@Override
	public ServiceResult modifyAlba(AlbaModel alba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeAlba(String alId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
