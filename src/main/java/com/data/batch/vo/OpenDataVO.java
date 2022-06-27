package com.data.batch.vo;

import lombok.Data;

@Data
public class OpenDataVO {
	private int apt_no;//openData번호
	private String deal_amount;//거래유형
	private String build_year;//건축년도
	private String deal_year;//년
	private String road_name;//도로명
	private String road_name_bonbun;//도로명건물본번호코드
	private String road_name_bunbun;//도로명건물부번호코드
	private String road_name_sigungu_code;//도로면시군구코드
	private String road_name_seq;//도로면일련번호코드
	private String road_name_basement_code;//도로명지상지하코드
	private String road_name_code;//도로명코드
	private String dong;//법정동
	private String bonbun;//법정동본번코드
	private String bunbun;//법정동부번코드
	private String sigungu_code;//법정동읍면동코드
	private String eubmyundong_code;//법정동지번코드
	private String land_code;//법정동지번코드
	private String apartment_name;//아파트
	private String deal_month;//월
	private String deal_day;//일
	private String serial_number;//일련번호
	private String area_for_exclusive_use;//전용면적
	private String Jibun;//지번
	private String regional_code;
	private String floor;//층
	private String cancel_deal_day;//헤체사유발생일
	private boolean cancel_deal_type;//해체여부
	
	
}
