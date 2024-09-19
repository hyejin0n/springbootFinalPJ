package com.springboot.webapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webapp.model.*;
//import com.mavenproj.diapp.model.BoardDo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao bdao;

	@Override
	public void insertBoard(BoardDo bdo) {
		bdao.insertBoard(bdo);
	}

	@Override
	public ArrayList<BoardDo> getBoardList() {
		// TODO Auto-generated method stub
		return bdao.getBoardList();
	}

	@Override
	public BoardDo getOBoardDo(BoardDo bdo) {
		// TODO Auto-generated method stub
		return bdao.getOneBoard(bdo);
	}

	@Override
	public void updateBoard(BoardDo bdo) {
		bdao.updateBoard(bdo);
		
	}

	@Override
	public void deleteBoard(BoardDo bdo) {
		// TODO Auto-generated method stub
		bdao.deleteBoard(bdo);
		
	}

}
