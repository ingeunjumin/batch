package com.data.batch.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.data.batch.vo.CrawlingDataVO;

@Mapper
public interface CrawlingDataMapper {
	
	public int insertApartmentsSubscription(CrawlingDataVO vo);

}
