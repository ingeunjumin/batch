package com.data.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.batch.service.BatchService;
import com.data.batch.vo.ApartmentsVO;

@RestController
public class ApartmentsRestController {
	@Autowired
	private BatchService batchservice;
	
//	@CrossOrigin
//	@PostMapping("/apt")
//	public int callSaveApartments(@RequestBody ApartmentsVO vo) {
//		return batchservice.getInsertApartments(vo);
//	}
}
