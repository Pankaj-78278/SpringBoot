package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginLogoutException;
import com.masai.exception.UserException;
import com.masai.model.CurrentSessionDTO;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.repository.CurrentUserSessionDTO;
import com.masai.repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	private CurrentUserSessionDTO crepo;
	
	@Override
	public User registerUser(User user) throws UserException {
		User existingUser = repo.findByEmail(user.getEmail());
        if (existingUser != null)
            throw new UserException("User Exist in System");

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setAge(user.getAge());
        user.setMobileNumber(user.getMobileNumber());
        user.setGender(user.getGender());
        user.setPassword(user.getPassword());

        User nUser=repo.save(user);

        return nUser;
	}

	@Override
	public String loginAccount(UserDTO dto) throws LoginLogoutException {
		User existingUser= repo.findByEmail(dto.getEmail());

        if(existingUser==null){
            throw new LoginLogoutException("User doesn't exist...!");
        }

        Optional<CurrentSessionDTO> validSessionOpt = crepo.findById(existingUser.getEmail());
        if(validSessionOpt.isPresent()) {
            throw new LoginLogoutException("User already Logged In");
        }

        if(existingUser.getPassword().equals(dto.getPassword())) {

            String userOtp= RandomString.make(4);

            CurrentSessionDTO currentSession = new CurrentSessionDTO(existingUser.getUserId(),userOtp,LocalDateTime.now());

            crepo.save(currentSession);

            return currentSession.toString();
        }
        else
            throw new LoginLogoutException("Please Enter a valid password");
	}

	
}
