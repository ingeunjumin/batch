package com.data.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.data.batch.mapper.OpenDataMapper;
import com.data.batch.utils.AddressHandler;
import com.data.batch.vo.OpenDataVO;

@Service
public class OpenDataService {
	@Autowired
	private OpenDataMapper opendatamapper;
	@Autowired
	private AddressHandler addressHandler;
	
	/**
	 * @param vo
	 * @return
	 * @author : In Seok
	 * @Date : 2022. 6. 27.
	 * comment : OpenData insert
	 */
	@Transactional(rollbackFor = Exception.class)
	public int getInsertOpenData(OpenDataVO vo) {
		String roadCode = vo.getRoadNameSigunguCode();
		//30110 : 동구 , 30140 : 중구, 30170 : 서구, 30200 : 유성구, 30230 : 대덕구
		if(roadCode.equals("30110")) {
			vo.setGu("동구");
		}
		if(roadCode.equals("30140")) {
			vo.setGu("중구");
		}
		if(roadCode.equals("30170")) {
			vo.setGu("서구");
		}
		if(roadCode.equals("30200")) {
			vo.setGu("유성구");
		}
		if(roadCode.equals("30230")) {
			vo.setGu("대덕구");
		}
		return opendatamapper.insertOpenData(vo);
	}

}
