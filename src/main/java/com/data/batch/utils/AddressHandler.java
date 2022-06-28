package com.data.batch.utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressHandler {
	
	private String API_KEY = "e5887425ac5d41ac739e8c881ec13f71";
	private String ROOT_URL = "https://dapi.kakao.com/v2/local";
	
	/**
	 * @param addr
	 * @return
	 * @throws Exception
	 * @author : Sangwon Hyun
	 * @date : 2022. 6. 24.
	 * comment : 주소 -> GPS 변환
	 */
	public String convertAddrToGPS(String addr) throws Exception{
		
		final String API_URL = ROOT_URL + "/search/address.json?query=" + addr;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + API_KEY);

		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> result = rest.exchange(API_URL, HttpMethod.GET,
				new HttpEntity<Object>(headers), String.class);
			
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(result.getBody());
		JSONObject jsonObjectMeta =  (JSONObject) jsonObject.get("meta");
		
		int totalCount = Integer.parseInt(jsonObjectMeta.get("total_count").toString());
		
		if(totalCount > 0) {
			JSONArray jsonArray = (JSONArray) jsonObject.get("documents");
			JSONObject local = (JSONObject) jsonArray.get(0);
			JSONObject jsonArrayAddr = (JSONObject) local.get("address");

			String longitude = jsonArrayAddr.get("x").toString();// 경도 127
			String latitude = jsonArrayAddr.get("y").toString();// 위도 36
			return longitude + "/" + latitude;
		}else {
			return null;
		}
				
		
	}
	
	/**
	 * @param longitude 경도
	 * @param latitude 위도
	 * @return
	 * @throws Exception
	 * @author : Sangwon Hyun
	 * @date : 2022. 6. 24.
	 * comment : GPS -> 주소 변환
	 */
	public String convertGPSToAddr(String longitude,String latitude) throws Exception{
		final String API_URL = ROOT_URL + "/geo/coord2address.json?x=" + longitude + "&y=" + latitude
				+ "&input_coord=WGS84";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + API_KEY);

		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> result = rest.exchange(API_URL, HttpMethod.GET,
				new HttpEntity<Object>(headers), String.class);

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(result.getBody());
		JSONArray jsonArray = (JSONArray) jsonObject.get("documents");

		JSONObject local = (JSONObject) jsonArray.get(0);
		JSONObject jsonArray1 = (JSONObject) local.get("address");
		String localAddress = jsonArray1.get("address_name").toString();
		return localAddress;
	}
	
}
