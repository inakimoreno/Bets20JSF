package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bet {

	@Id
	@GeneratedValue
	private int id;
	private int eventNumber;
	private int questionNumber;
	@OneToOne
	private User user;
	private String option;
	private float amount;
	
	public Bet() {}
	
	public Bet(int eventNumber, int question, User user, String option, float amount) {
		this.eventNumber = eventNumber;
		this.questionNumber = question;
		this.user = user;
		this.option = option;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEvent() {
		return eventNumber;
	}
	public void setEvent(int eventNumber) {
		this.eventNumber = eventNumber;
	}
	public int getQuestion() {
		return questionNumber;
	}
	public void setQuestion(int question) {
		this.questionNumber = question;
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
	
}
