package com.data.batch;

import java.nio.charset.StandardCharsets;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.batch.mapper.BatchMapper;
import com.data.batch.utils.AddressHandler;

@SpringBootTest
class CrawlingTest {
	
	@Autowired
	private AddressHandler addressHandler;
	@Autowired
	private BatchMapper batchMapper;
	
	@Test
	void contextLoads() throws Exception{
		
		String apartmentsName = "";
		String apartmentsAddress = "";
		
		String url = "https://www.housing.or.kr/mbshome/mbs/home/jsp/saleinfo/bcal.jsp?id=home_020100000000";
		String html = "#m_cont > div.sub_tit.mt0.table_scroll > div > div > table > tbody > tr > td > ul > li:nth-child(1) > .txt > a";
		String splitWord = "/";
		Connection conn = Jsoup.connect(url);
		Document document = conn.get();
	    Elements selects = document.select(html);
	    String result = selects.text();
	    String[] apartments = result.replace("[아파트]","/").split(splitWord);
	    for(String a : apartments) {
	    	if(!"".equals(a)) {
	    		String temp[] = a.split(",");
	    		String name = temp[0];
	    		String address = temp[1];
	    		String metropolitan[] = address.split(" ");
	    		if("대전광역시".equals(metropolitan[1])) {
	    			String addrArray[] = address.split("-");
	    			if(addrArray.length > 1) {
	    			    System.out.println("================================");
	    				System.out.println("name : "+name+" addr : "+address);
	    				String[] discrimination = addrArray[1].split(" ");
	    			 	String detailAddrBefore = discrimination[0];
	    			 	String detailAddrAfter = "";
	    			 	byte[] bytes = detailAddrBefore.getBytes(StandardCharsets.US_ASCII);
	    			 	for(int i=0; i< bytes.length; i++) {
	    			 		if(bytes[i] >= 48 && bytes[i] <= 57) {
	    			 			detailAddrAfter += detailAddrBefore.charAt(i);
	    			 		}
	    			 	}
	    			 	String aptAdress = addrArray[0].trim()+"-"+detailAddrAfter.trim();
	    			 	System.out.println(aptAdress);
	    			 	apartmentsName = name.trim();
	    			 	apartmentsAddress = aptAdress;
	    			 	System.out.println("================================");
	    			}
	    		}
 	    	}
	    }//end
	    String[] gps = addressHandler.convertAddrToGPS(apartmentsAddress).split("/");
	    String longitude = gps[0];
	    String latitude = gps[1];
	    // 테이블 컬럼 => 청약 번호, 아파트 이름, 아파트 지번주소, 위도, 경도, 청약 날짜 
	    System.out.println("[크롤링 결과] 아파트 이름 : "+apartmentsName);
	    System.out.println("[크롤링 결과] 아파트 주소 : "+apartmentsAddress);
	    System.out.println("[크롤링 결과] 위도 : "+latitude);
	    System.out.println("[크롤링 결과] 경도 : "+longitude);
	}
		
		
}
