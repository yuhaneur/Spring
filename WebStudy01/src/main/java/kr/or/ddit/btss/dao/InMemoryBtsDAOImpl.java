package kr.or.ddit.btss.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import kr.or.ddit.hr.vo.BtsVO;

public class InMemoryBtsDAOImpl implements BtsDAO {
	Map<String, Object[]> btsMap = new LinkedHashMap();
	{
		btsMap.put("B001", new Object[] {"뷔","bts/bui",100});
		btsMap.put("B002", new Object[] {"제이홉","bts/jhop",200});
		btsMap.put("B003", new Object[] {"지민","bts/jimin",300});
		btsMap.put("B004", new Object[] {"진","bts/jin",0});
		btsMap.put("B005", new Object[] {"정국","bts/jungkuk",120});
		btsMap.put("B006", new Object[] {"RM","bts/rm",30});
		btsMap.put("B007", new Object[] {"슈가","bts/suga",40});
		
	}
	
	@Override
	public BtsVO selectBts(String code) {
		BtsVO vo = new BtsVO();
		vo.setCode(code);
		vo.setName((String)btsMap.get(code)[0]);
		vo.setPath((String)btsMap.get(code)[1]);
		vo.setCount((Integer) btsMap.get(code)[2]);
		return vo;
	}

	@Override
	public List<BtsVO> selectBtsList() {
		List<BtsVO> list = new ArrayList<BtsVO>();
		for(Entry<String, Object[]> entry : btsMap.entrySet()) {
			BtsVO vo = new BtsVO();
			vo.setCode(entry.getKey());
			vo.setName((String)entry.getValue()[0]);
			vo.setPath((String)entry.getValue()[1]);
			vo.setCount((Integer) entry.getValue()[2]);
			list.add(vo);
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public void incrementHit(String code) {
		BtsVO bts = selectBts(code);
		if(bts!=null) {
			int count = bts.getCount() + 1;
			btsMap.get(bts)[2] = count;
		}
		
//		if(btsMap.containsKey(code)) {
//			Object[] oj = btsMap.get(code);
//			int hit = (int) oj[2];
//			oj[2] = ++hit;
//		}
	}

}
