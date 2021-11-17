package bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import domain.Event;
import domain.Question;

public class CreateQuestionBean {

	private BLFacade businessLogic = FacadeBean.getBusinessLogic();
	private static List<Event> ebentuak = new ArrayList<Event>(); //businessLogic.getEvents(UtilDate.newDate(2022, 0, 17));
	private Date date;
	private Event ebentua;
	private Question question;
	private String questionText;
	private float minAmount;

	public CreateQuestionBean() {
	}
	
	public void setBusinessLogic() {
		businessLogic = FacadeBean.getBusinessLogic();
	}
	
	public BLFacade getBusinessLogic() {
		return this.businessLogic;
	}
	
	public void setEbentuak() {
		ebentuak = businessLogic.getEvents(this.date);
	}

	public List<Event> getEbentuak(){
		//ebentuak = businessLogic.getEvents(this.getDate());
		return this.ebentuak;
	}

	public void setDate(Date date){
		this.date = date;
	}

	public Date getDate(){
		return date;
	}
	
	public void onDateSelect(SelectEvent event) {
		this.date = (Date)event.getObject();
		this.setEbentuak();
		//System.out.println(this.date);
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data aukeratua: "+this.getDate()+" "+ this.ebentuak));
	}
	/*
	public void onEventSelect(AjaxBehaviorEvent event) {
		//this.setEbentua(event.ge);
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(event.getObject().toString()));
	}
	*/
	
	public void setEbentua(Event ev) {
		ebentua = ev;
	}
	
	public Event getEbentua() {
		return ebentua;
	}

	public Question getQuestion(){
		return this.question;
	}

	public void setQuestion(){
		try{
			this.businessLogic.createQuestion(ebentua, questionText, minAmount);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String getQuestionText(){
		return this.questionText;
	}

	public void setQuestionText(String text){
		this.questionText = text;
		System.out.print(this.questionText);
	}

	public float getMinAmount(){
		return this.minAmount;
	}

	public void setMinAmount(float amount){
		this.minAmount = amount;
	}
	

	/*
	public void listener(AjaxBehaviorEvent event) {
		System.out.println(this.getEbentua());
	}*/
}
