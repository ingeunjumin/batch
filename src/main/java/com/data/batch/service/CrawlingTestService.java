package com.data.batch.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CrawlingTestService {
	
	@Scheduled(cron="0/3 * * * * *")
    public void test2() {
        System.out.println("@Scheduled annotation : 10초에 1번씩 console 찍기");
        System.out.println("현재시간 ==> "+ new Date());
	}
	

}
