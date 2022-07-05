package com.data.batch.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CrawlingDataVO {
	
	private String apartmentsName; //아파트 이름
	private String apartmentsAddress; //아파트 주소
	private String latitude; //위도
	private String longitude; // 경도
	private String apartmentsSubscriptionDate; //아파트 청약 날짜


}
