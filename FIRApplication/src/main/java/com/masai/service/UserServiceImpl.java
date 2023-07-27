package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DAO.UserDAO;
import com.masai.DAO.UserSessionDao;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.LoginDTO;
import com.masai.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO urepo;
	
	@Autowired
	private UserSessionDao usRepo;

	@Override
	public User registerUser(User user) throws UserException {
		User exiUser = urepo.findByMobileNo(user.getMobileNumber());
		
		if(exiUser!=null) {
			throw new UserException("User already registered with this mobile No!");
		}
		
		User registerUser = urepo.save(user);
		
		
		return registerUser;
	}

	@Override
	public String logIn(LoginDTO dto) throws LoginException {
User existingUser = urepo.findByMobileNo(dto.getMobli);
		
		if(existingUser == null) {
			throw new LoginException("Please register your self first!");
		}
		
		Optional<UserCurrentSession> validUser = uSDao.findById(existingUser.getUserId());
		
		if(validUser.isPresent()) {
			throw new LoginException("User already logged in");
		}
		
		if(existingUser.getPassword().equals(dto.getPassword())) {
			
			String key = RandomString.make(6);
			
			UserCurrentSession userCurrentSession = new UserCurrentSession(existingUser.getUserId(),key,LocalDateTime.now());
			
			uSDao.save(userCurrentSession);
			
			return userCurrentSession.toString();
		}
		else {
			throw new LoginException("Please enter a valid password!");
		}
	}

	@Override
	public String logOut(String uId) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}


}
