package bl;

import domain.Bet;
import domain.Event;
import domain.Question;
import domain.User;

public class BetBean {

	private BLFacade bl=FacadeBean.getBusinessLogic();
	private int id;
	private int eventNumber;
	private Question question;
	private User user;
	private String option;
	private float amount;
	private Bet bet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEventNumber() {
		return eventNumber;
	}
	public void setEvent(int eventNumber) {
		this.eventNumber = eventNumber;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Bet getBet() {
		return bet;
	}
	public void setBet(int event, int question, User user, String option, float amount) {
		this.bet = bl.createBet(event, question, user, option, amount);
	}
	
}
