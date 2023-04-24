package com.ssafy.tripApp.board.Sharetravel.dao;

import java.util.List;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;

public interface ShareTravelDao {
	public void writeTravel(ShareTravelDto shareTravelDto) throws Exception;
	public List<ShareTravelDto> list() throws Exception;
	public ShareTravelDto readTravel(int articleNo) throws Exception;
	public void updateTravel(ShareTravelDto shareTravelDto) throws Exception;
	public void deleteTravel(ShareTravelDto shareTravelDto) throws Exception;
}
