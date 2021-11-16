package bl;

import businessLogic.BLFacade;
import domain.Event;

public class CreateQuestionBean {

	private BLFacade businessLogic;
	private Event ev;
	private String Question;
	private float betMinimum;
	public BLFacade getBusinessLogic() {
		return businessLogic;
	}
	public void setBusinessLogic(BLFacade businessLogic) {
		this.businessLogic = businessLogic;
	}
	public Event getEv() {
		return ev;
	}
	public void setEv(Event ev) {
		this.ev = ev;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public float getBetMinimum() {
		return betMinimum;
	}
	public void setBetMinimum(float betMinimum) {
		this.betMinimum = betMinimum;
	}
	/*
	public List<Event> getAllEvents(){
		return businessLogic
	}
	*/
}
