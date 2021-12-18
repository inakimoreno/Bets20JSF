package dataAccess;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.persistence.NoResultException;

import configuration.UtilDate;
import domain.Bet;
import domain.Event;
import domain.HibernateUtil;
import domain.Question;
import domain.User;
import exceptions.QuestionAlreadyExist;
import exceptions.UserAlreadyExists;

import org.hibernate.Query;
import org.hibernate.Session;

public class HibernateDataAccess implements DataAccessInterface{

	private Session session;

	public HibernateDataAccess(){
		
	}
	
	public void open() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public void initializeDB() {
		try {
			   	Calendar today = Calendar.getInstance();
			   
			   	int month=today.get(Calendar.MONTH);
			   	month+=1;
			   	int year=today.get(Calendar.YEAR);
			   	if (month==12) { month=0; year+=1;}  
		    
				Event ev1=new Event("Atlético-Athletic", UtilDate.newDate(year,month,17));
				Event ev2=new Event("Eibar-Barcelona", UtilDate.newDate(year,month,17));
				Event ev3=new Event("Getafe-Celta", UtilDate.newDate(year,month,17));
				Event ev4=new Event("Alavés-Deportivo", UtilDate.newDate(year,month,17));
				Event ev5=new Event("Español-Villareal", UtilDate.newDate(year,month,17));
				Event ev6=new Event("Las Palmas-Sevilla", UtilDate.newDate(year,month,17));
				Event ev7=new Event("Malaga-Valencia", UtilDate.newDate(year,month,17));
				Event ev8=new Event("Girona-Leganés", UtilDate.newDate(year,month,17));
				Event ev9=new Event("Real Sociedad-Levante", UtilDate.newDate(year,month,17));
				Event ev10=new Event("Betis-Real Madrid", UtilDate.newDate(year,month,17));

				Event ev11=new Event("Atletico-Athletic", UtilDate.newDate(year,month,1));
				Event ev12=new Event("Eibar-Barcelona", UtilDate.newDate(year,month,1));
				Event ev13=new Event("Getafe-Celta", UtilDate.newDate(year,month,1));
				Event ev14=new Event("Alavés-Deportivo", UtilDate.newDate(year,month,1));
				Event ev15=new Event("Español-Villareal", UtilDate.newDate(year,month,1));
				Event ev16=new Event("Las Palmas-Sevilla", UtilDate.newDate(year,month,1));
				

				Event ev17=new Event("Málaga-Valencia", UtilDate.newDate(year,month,28));
				Event ev18=new Event("Girona-Leganés", UtilDate.newDate(year,month,28));
				Event ev19=new Event("Real Sociedad-Levante", UtilDate.newDate(year,month,28));
				Event ev20=new Event("Betis-Real Madrid", UtilDate.newDate(year,month,28));
				
				Question q1;
				Question q2;
				Question q3;
				Question q4;
				Question q5;
				Question q6;
						
				if (Locale.getDefault().equals(new Locale("es"))) {
					q1=ev1.addQuestion("¿Quién ganará el partido?",1);
					q2=ev1.addQuestion("¿Quién meterá el primer gol?",2);
					q3=ev11.addQuestion("¿Quién ganará el partido?",1);
					q4=ev11.addQuestion("¿Cuántos goles se marcarán?",2);
					q5=ev17.addQuestion("¿Quién ganará el partido?",1);
					q6=ev17.addQuestion("¿Habrá goles en la primera parte?",2);
				}
				else if (Locale.getDefault().equals(new Locale("en"))) {
					q1=ev1.addQuestion("Who will win the match?",1);
					q2=ev1.addQuestion("Who will score first?",2);
					q3=ev11.addQuestion("Who will win the match?",1);
					q4=ev11.addQuestion("How many goals will be scored in the match?",2);
					q5=ev17.addQuestion("Who will win the match?",1);
					q6=ev17.addQuestion("Will there be goals in the first half?",2);
				}			
				else {
					q1=ev1.addQuestion("Zeinek irabaziko du partidua?",1);
					q2=ev1.addQuestion("Zeinek sartuko du lehenengo gola?",2);
					q3=ev11.addQuestion("Zeinek irabaziko du partidua?",1);
					q4=ev11.addQuestion("Zenbat gol sartuko dira?",2);
					q5=ev17.addQuestion("Zeinek irabaziko du partidua?",1);
					q6=ev17.addQuestion("Golak sartuko dira lehenengo zatian?",2);
					
				}
				
				session.beginTransaction();
				
				session.persist(q1);
				session.persist(q2);
				session.persist(q3);
				session.persist(q4);
				session.persist(q5);
				session.persist(q6);
		
		        
				session.persist(ev1);
				session.persist(ev2);
				session.persist(ev3);
				session.persist(ev4);
				session.persist(ev5);
				session.persist(ev6);
				session.persist(ev7);
				session.persist(ev8);
				session.persist(ev9);
				session.persist(ev10);
				session.persist(ev11);
				session.persist(ev12);
				session.persist(ev13);
				session.persist(ev14);
				session.persist(ev15);
				session.persist(ev16);
				session.persist(ev17);
				session.persist(ev18);
				session.persist(ev19);
				session.persist(ev20);			
				
				
				System.out.println("Db initialized");
			}
			catch (Exception e){
				e.printStackTrace();
			}
	}

