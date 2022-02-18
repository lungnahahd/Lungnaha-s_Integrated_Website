package com.Lungnaha.IntegratedWebsite;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

	public static void main(String[] args) {
		// ������ �����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// ������ �����̳ʰ� ���� ���� ��ü�� lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
//		// �� ��� ���� �׽�Ʈ
		BoardVO vo = new BoardVO();
//		vo.setTitle("�׽�Ʈ ����");
//		vo.setWriter("������");
//		vo.setContent("220218 �׽�Ʈ ���Դϴ�....");
//		boardService.insertBlogBoard(vo);
//		
		// �� ��� �˻� ���� �׽�Ʈ
		List<BoardVO> boardList = boardService.getlistBlogBoard(vo);
		for(BoardVO board : boardList) {
			System.out.println("----> " + board.toString());
		}
		
		// ������ �����̳� ���� 
		container.close();
	}

}
