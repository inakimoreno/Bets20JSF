package bl;

import java.util.ArrayList;



import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;

//import BLFacade;
//import businessLogic.BLFacadeImplementation;
import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;

public class QueryQuestionsBean {

	private BLFacade businessLogic = FacadeBean.getBusinessLogic();
	private List<Event> ebentuak = new ArrayList<Event>(); //businessLogic.getEvents(UtilDate.newDate(2022, 0, 17));
	private List<Question> galderak = new ArrayList<Question>();
	private Date date;
	private Event ebentua;
	private int galdera;
	private boolean bilatuButtonState=true;
	
	public QueryQuestionsBean() {
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
		setGalderak();
	}
	
	public Event getEbentua() {
		return ebentua;
	}

	public void setGalderak() {
		galderak = this.ebentua.getQuestions();
	}
	
	public List<Question> getGalderak(){
		System.out.println(galderak);
		return galderak;
	}
	
	public void onQuestionSelect(SelectEvent event) {
		this.galdera = ((Question) event.getObject()).getQuestionNumber();
		System.out.println(this.galdera);
	}
	
	public void setGaldera(Question galdera) {
		this.galdera = galdera.getQuestionNumber();
	}
	
	public int getGaldera() {
		return galdera;
	}
	
	public void setBilatuButton(boolean state) {
		bilatuButtonState = state;
	}
	
	public boolean getBilatuButtonState() {
		return bilatuButtonState;
	}
}