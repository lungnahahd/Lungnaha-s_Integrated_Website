package com.Lungnaha.IntegratedWebsite;

import java.util.List;

public interface BoardService {

	// 글 등록
	void insertBlogBoard(BoardVO vo);

	// 글 수정
	void updateBlogBoard(BoardVO vo);

	// 글 삭제
	void deleteBlogBoard(BoardVO vo);

	// 원하는 글 가져오기
	BoardVO getBlogBoard(BoardVO vo);

	// 글 목록 가져오기
	List<BoardVO> getlistBlogBoard(BoardVO vo);

}