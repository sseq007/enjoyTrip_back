package com.ssafy.tripApp.area.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tripApp.area.sido.dto.SidoDto;
import com.ssafy.tripApp.area.sido.service.SidoService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sido")
@CrossOrigin("*")
public class SidoApiController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private SidoService sidoService;
	
	@ApiOperation(value = "리스트 보기", notes = "시도 정보를 불러온다", response = Map.class)
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			List<SidoDto> list = sidoService.sidoList();
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<SidoDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
