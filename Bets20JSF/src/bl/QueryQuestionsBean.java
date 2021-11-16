package bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;

public class QueryQuestionsBean {

	private BLFacade businessLogic = FacadeBean.getBusinessLogic();
	private List<Event> ebentuak = new ArrayList<Event>(); //businessLogic.getEvents(UtilDate.newDate(2022, 0, 17));
	private Date date;
	private Event ebentua;
	
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
		String[] date = (event.getObject()).toString().split(" ");
		int year = Integer.parseInt(date[5]);
		String month = date[1];
		int monthNum = 0;
		if (month.equals("Dec")){
			monthNum = 11;
		}
		int day = Integer.parseInt(date[2]);
		this.setDate(UtilDate.newDate(year,monthNum,day));
		this.setEbentuak();
		//System.out.println(this.date);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data aukeratua: " + this.ebentuak));
	}
	
	public void setEbentua(Event ev) {
		ebentua = ev;
	}
	
	public Event getEbentua() {
		return ebentua;
	}

}
