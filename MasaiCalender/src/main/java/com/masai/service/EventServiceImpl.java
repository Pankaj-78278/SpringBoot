package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EventException;
import com.masai.model.Event;
import com.masai.model.User;
import com.masai.repository.EventRepo;
import com.masai.repository.UserRepository;
@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepo erepo;
	
	@Autowired
	private UserRepository urepo;
	@Override
	public Event registerEvent(Event event, String email) throws EventException {
		User us=urepo.findByEmail(email);
		us.getEvents().add(event);
		return erepo.save(event);
	}

	@Override
	public Event updateEven(Integer id, Event event) throws EventException {
		Optional<Event> opt = erepo.findById(id);
        Event eventUser = opt.get();
        if(eventUser!=null) {
       	 
        	eventUser.setEndDate(eventUser.getEndDate());
        	eventUser.setEndTime(eventUser.getEndTime());
        	eventUser.setId(eventUser.getId());
        	eventUser.setIsRecurring(eventUser.getIsRecurring());
        	eventUser.setStartDate(eventUser.getStartDate());
        	eventUser.setStartTime(eventUser.getStartTime());
        	eventUser.setTitle(eventUser.getTitle());
           
            return  erepo.save(eventUser);
        }
        else 
       	 throw new EventException("No event find" ) ;
	}

	@Override
	public Event deleteEven(Integer id) throws EventException {
		Optional<Event> option =   erepo.findById(id); 
	      Event event = option.get();
	      if(event!=null) {
	    	erepo.delete(event);
	    	return event;
	      }else {
	    	  throw new EventException("No event find");
	      }

		}
	

}
