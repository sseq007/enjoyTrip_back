package com.ssafy.tripApp.board.travelPlan.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.travelPlan.dto.LocalDto;
import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;
import com.ssafy.tripApp.board.travelPlan.mapper.TravelPlanMapper;

import lombok.RequiredArgsConstructor;

@Service
public class TravelplanServiceImpl implements TravelplanService {

	@Autowired
	private TravelPlanMapper travelplanMapper;
	
	public TravelplanServiceImpl(TravelPlanMapper travelplanMapper) {
		super();
		this.travelplanMapper = travelplanMapper;
	}

	@Override
	public void writePlan(TravelplanDto travelPlanDto) throws Exception {
		if(travelPlanDto.getLocation().equals("1")) {
			travelPlanDto.setLocation("서울");
		}else if(travelPlanDto.getLocation().equals("2")) {
			travelPlanDto.setLocation("인천");
		}else if(travelPlanDto.getLocation().equals("3")) {
			travelPlanDto.setLocation("대전");
		}else if(travelPlanDto.getLocation().equals("4")) {
			travelPlanDto.setLocation("대구");
		}else if(travelPlanDto.getLocation().equals("5")) {
			travelPlanDto.setLocation("광주");
		}else if(travelPlanDto.getLocation().equals("6")) {
			travelPlanDto.setLocation("부산");
		}else if(travelPlanDto.getLocation().equals("7")) {
			travelPlanDto.setLocation("울산");
		}else if(travelPlanDto.getLocation().equals("8")) {
			travelPlanDto.setLocation("세종특별자치시");
		}else if(travelPlanDto.getLocation().equals("31")) {
			travelPlanDto.setLocation("경기도");
		}else if(travelPlanDto.getLocation().equals("32")) {
			travelPlanDto.setLocation("강원도");
		}else if(travelPlanDto.getLocation().equals("33")) {
			travelPlanDto.setLocation("충청북도");
		}else if(travelPlanDto.getLocation().equals("34")) {
			travelPlanDto.setLocation("충청남도");
		}else if(travelPlanDto.getLocation().equals("35")) {
			travelPlanDto.setLocation("경상북도");
		}else if(travelPlanDto.getLocation().equals("36")) {
			travelPlanDto.setLocation("경상남도");
		}else if(travelPlanDto.getLocation().equals("37")) {
			travelPlanDto.setLocation("전라북도");
		}else if(travelPlanDto.getLocation().equals("38")) {
			travelPlanDto.setLocation("전라남도");
		}else if(travelPlanDto.getLocation().equals("39")) {
			travelPlanDto.setLocation("제주도");
		}
		
		travelplanMapper.writePlan(travelPlanDto);
	}

	@Override
	public List<TravelplanDto> listPlan() throws Exception {
		// TODO Auto-generated method stub
		return travelplanMapper.listPlan();
	}

	@Override
	public void updatePlan(TravelplanDto travelPlanDto) throws Exception {
		// TODO Auto-generated method stub
		travelplanMapper.updatePlan(travelPlanDto);
	}

	@Override
	public void deletePlan(int articleNo) throws Exception {
		travelplanMapper.deletePlan(articleNo);
		
	}
 
	@Override
	public TravelplanDto viewPlan(int articleNo) throws Exception {
		return travelplanMapper.viewPlan(articleNo);
	}


	@Override
	public List<LocalDto> localList(int articleNo) throws Exception {
		return travelplanMapper.localList(articleNo);
	}

	@Override
	public void writeLocal(List<LocalDto> localDto) throws Exception {
		
		
		
		for (int i = 0; i < localDto.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("articleNo", localDto.get(i).getArticleNo());
			map.put("title", localDto.get(i).getTitle());
			map.put("content", localDto.get(i).getTel());
			map.put("addr1", localDto.get(i).getAddr1());
			map.put("firstimage", localDto.get(i).getFirstimage());
			travelplanMapper.writeLocal(map);
		}
			
		
	}

	@Override
	public void updateLocal(List<LocalDto> localDto) throws Exception {
		
		for (int i = 0; i < localDto.size(); i++) {
			System.out.println(localDto.get(i).toString());
			travelplanMapper.updateLocal(localDto.get(i));
		}
	}

	@Override
	public void deleteLocal(List<LocalDto> localDto) throws Exception {
		for (int i = 0; i < localDto.size(); i++) {
			travelplanMapper.deleteLocal(localDto.get(i));
		}
		
	}

	@Override
	public int getarticleNo() throws SQLException {
		// TODO Auto-generated method stub
		return travelplanMapper.getarticleNo();
	}

}
