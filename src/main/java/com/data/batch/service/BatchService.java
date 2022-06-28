package com.data.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.data.batch.mapper.BatchMapper;
import com.data.batch.vo.ApartmentsVO;

@Service
public class BatchService {
	
	@Autowired
	private BatchMapper batchmapper;
	
	@Transactional(rollbackFor = Exception.class)
	public int getInsertApartments(ApartmentsVO vo) {
		boolean isSold = false;
		vo.setSold(isSold);
		return batchmapper.insertApartments(vo);
	}

}
