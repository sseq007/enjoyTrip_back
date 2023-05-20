package com.ssafy.tripApp.board.controller.api;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.tripApp.board.ResponseDto;
import com.ssafy.tripApp.board.trippartner.dto.NoteDto;
import com.ssafy.tripApp.board.trippartner.service.NoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/note")
@CrossOrigin("*")
public class NoteApiController {

	@Autowired
	private NoteService noteService;
	
	@GetMapping("/list/{userid}")
	public ResponseEntity<?> listNotes(@RequestParam Map<String, String> map,@PathVariable String userid) throws Exception {
		List<NoteDto> listNote = noteService.listNote(userid);
		return new ResponseEntity<List<NoteDto>>(listNote, HttpStatus.OK);
	}
	
	@PostMapping("/write")
	public ResponseEntity<?>write(@RequestBody NoteDto noteDto,HttpSession session){
		
		try {
//			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//			sharetravelDto.setUserId(memberDto.getUserId());
			noteService.writeNote(noteDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<NoteDto>(noteDto, HttpStatus.OK);
	}
	@GetMapping("/view/{noteNo}")
	public ResponseEntity<?> view(@PathVariable int noteNo,Model model) {
		try {
			
			NoteDto viewNote = noteService.viewNote(noteNo);
		
			return new ResponseEntity<NoteDto>(viewNote, HttpStatus.OK);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> deleteById(@PathVariable int id){
		
		try {
			noteService.deletePartner(id);
			return  new ResponseEntity<String>("쪽지삭제완료", HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
