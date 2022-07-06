package com.data.batch.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.data.batch.vo.CrawlingDataVO;

@Mapper
public interface CrawlingDataMapper {
	
	public int insertApartmentsSubscription(CrawlingDataVO vo);
	
	public List<Map<String,Object>> selectInfoList();
}
