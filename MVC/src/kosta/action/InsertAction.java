package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.service.BoardService;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception { //비즈니스 로직 호출 -> 호출된 결과 저장 -> 뷰를 선정
		ActionForward forward = new ActionForward();
		BoardService service = BoardService.getInstance();
		
		
		service.insertBoardService(request);//비즈니스 로직 호출 
		//뷰를 선정
		forward.setRedirect(true);
		forward.setPath("listAction.do");// 글 목록을 보기 위해 새로운 요청
		
		return forward;
	}

}
