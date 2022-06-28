package com.data.batch;

import java.text.SimpleDateFormat;
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
		for(int i=0; i< readList.size(); i++) {
			String type = readList.get(i).get(6);
			if("아파트".equals(type)) {
				String address = readList.get(i).get(1); //주소
				String gps = addressHandler.convertAddrToGPS(address);
				if(gps != null) {
					String[] arrayGps = gps.split("/");
					vo = new ApartmentsVO();
					String latitude = arrayGps[1]; //위도
					String longitude = arrayGps[0]; //경도
					String apartmentsName = readList.get(i).get(0);//아파트 이름
					double dongCount = Double.parseDouble(readList.get(i).get(3)); //동수
					double sedaeCount = Double.parseDouble(readList.get(i).get(4)); //세대수 
					String createAt =  readList.get(i).get(5);
					
					vo.setAddr(address);
					vo.setLatitude(latitude);
					vo.setLongitude(longitude);
//					vo.setDongCount((int) dongCount);
//					vo.setSedaeCount((int) sedaeCount);
					vo.setApartmentsName(apartmentsName);
//					vo.setCreateAt(createAt);
					vo.setGu("대덕구");
					
					batchMapper.insertApartments(vo);
				
				}
			}
		}
		
		
	}
}