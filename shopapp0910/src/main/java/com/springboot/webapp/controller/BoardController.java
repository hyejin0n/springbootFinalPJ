package com.springboot.webapp.controller;

import java.util.ArrayList;

import com.springboot.webapp.model.SignupDo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.webapp.model.BoardDao;
import com.springboot.webapp.model.BoardDo;

//@Controller : 사용자의 요청을 처리하기 위한 클래스를 만드는 @
@Controller
public class BoardController {

	// 로그인 페이지 이동
	//1. login 요청이 오면 login.jsp 호출하는 메소드
	@RequestMapping(value = "/login")
	public String loginBoard(){
		System.out.println("loginBoard()처리");
		return "login";
	}

	//회원가입 페이지 이동
	//2. signup 페이지 이동
	@RequestMapping("/signup")
	public String showSignupForm() {
		return "signup";
	}

	//회원가입 처리
	//3. signupProc.do 요청이 오면 signBoardDo 에 저장하고 해당 데이터를 DB에 저장
	// DB table = smember
	@RequestMapping(value = "/signupProc.do", method = RequestMethod.POST)
	public String signupProc(SignupDo sbdo){
		System.out.println("signupProc()처리");

		//Singup 객체에 저장되어 있는지 확인하는 출력문
		System.out.println("email: " + sbdo.getEmail());
		System.out.println("userName: " + sbdo.getUserName());
		System.out.println("password: " + sbdo.getPassWord());

		return "redirect:login";
	}
	
	//1. insertBoard.do 요청이 오면, insertBoard.jsp 호출하는 메소드
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		// 사용자 필요한 처리..
		System.out.println("insertBoard() 처리 ");
		// return "뷰어명"
		// 뷰 리졸버의 의해서, 뷰어 폴더 내의 .jsp에 연결됨
		return "insertBoard";
	}
	
	//2. insertProcBoard() : insertProcBoard.do 요청이 오면, BoardDo에 저장하고,
	//   해당 데이터를 디비에 저장하는 메소드
	@RequestMapping(value = "/insertProcBoard.do")
	public String insertProcBoard(BoardDo bdo) {
		System.out.println("insertProcBoard() 처리");
		// insertBoard.jsp로 부터 입력받은 데이터가
		// 제대로 BoardDo 객체에 저장되어 있는지 확인 --> 디비 저장
		System.out.println("title: " + bdo.getTitle());
		System.out.println("writer: " + bdo.getWriter());
		System.out.println("content: " + bdo.getContent());
		
		// Dao 이용하여 디비에 입력된 값을 저장
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		System.out.println("Dao 이용 데이터 디비저장 완료 !!");
		
		// 뷰리졸버를 이용하여 /boardviews/getBoardList.jsp 호출
		// return "getBoardList";
		// 전체 데이터를 가져오려면,
		// 컨트롤러의 getBoardList.do 매핑 메소드를 호출하여
		// 전체 데이터를 가져와서 출력해주는 작업이 필요함
		// 그래서, 아래의 내용은 뷰어를 호출하는 것이 아닌, 컨트롤러의 처리 메소드를 호출하는 것임
		// 이 때, 필요한 키워드는 redirect 임.
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value = "getBoardList.do")
	public ModelAndView getBoardList(BoardDao bdao, ModelAndView mav) {
		System.out.println("getBoardList() 처리");
		// 전체 데이터를 디비에서 읽어오는 처리 후에 뷰어 호출
		ArrayList<BoardDo> bList = bdao.getBoardList();
		for(BoardDo bdo : bList) {
			System.out.println("--> " + bdo.toString());
		}
		
		// ModelAndView를 이용하여 뷰어를 호출하면서,
		// 데이터를 전달하고자 함
		// addObject("뷰어에 전달하는 변수영", "데이터를 읽어온 변수명")
		mav.addObject("bList", bList);
		//setViewName("뷰어이름") 이용하여 뷰어 호출
		mav.setViewName("getBoardList");
		
		//return "getBoardList";
		return mav;
	}
	
	@RequestMapping(value="modifyBoard.do")
	public ModelAndView modifyBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("modifyBoard() 처리");
		
		// 전체 데이터에서 seq에 해당되는 데이터 가져오기
		System.out.println("seq : " + bdo.getSeq());
		BoardDo board = bdao.getOneBoard(bdo);
		System.out.println("seq : " + bdo.getSeq());
		
		mav.addObject("board", board);		
		mav.setViewName("modifyBoard");
		
		//return "getBoardList";
		return mav;
	}
	
	// modifyProcBoard():수정된 데이터를 전달받아서, 디비를 수정하는 메소드
	@RequestMapping(value = "/modifyProcBoard.do")
	public String modifyProcBoard(BoardDo bdo, BoardDao bdao) {
		System.out.println("modifyProcBoard() 처리");
		// insertBoard.jsp로 부터 입력받은 데이터가
		// 제대로 BoardDo 객체에 저장되어 있는지 확인 --> 디비 저장
		System.out.println("seq : " + bdo.getSeq());
		System.out.println("title: " + bdo.getTitle());
		System.out.println("writer: " + bdo.getWriter());
		System.out.println("content: " + bdo.getContent());
		
		// Dao 이용하여 디비에 입력된 값을 저장		
		bdao.updateBoard(bdo);
		System.out.println("Dao 이용 데이터 수정 저장 완료 !!");

		return "redirect:getBoardList.do";
	}
	
	// deleteBoard(): 디비로 부터 데이터 삭제하는 메소드
	@RequestMapping(value="deleteBoard.do")
	public String deleteBoard(BoardDo bdo, BoardDao bdao) {
		System.out.println("deleteBoard() 처리");
		
		// Dao 이용하여 디비에 입력된 값을 저장		
		bdao.deleteBoard(bdo);
		
		return "redirect:getBoardList.do";
	}
	

}
