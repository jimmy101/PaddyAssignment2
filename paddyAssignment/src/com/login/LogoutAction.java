package com.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements ServletRequestAware {
	
	private HttpSession session;
	private HttpServletRequest session1;
	
	public String execute(){
		
		setSession(session1.getSession());
		session1.removeAttribute("user");
		return SUCCESS;
	}
	
	

	public HttpSession getSession() {
		return session;
	}



	public void setSession(HttpSession session) {
		this.session = session;
	}



	public HttpServletRequest getSession1() {
		return session1;
	}



	public void setSession1(HttpServletRequest session1) {
		this.session1 = session1;
	}



	@Override
	public void setServletRequest(HttpServletRequest session1) {
		this.session1 = session1;
		
		
	}

}
