package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.service.BoardService;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardService sevice = BoardService.getInstance();
		request.setCharacterEncoding("utf-8");
		
		Board board = new Board();
		board.setSeq(Integer.parseInt(request.getParameter("seq")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));;
		board.setContents(request.getParameter("contents"));
		
		sevice.updateBoardService(board);
		
		forward.setRedirect(true);
		forward.setPath("listAction.do");
		return forward;
	}

}
