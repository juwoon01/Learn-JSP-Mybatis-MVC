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
		sevice.updateBoardService(request);
		
		forward.setRedirect(true);
		forward.setPath("listAction.do");
		return forward;
	}

}
