 package com.data.batch;

import java.nio.charset.StandardCharsets;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.data.batch.mapper.CrawlingDataMapper;
import com.data.batch.utils.AddressHandler;
import com.data.batch.vo.CrawlingDataVO;

@SpringBootTest
@Component
class CrawlingTest {
	
	@Autowired
	private AddressHandler addressHandler;
	@Autowired
	private CrawlingDataMapper crawlingDataMapper;
	
	@Test
	@Scheduled(cron="0 0 9 * * *")
	void contextLoads() throws Exception{
		
		String apartmentsName = "";
		String apartmentsAddress = "";
		String apartmentsSubscriptionDate = "";
		
		String url = "https://www.housing.or.kr/mbshome/mbs/home/jsp/saleinfo/bcal.jsp?id=home_020100000000";
		String aptInfoHtml = "#m_cont > div.sub_tit.mt0.table_scroll > div > div > table > tbody > tr > td > ul > li:nth-child(1) > .txt > a"; //청약접수 구간 아파트정보 HTML
		String creatAt = "#m_cont > div.sub_tit.mt0.table_scroll > div > div > table > tbody > tr > th > em"; // 청약날짜
		String splitWord = "/";
		Connection conn = Jsoup.connect(url);
		Document document = conn.get();
		
		// 청약 날짜 구하기
		Elements selectCreate = document.select(creatAt);
		String SubscriptionDate[] = selectCreate.text().split(" ");
		apartmentsSubscriptionDate = SubscriptionDate[0];
		
		
	    Elements selects = document.select(aptInfoHtml);
	    String result = selects.text(); // 청약접수 구간 a태그안에 있는 정보의 text만 다 가져옴.
	    String[] apartments = result.replace("[아파트]","/").split(splitWord); // [아파트] => / 변환 후 /를 기준으로 배열로 만듬.
	    for(String a : apartments) {
	    	// a 결과 =>  e편한세상 에코델타 센터포인트, 부산광역시 강서구 강동동 에코델타시티내 19BL [홈페이지] 
		    //			 범어자이, 대구광역시 수성구 범어동 48-26번지 일원 [홈페이지] 
		    //			 대전스카이자이르네, 대전광역시 동구 인동 72-1외 11필지 [홈페이지]
	    	if(!"".equals(a)) {
	    		String temp[] = a.split(","); // a의 결과에서 다시 ,를 기준으로 배열로 만듬.
	    		String aptName = temp[0];
	    		String address = temp[1];
	    		String metropolitan[] = address.split(" ");
	    		if("대전광역시".equals(metropolitan[1])) {
	    			String addrArray[] = address.split("-");
	    			if(addrArray.length > 1) {
	    			    System.out.println("================================");
	    				System.out.println("name : "+aptName+" addr : "+address);
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
	    			 	apartmentsName = aptName.trim();
	    			 	apartmentsAddress = aptAdress;
	    			 	
	    			}
	    		}
 	    	}
	    }//end
	    String[] gps = addressHandler.convertAddrToGPS(apartmentsAddress).split("/");
	    String longitude = gps[0];
	    String latitude = gps[1];
	    // 테이블 컬럼 => 청약 번호, 아파트 이름, 아파트 지번주소, 위도, 경도, 청약 날짜 
	    System.out.println("================================");
	    System.out.println("[크롤링 결과] 아파트 이름 : "+apartmentsName);
	    System.out.println("[크롤링 결과] 아파트 주소 : "+apartmentsAddress);
	    System.out.println("[크롤링 결과] 위도 : "+latitude);
	    System.out.println("[크롤링 결과] 경도 : "+longitude);
	    System.out.println("[크롤링 결과] 아파트 청약 날짜 : "+apartmentsSubscriptionDate);
	    System.out.println("================================");
	    
	    
	    CrawlingDataVO vo = new CrawlingDataVO();
	    vo.setApartmentsName(apartmentsName);
	    vo.setApartmentsAddress(apartmentsAddress);
	    vo.setLatitude(latitude);
	    vo.setLongitude(longitude);
	    vo.setApartmentsSubscriptionDate(apartmentsSubscriptionDate);
	    // 청약아파트의 주소의 지역이 대전광역시이었을 경우에만 insert
	    if(vo.getApartmentsAddress().contains("대전광역시")) {
	    	System.out.println("hello world!");
//	    crawlingDataMapper.insertApartmentsSubscription(vo);
	    }
	}
}
