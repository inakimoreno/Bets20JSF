package bl;

import java.util.List;


import configuration.UtilDate;
import domain.Event;

public class Main {
    
    public static void main(String[] args){
        BLFacade bl = FacadeBean.getBusinessLogic();
        List<Event> events = bl.getEvents(UtilDate.newDate(2021, 11, 17));
        for(Event ev:events){
            System.out.println(ev.getDescription());
            System.out.println(ev.getQuestions());
        }
    }

}
