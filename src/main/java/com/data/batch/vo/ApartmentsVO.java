package com.data.batch.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentsVO {
	
	private int apartmentsNo;
	private String apartmentsName;
	private String addr;
	private int dongCount;
	private int sedaeCount;
	private String latitude;
	private String longitude;
	private boolean isSold; //분양예정 여부
	private String createAt; //아파트 건립날짜
	private String gu;
}
