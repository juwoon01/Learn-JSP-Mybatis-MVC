package kosta.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kosta.model.Board;
import kosta.model.BoardDao2;
import kosta.model.ListModel;
import kosta.model.Reply;
import kosta.model.Search;

public class BoardService {// url -> service -> dao1, dao2 .... dao는 쿼리 하나하나.. M역할 (비즈니스)
	private static BoardService service = new BoardService();
	private static BoardDao2 dao;
	private static final int PAGE_SIZE = 2;//페이지당 글개수
	
	public static BoardService getInstance() {
		dao = BoardDao2.getInstance();
		return service;
	}
	
	public int insertBoardService(Board board){
		return dao.insertBoard(board);
	}
	
	public ListModel listBoardService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		Search search = null;
		HttpSession session = request.getSession();
		
		//검색
		if(request.getParameterValues("area") != null && request.getParameter("searchKey") != null) {
			search = new Search();
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+request.getParameter("searchKey")+"%");
			session.setAttribute("search", search);
		} else if(request.getParameter("pageNum") == null) {//전체 목록으로 돌아가기
			session.removeAttribute("search");
		} else {
			search = (Search)session.getAttribute("search");
		}	

		// 페이지 처리 필수사항
		// 페이지당 글개수, 총 글개수 ,총 페이지수, 현재페이지, 시작페이지, 끝페이지, startRow(시작 글)
		
		int totalCount = dao.countBoard(search);//총 글개수
		
		int totalPageCount = totalCount / PAGE_SIZE;
		if(totalCount % PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		//현재페이지
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);
		
		//startPage 공식 = 현재페이지 - ((현재페이지-1) % 5)
		int startPage = requestPage - ((requestPage-1) % 5);
		//endPage
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		//startRow 공식 = (현재페이지 -1) * 페이지당 글개수
		int startRow = (requestPage-1) * PAGE_SIZE;
		

		List<Board> list = dao.listBoard(search, startRow);
		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage );
		return listModel;
	}
	
	public Board detailBoardService(int seq){
		return dao.detailBoard(seq);
	}
	
	public List<Reply> detailreplyService(int seq){
		return dao.detailReply(seq);
	}
	
	public int updateBoardService(Board board){
		return dao.updateBoard(board);
	}
	
	public int deleteBoardService(int seq){
		return dao.deleteBoard(seq);
	}
	
	public int insertReplyService(Reply reply){
		return dao.insertReply(reply);
	}
	

}
