package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Reply;
import kosta.service.BoardService;

public class InsertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardService service = BoardService.getInstance();
		
		Reply reply = new Reply();
		reply.setSeq(Integer.parseInt(request.getParameter("seq")));
		reply.setR_title(request.getParameter("r_title"));
		reply.setR_writer(request.getParameter("r_writer"));;
		reply.setR_contents(request.getParameter("r_contents"));
		
		service.insertReplyService(reply);
		forward.setRedirect(true);
		forward.setPath("detail.do?seq=" + request.getParameter("seq"));
		request.setCharacterEncoding("utf-8");
		
	
		return forward;
	}

}
