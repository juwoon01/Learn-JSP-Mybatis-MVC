package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.model.Reply;
import kosta.service.BoardService;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardService service = BoardService.getInstance();
		
		Board board = service.detailBoardService(request);
		List<Reply> listReply = service.detailreplyService(request);
		request.setAttribute("board", board);
		request.setAttribute("listReply", listReply);
		
		forward.setRedirect(false);
		forward.setPath("/detail.jsp");
		return forward;
	}

}
