package com.data.batch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.data.batch.vo.ApartmentsVO;
import com.data.batch.vo.ContractVO;
import com.data.batch.vo.OpenDataVO;

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
	
	public List<ApartmentsVO> selectAllApartments();
	
	public List<OpenDataVO> selectOpenData(String apartmentName);
	
	public int insertContract(ContractVO vo);
}
