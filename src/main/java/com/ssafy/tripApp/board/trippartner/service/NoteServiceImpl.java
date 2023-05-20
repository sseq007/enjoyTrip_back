package com.ssafy.tripApp.board.trippartner.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.Sharetravel.mapper.ShareTravelMapper;
import com.ssafy.tripApp.board.trippartner.dto.KeywordOneDto;
import com.ssafy.tripApp.board.trippartner.dto.KeywordTwoDto;
import com.ssafy.tripApp.board.trippartner.dto.NoteDto;
import com.ssafy.tripApp.board.trippartner.dto.TripPartnerDto;
import com.ssafy.tripApp.board.trippartner.mapper.NoteMapper;
import com.ssafy.tripApp.board.trippartner.mapper.TripPartnerMapper;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteMapper noteMapper;

	@Override
	public void writeNote(NoteDto noteDto) throws SQLException {

		noteMapper.writeNote(noteDto);
	}

	@Override
	public void deletePartner(int noteNo) throws SQLException {
		noteMapper.deletePartner(noteNo);
		
	}

	@Override
	public List<NoteDto> listNote(String userid) throws SQLException {
		// TODO Auto-generated method stub
		return noteMapper.listNote(userid);
	}

	@Override
	public NoteDto viewNote(int noteNo) throws SQLException {
		// TODO Auto-generated method stub
		return noteMapper.viewNote(noteNo);
	}


	

}
