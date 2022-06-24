package com.data.batch.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.data.batch.vo.ApartmentsVO;

@Mapper
public interface BatchMapper {
	/**
	 * @param vo
	 * @return
	 * @author : Sangwon Hyun
	 * @date : 2022. 6. 24.
	 * comment : 아파트 테이블 데이터 set
	 */
	public int insertApartments(ApartmentsVO vo);
}
