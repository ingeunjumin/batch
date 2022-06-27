package com.data.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.data.batch.mapper.OpenDataMapper;
import com.data.batch.vo.OpenDataVO;

@Service
public class OpenDataService {
	@Autowired
	private OpenDataMapper opendatamapper;
	
	
	/**
	 * @param vo
	 * @return
	 * @author : In Seok
	 * @Date : 2022. 6. 27.
	 * comment : OpenData insert
	 */
	@Transactional(rollbackFor = Exception.class)
	public int getInsertOpenData(OpenDataVO vo) {
		return opendatamapper.insertOpenData(vo);
	}
}
