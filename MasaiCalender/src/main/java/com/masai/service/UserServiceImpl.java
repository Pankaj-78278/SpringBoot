package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EventException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSessionDTO;
import com.masai.model.Event;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.EventRepo;
import com.masai.repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private CurrentUserSessionDTO crepo;
	
	@Autowired
	private EventRepo erepo;
	
	@Override
	public String loginAccount(UserDTO dto) throws LoginException {
		User existingUser= repo.findByEmail(dto.getEmail());

        if(existingUser==null){
            throw new LoginException("User doesn't exist...!");
        }

        Optional<CurrentUserSessionDTO> validSessionOpt = crepo.(existingUser.getEmail());
        if(validSessionOpt.isPresent()) {
            throw new LoginException("User already Logged In");
        }

        if(existingUser.getPassword().equals(dto.getPassword())) {

            String userOtp= RandomString.make(4);

            CurrentUserSessionDTO currentSession = new CurrentUserSessionDTO(existingUser.getUserId(),userOtp,LocalDateTime.now());

            crepo.save(currentSession);

            return currentSession.toString();
        }
        else
            throw new LoginException("Please Enter a valid password");
	}

	@Override
	public User registerUser(User user) throws UserException {
		User us=repo.save(user);
		return us;
	}

	@Override
	public User updateUser(User user) throws UserException {
		User existinguser = repo.findByEmail(user.getEmail());
		if(existinguser==null) {
			User updateUser = new User();
			
			updateUser.setUserId(user.getUserId());
			
			updateUser.setFirstName(user.getFirstName());
			
			updateUser.setLastName(user.getLastName());
			
			updateUser.setDateOfBirth(user.getDateOfBirth());
			
			updateUser.setEmail(user.getEmail());
			
			updateUser.setMobileNumber(user.getMobileNumber());
			
			updateUser.setPassword(user.getPassword());
			
			return repo.save(updateUser);

			
		}
        throw new UserException(" user not  find  with  email");
	}

	@Override
	public List<Event> getEventByType(String type) throws EventException {
			 List<Event> eventList = erepo.findByType(type);

	         if(eventList.size()>0) {
	      	   return eventList;
	         }
	         
	         throw new EventException("Event is empty");
		}
	

}
