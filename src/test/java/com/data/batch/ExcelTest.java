package com.data.batch;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.batch.mapper.BatchMapper;
import com.data.batch.utils.AddressHandler;
import com.data.batch.utils.XlsxUtils;
import com.data.batch.vo.ApartmentsVO;

@SpringBootTest
class ExcelTest {
	
	@Autowired
	private AddressHandler addressHandler;
	@Autowired
	private BatchMapper batchMapper;
	
	@Test
	void contextLoads() throws Exception{
		ApartmentsVO vo = null;
		String filePath = "C:/test/List.xlsx";
		List<List<String>> readList = XlsxUtils.readToList(filePath);
		
		//0.아파트 이름 1.주소 2.층수 3.동수 4.세대수 5.건립날짜 6.아파트여부
		for(int i=0; i<readList.size(); i++) {
			String type = readList.get(i).get(6);
			if("아파트".equals(type)) {
				String address = readList.get(i).get(1); //주소
				String[] gps = addressHandler.convertAddrToGPS(address).split("/");
				if(!"null".equals(gps)) {
					String latitude = gps[1]; //위도
					String longitude = gps[0]; //경도
					String apartmentsName = readList.get(i).get(0);//아파트 이름
					String dongCount = readList.get(i).get(3); //동수
					String sedaeCount = readList.get(i).get(4); //세대수 
				}
			}
		}
	}
}