package com.struts.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class GreetAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4848240926233858013L;
	private String name;
	private Map<String, Object> userSession;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Object> getUserSession() {
		return userSession;
	}
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	@Override
	public String execute() throws Exception {
		// create a valuestack
		ValueStack stack = ActionContext.getContext().getValueStack();
		//create a key value pairs
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("message", "GreatDay");
		mapData.put("fruits", Arrays.asList("apple","orange"));
		
		// add them to the valuestack
		stack.push(mapData);
		System.out.println(stack.size());
		userSession.put("message", "Greatday");
		userSession.put("courses", Arrays.asList("Java","Spring"));
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		userSession = session; 
	}
	
}
