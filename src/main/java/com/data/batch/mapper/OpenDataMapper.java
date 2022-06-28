package com.data.batch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.data.batch.vo.OpenDataVO;

@Mapper
public interface OpenDataMapper {
	/**
	 * @param vo
	 * @return
	 * @author : inseok Kang
	 * @date : 2022. 6. 27.
	 * comment : OpenData insert
	 */
	public int insertOpenData(OpenDataVO vo);
	
	public List<OpenDataVO> getGroupApart();

}
