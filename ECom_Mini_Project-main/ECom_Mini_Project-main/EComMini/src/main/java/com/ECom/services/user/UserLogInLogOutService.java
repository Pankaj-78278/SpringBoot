package com.ECom.services.user;



import com.ECom.exception.UserException;
import com.ECom.model.user.UserSignInDTO;

public interface UserLogInLogOutService {
    public String logInUser(UserSignInDTO userSignInDTO) throws UserException;
    public String logOutUser(String key) throws UserException;
}
