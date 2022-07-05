package com.data.batch;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.batch.utils.AddressHandler;

@SpringBootTest
public class AddrTest {
	
	@Autowired
	private AddressHandler addressHandler;
	
	/**
	 * @throws Exception
	 * @author : Sangwon Hyun
	 * @date : 2022. 6. 28.
	 * comment : 주소 -> 위경도 변환 테스트 메소드
	 */
	@Test
	void contextLoads() throws Exception{
		String Jibun = " 72-1"; //지번 컬럼
		String dong = " 인동"; //동 컬럼
		String addr = "대전광역시 동구 인동 72-1";
		String result = addressHandler.convertAddrToGPS(addr);
		if(result != null) {
			String[] arr = result.split("/");
			System.out.println(arr[0]);
			System.out.println(arr[1]); //vo set을 해서 insert
		}else {
			System.out.println("위 경도 변환 실패");
		}
		
	}

}
