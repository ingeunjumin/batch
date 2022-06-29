package com.data.batch;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.batch.mapper.BatchMapper;
import com.data.batch.vo.ApartmentsVO;
import com.data.batch.vo.ContractVO;
import com.data.batch.vo.OpenDataVO;

@SpringBootTest
public class HistoryTest {
	
	@Autowired
	BatchMapper batchMapper;
	
	@Test
	void contextLoads() throws Exception{
		
		List<ApartmentsVO> apartmentsList = batchMapper.selectAllApartments();
		for(ApartmentsVO apartmentsVO : apartmentsList) {
			int apartmentsNo = apartmentsVO.getApartmentsNo();
			String apartmentName = apartmentsVO.getApartmentsName();
			String gu = apartmentsVO.getGu();
			String dong = apartmentsVO.getDong();
			List<OpenDataVO> list = batchMapper.selectOpenData(apartmentName);
			ContractVO vo = null;
			
			if(list.size() > 0) {
				for(OpenDataVO data : list) {
					vo = new ContractVO();
					String createAt = data.getDealYear()+"-"+data.getDealMonth()+"-"+data.getDealDay();
					int dealAmount = Integer.parseInt(data.getDealAmount());
					vo.setApartmentsNo(apartmentsNo);
					vo.setGu(gu);
					vo.setDong(dong);
					vo.setSalePrice(dealAmount);
					vo.setCreateAt(createAt);
					int row = batchMapper.insertContract(vo);
					if(row > 0) System.out.println("데이터 INSERT !!");
				}
			}
		}
		System.out.println("완료 :)");
		
	}
}