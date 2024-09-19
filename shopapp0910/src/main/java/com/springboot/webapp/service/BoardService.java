package com.springboot.webapp.service;

import java.util.ArrayList;

import com.springboot.webapp.model.*;

public interface BoardService {
	//디비에 데이터 저장하는 메소드
	public void insertBoard(BoardDo bdo);
	
	//디비로부터 전체 데이터를 가져오는 메소드
	public ArrayList<BoardDo> getBoardList();
	
	//디비로부터 하나의 데이터를 가져오는 메소드
	public BoardDo getOBoardDo(BoardDo bdo);
	
	//디비에 하나의 데이터를 수정하는 메소드
	public void updateBoard(BoardDo bdo);
	
	//디비에서 하나의 데이터를 삭제하는 메소드
	public void deleteBoard(BoardDo bdo);
}
