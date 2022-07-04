package com.data.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.batch.mapper.BatchMapper;
import com.data.batch.mapper.OpenDataMapper;
import com.data.batch.utils.AddressHandler;

@Service
public class BatchService {
	
	@Autowired
	private BatchMapper batchmapper;
	@Autowired
	private OpenDataMapper openDataMapper;
	@Autowired
	private AddressHandler addressHandler;
	
//	@Transactional(rollbackFor = Exception.class)
//	public int getInsertApartments(ApartmentsVO vo) {
//		List<OpenDataVO> list = openDataMapper.getGroupApart();
//		
//		for(OpenDataVO i: list) {
//			String ApartmentName = i.getApartmentName();
//			vo.setApartmentsName(ApartmentName);
//			String addr = i.getAddr();
//			vo.setAddr(addr);
//			try {
//				String result = addressHandler.convertAddrToGPS(addr);
//				String[] arr = result.split("/");
//				String Latitude =arr[0];
//				vo.setLatitude(Latitude);
//				String Longitude =arr[1]; //vo set을 해서 insert
//				vo.setLongitude(Longitude);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			String createAt = i.getBuildYear();
//			vo.setCreateAt(createAt);
//			String gu = i.getGu();
//			vo.setGu(gu);
//			String dong = i.getDong();
//			vo.setDong(dong);
//			int dongCount = 0;
//			vo.setDongCount(dongCount);
//			int sedaeCount = 0;
//			vo.setSedaeCount(sedaeCount);
//			boolean isSold = false;
//			vo.setSold(isSold);
//		}
//		return batchmapper.insertApartments(vo);
//	}

}
