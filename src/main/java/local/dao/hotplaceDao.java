package local.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.travel.domain.hotplace.hotplaceDTO;



public interface hotplaceDao {
	//핫플 등록
	void registHotplace(hotplaceDTO hotplaceDto)throws SQLException;
	//핫플 수정
	void modifyHotplace(hotplaceDTO hotplaceDto)throws SQLException;
	//핫플 삭제
	void deleteHotplace(hotplaceDTO hotplaceDto)throws SQLException;
	//핫플 목록
	List<hotplaceDTO> listhotplace() throws SQLException;
	//핫플 목록 가져오기
	hotplaceDTO getHotplace(int articleNo) throws SQLException;
	//지역 정보 가져오기
	public List<hotplaceDTO> areaList(String area) throws Exception;
}
