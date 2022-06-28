package com.data.batch.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentsVO {
	
	private int apartmentsNo;
	private String apartmentsName;
	private String addr;
	private int dongCount;// 아파트 동 개수
	private int sedaeCount;
	private String latitude;
	private String longitude;
	private boolean isSold; //분양예정 여부
	private String createAt; //아파트 건립날짜
	private String gu;
	private String dong;// 지역 ex) 관저동, 원내동
}
