package com.data.batch;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SangwonTest {
	
	@Test
	void contextLoads() throws Exception{
		String word = "1외";
		byte[] bytes = word.getBytes(StandardCharsets.US_ASCII);
	    System.out.println("ASCII Numeric Value of b: "+bytes[0]);
	}
		
		
}
