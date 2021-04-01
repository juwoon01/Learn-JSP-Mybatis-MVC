package kosta.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertFormAction implements Action {//글쓰기 폼으로 

	@Override
	public ActionForward execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//insert_form.jsp 이동 -> 여기까지 하나의 요청 -> dispatcher
		// 글쓰기 -> insertAction.do -> 요청 종료와 동시에 목록을 봐야함 -> 새로운 요청(redirect) -> ListAction.do
		// c -> dispatcher -> m -> v    ,   c -> dispatcher -> m -> redirect -> c -> m -> v
		//요청했는데 화면에 view = dispatcher // insert, update 등을 하고 글목록을 보여줄 때 = redirect
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/insert_form.jsp");
		
		return forward;
	}

}
