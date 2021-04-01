package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kosta.model.ListModel;
import kosta.service.BoardService;


public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardService service = BoardService.getInstance();
		ListModel listModel = service.listBoardService(request);
		request.setAttribute("listModel", listModel);
		forward.setRedirect(false);
		forward.setPath("/list.jsp");
		
				
		return forward;
	}

}
