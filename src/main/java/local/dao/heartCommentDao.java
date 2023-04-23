package local.dao;

import java.sql.SQLException;

import com.ssafy.travel.domain.hotplace.heartCommentDTO;

public interface heartCommentDao {

	//좋아요 누르기
	void registHeart(heartCommentDTO heartcommentDto)throws SQLException;
	//좋아요 취소
	void deleteHeart(heartCommentDTO heartcommentDto) throws SQLException;
}
