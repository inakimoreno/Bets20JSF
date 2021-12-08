package bl;

import domain.User;

public class LoginBean {

	private BLFacade bl = FacadeBean.getBusinessLogic();
	private String username;
	private String password;
	private User user;
	public BLFacade getBl() {
		return bl;
	}
	public void setBl(BLFacade bl) {
		this.bl = bl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public String setUser() {
		user = bl.getUser(username, password);
		if(user!=null) {
			return "back";
		}
		return "";
	}
	
	public void logOut() {
		this.user = null;
	}
	
	
}