	public Question createQuestion(Event event, String question, float betMinimum) throws  QuestionAlreadyExist {
		System.out.println(">> DataAccess: createQuestion=> event= "+event+" question= "+question+" betMinimum="+betMinimum);
		
			session.getTransaction().begin();
		
			Event ev = (Event) session.get(Event.class, event.getEventNumber());
			
			if (ev.DoesQuestionExists(question)) throw new QuestionAlreadyExist(ResourceBundle.getBundle("Etiquetas").getString("ErrorQueryAlreadyExist"));
			
			
			Question q = ev.addQuestion(question, betMinimum);
			//db.persist(q);
			session.persist(ev); // db.persist(q) not required when CascadeType.PERSIST is added in questions property of Event class
							// @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
			session.getTransaction().commit();
			return q;
		
	}
	
	public Vector<Event> getEvents(Date date) {
		System.out.println(">> DataAccess: getEvents");
		session.beginTransaction();
		Vector<Event> res = new Vector<Event>();	
		Query query = session.createQuery("SELECT ev FROM Event ev WHERE ev.eventDate=?");   
		query.setParameter(0, date);
		List<Event> events = query.list();
	 	 for (Event ev:events){
	 	   System.out.println(ev.toString());		 
		   res.add(ev);
		  }
	 	return res;
	}
	
	public Vector<Date> getEventsMonth(Date date) {
		System.out.println(">> DataAccess: getEventsMonth");
		session.beginTransaction();
		Vector<Date> res = new Vector<Date>();	
		
		Date firstDayMonthDate= UtilDate.firstDayMonth(date);
		Date lastDayMonthDate= UtilDate.lastDayMonth(date);
				
		
		Query query = session.createQuery("SELECT DISTINCT ev.eventDate FROM Event ev WHERE ev.eventDate BETWEEN ? and ?");   
		query.setParameter(0, firstDayMonthDate);
		query.setParameter(1, lastDayMonthDate);
		List<Date> dates = query.list();
	 	 for (Date d:dates){
	 	   System.out.println(d.toString());		 
		   res.add(d);
		  }
	 	return res;
	}
	
	public boolean existQuestion(Event event, String question) {
		System.out.println(">> DataAccess: existQuestion=> event= "+event+" question= "+question);
		session.beginTransaction();
		Event ev = (Event) session.get(Event.class, event.getEventNumber());
		return ev.DoesQuestionExists(question);
		
	}
	
	public User createUser(String username, String password, String fullName, String email) throws UserAlreadyExists {
		User us = new User(username, password, fullName, email);
		session.beginTransaction();
		if(existsUser(username))
			throw new UserAlreadyExists();
		session.persist(us);
		return us;
	}
	
	public User getUser(String username, String password) {
		session.beginTransaction();
		Query query = session.createQuery("SELECT us FROM User us WHERE us.username = ? and us.password = ?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		User us = (User) query.uniqueResult();
		return us;
	}
	
	public boolean existsUser(String username) {
		Query query = session.createQuery("SELECT us FROM User us WHERE us.username = ?");
		query.setParameter(0, username);
		
		if(query.uniqueResult()==null) {
			return false;
		}
		
		return true;
	}
	
	public Bet createBet(int event, int question, User user, String option, float amount) {
		session.beginTransaction();
		Bet bet = new Bet(event, question, user, option, amount);
		session.persist(bet);
		return bet;
	}
	
	public List<Question> getAllQuestions(){
		session.beginTransaction();
		Query query = session.createQuery("SELECT qu FROM Question qu");
		List<Question> allQuestions = query.list();
		return allQuestions;
	}
	
	public void close(){
		session.getTransaction().commit();
	}
	
}
