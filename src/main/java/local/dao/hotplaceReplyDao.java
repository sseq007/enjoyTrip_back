package local.dao;

import java.sql.SQLException;

import com.ssafy.travel.domain.hotplace.hotplaceReplyDTO;

public interface hotplaceReplyDao {

	//답글 등록
	void writehotpleReply(hotplaceReplyDTO hotplaceReply)throws SQLException;
	//답글 삭제
	void deletehotpleReply(hotplaceReplyDTO hotplaceReply)throws SQLException;
}
