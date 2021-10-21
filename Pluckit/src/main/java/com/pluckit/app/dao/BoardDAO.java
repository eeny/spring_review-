package com.pluckit.app.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pluckit.app.dto.BoardDTO;
import com.pluckit.app.dto.BoardMainDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> getAllBaordTitle(String deptName) {
		return sqlSession.selectList("board.getAllBoardTitleUser", deptName);
	}

	public List<BoardDTO> getAllBoardTitle() {
		return sqlSession.selectList("board.getAllBoardTitleAdmin");
	}

	public String getBoardTitle(String pageName) {
		return sqlSession.selectOne("board.getBoardTitle", pageName);
	}

	public int writePostProc(HashMap<String, String> map) {
		return sqlSession.insert("board.writePostProc", map);
	}

	public List<BoardMainDTO> getAllBoardList(HashMap<String, String> map) {
		return sqlSession.selectList("board.getAllBoardList", map);
	}

	public int getAllBoardCount(String pageName) {
		return sqlSession.selectOne("board.getAllBoardCount", pageName);
	}
	
	public int updateHitCount(HashMap<String, String> map) {
		return sqlSession.update("board.updateHitCount", map);
	}

	public BoardMainDTO getPost(HashMap<String, String> map) {
		return sqlSession.selectOne("board.getPost", map);
	}

	public String getFileName(HashMap<String, String> map) {
		return sqlSession.selectOne("board.getFileName", map);
	}

	public int modifyPost(HashMap<String, String> map) {
		return sqlSession.update("board.modifyPost", map);
	}

	public int deletePost(HashMap<String, String> map) {
		return sqlSession.delete("board.deletePost", map);
	}

	
	
}
