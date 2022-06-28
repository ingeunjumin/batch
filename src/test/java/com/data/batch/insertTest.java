package com.data.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.data.batch.mapper.BatchMapper;
import com.data.batch.mapper.OpenDataMapper;
import com.data.batch.utils.AddressHandler;
import com.data.batch.vo.ApartmentsVO;
import com.data.batch.vo.OpenDataVO;

@SpringBootTest
//@Transactional(rollbackFor = Exception.class)
public class insertTest {
	
	@Autowired
	private BatchMapper batchmapper;
	@Autowired
	private OpenDataMapper openDataMapper;
	@Autowired
	private AddressHandler addressHandler;
	

	@Test
	void contextLoads() throws Exception{
		List<OpenDataVO> list = openDataMapper.getGroupApart();
		ApartmentsVO vo = new ApartmentsVO();
		
		for(OpenDataVO i: list) {
			String ApartmentName = i.getApartmentName();
			vo.setApartmentsName(ApartmentName);//아파트이름
			String price = i.getDealAmountAge();
			vo.setPrice(price);
			String addr = i.getAddr();
			vo.setAddr(addr);
			String gu = i.getGu();
			vo.setGu(gu);
			String dong = i.getDong();
			vo.setDong(dong);
			try {
				String result = addressHandler.convertAddrToGPS(addr);
				String[] arr = result.split("/");
				String Latitude =arr[0];
				vo.setLatitude(Latitude);
				String Longitude =arr[1]; //vo set을 해서 insert
				vo.setLongitude(Longitude);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			String BuildYear = i.getBuildYear();
			SimpleDateFormat Format = new SimpleDateFormat("yyyy"); 
			Date date = Format.parse(BuildYear);
			String createAt = Format.format(date);
//			System.out.println(createAt);
			vo.setCreateAt(date);
//			System.out.println(vo.getCreateAt());
			batchmapper.insertApartments(vo);
		}
		
	}
	

}
