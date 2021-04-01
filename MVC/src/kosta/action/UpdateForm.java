package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.service.BoardService;

public class UpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardService sevice = BoardService.getInstance();
		Board board = sevice.detailBoardService(request);
		request.setAttribute("board", board);
		
		forward.setRedirect(false);
		forward.setPath("/updateForm.jsp");
		return forward;
	}

}
