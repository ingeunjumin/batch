package com.data.batch.service;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CrawlingTestService {
	
	@Scheduled(cron="0/3 * * * * *")
    public void test2() {
        System.out.println("@Scheduled annotation : 3초에 1번씩 console 찍기");
        System.out.println("현재시간 ==> "+ new Date());
        
        
        final String inflearnUrl = "https://www.applyhome.co.kr/ai/aia/selectAPTLttotPblancListView.do";
        Connection conn = Jsoup.connect(inflearnUrl);

        try {
            Document document = conn.get();
            Elements titleElements = document.select("#subContent > div.mt_10 > table > tbody > tr");
            for (int i = 0; i < titleElements.size(); i++) {
                final String title = titleElements.get(i).text();
                System.out.println("청약 정보 : " + title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
}
