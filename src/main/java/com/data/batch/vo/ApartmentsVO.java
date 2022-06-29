package com.data.batch.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentsVO {
	
	private int apartmentsNo;
	private String apartmentsName;
	private String price;
	private String addr;
	private String gu;
	private String dong;// 지역 ex) 관저동, 원내동
	private String latitude;
	private String longitude;
	private Date createAt; //아파트 건립날짜
}
