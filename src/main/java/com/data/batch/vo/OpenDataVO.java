package com.data.batch.vo;

import lombok.Data;

@Data
public class OpenDataVO {
	private int aptNo;//openData번호
	private String dealAmount;//거래유형
	private String buildYear;//건축년도
	private String dealYear;//년
	private String roadName;//도로명
	private String roadNameBonbun;//도로명건물본번호코드
	private String roadNameBunbun;//도로명건물부번호코드
	private String roadNameSigunguCode;//도로면시군구코드
	private String roadNameSeq;//도로면일련번호코드
	private String roadNameBasementCode;//도로명지상지하코드
	private String roadNameCode;//도로명코드
	private String dong;//법정동
	private String bonbun;//법정동본번코드
	private String bunbun;//법정동부번코드
	private String sigunguCode;//법정동읍면동코드
	private String eubmyundongCode;//법정동지번코드
	private String landCode;//법정동지번코드
	private String apartmentName;//아파트
	private String dealMonth;//월
	private String dealDay;//일
	private String serialNumber;//일련번호
	private String areaForExclusiveUse;//전용면적
	private String jibun;//지번
	private String regionalCode;
	private String floor;//층
	private String cancelDealDay;//헤체사유발생일
	private boolean cancelDealType;//해체여부
	
	
}
