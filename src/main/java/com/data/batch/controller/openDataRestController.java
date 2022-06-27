package com.data.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.batch.service.OpenDataService;
import com.data.batch.vo.OpenDataVO;

@RestController
public class openDataRestController {
	@Autowired
	private OpenDataService opendataservice;
	
	/**
	 * @param vo
	 * @return
	 * @author : In Seok
	 * @Date : 2022. 6. 27.
	 * comment : OpenData insert
	 */
	@CrossOrigin
	@PostMapping("/open")
	public int callSaveOpenData(@RequestBody OpenDataVO vo) {
		return opendataservice.getInsertOpenData(vo);
	}
}
