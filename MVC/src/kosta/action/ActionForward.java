package kosta.action;

public class ActionForward {
	private boolean isRedirect;//리다이렉트로 이동 할 것인가? 
	private String path;
	
	public ActionForward() {
		super();
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
