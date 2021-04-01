package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.BoardService;

public class InsertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardService service = BoardService.getInstance();
		service.insertReplyService(request);
		forward.setRedirect(true);
		forward.setPath("detail.do?seq=" + request.getParameter("seq"));
		
		return forward;
	}

}
