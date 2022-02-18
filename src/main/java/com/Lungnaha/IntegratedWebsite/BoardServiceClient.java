package com.Lungnaha.IntegratedWebsite;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 스프링 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 스프링 컨테이너가 서비스 구현 객체를 lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
//		// 글 등록 서비스 테스트
		BoardVO vo = new BoardVO();
//		vo.setTitle("테스트 제목");
//		vo.setWriter("렁나하");
//		vo.setContent("220218 테스트 글입니다....");
//		boardService.insertBlogBoard(vo);
//		
		// 글 목록 검색 서비스 테스트
		List<BoardVO> boardList = boardService.getlistBlogBoard(vo);
		for(BoardVO board : boardList) {
			System.out.println("----> " + board.toString());
		}
		
		// 스프링 컨테이너 종료 
		container.close();
	}

}
