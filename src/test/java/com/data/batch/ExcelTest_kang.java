package com.data.batch;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.batch.utils.XlsxUtils;

@SpringBootTest
class ExcelTest_kang {

	@Test
	void contextLoads() {
		String filePath = "C:/test/List.xlsx";
		List<List<String>> readList = XlsxUtils.readToList(filePath);
		
		for(int i=0; i<readList.size(); i++) {
			for(int j=0; j<readList.get(i).size(); j++) {
				System.out.print(readList.get(i).get(j)+", ");
			}
			System.out.println();
		}
		
	}

}
