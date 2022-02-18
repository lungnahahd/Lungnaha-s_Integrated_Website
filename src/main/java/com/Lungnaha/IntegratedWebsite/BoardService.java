package com.Lungnaha.IntegratedWebsite;

import java.util.List;

public interface BoardService {

	// �� ���
	void insertBlogBoard(BoardVO vo);

	// �� ����
	void updateBlogBoard(BoardVO vo);

	// �� ����
	void deleteBlogBoard(BoardVO vo);

	// ���ϴ� �� ��������
	BoardVO getBlogBoard(BoardVO vo);

	// �� ��� ��������
	List<BoardVO> getlistBlogBoard(BoardVO vo);

}