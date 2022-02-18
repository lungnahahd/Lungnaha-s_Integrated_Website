package com.Lungnaha.IntegratedWebsite.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lungnaha.IntegratedWebsite.BoardService;
import com.Lungnaha.IntegratedWebsite.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
		
	@Override
	public void insertBlogBoard(BoardVO vo) {
		boardDAO.insertBlogBoard(vo);
		
	}

	@Override
	public void updateBlogBoard(BoardVO vo) {
		boardDAO.updateBlogBoard(vo);
	}

	@Override
	public void deleteBlogBoard(BoardVO vo) {
		boardDAO.deleteBlogBoard(vo);
	}

	@Override
	public BoardVO getBlogBoard(BoardVO vo) {
		return boardDAO.getBlogBoard(vo);
	}

	@Override
	public List<BoardVO> getlistBlogBoard(BoardVO vo) {
		return boardDAO.getlistBlogBoard(vo);
	}

}
