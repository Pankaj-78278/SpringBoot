package com.ECom.controller;

import com.ECom.exception.AdminException;
import com.ECom.exception.UserException;
import com.ECom.model.admin.AdminSignInDTO;
import com.ECom.model.user.UserSignInDTO;
import com.ECom.services.admin.AdminLoginLogOutService;
import com.ECom.services.admin.AdminServices;
import com.ECom.services.user.UserLogInLogOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginOrLogoutController {

    @Autowired
    private AdminLoginLogOutService adminLoginService;

    @Autowired
    private AdminServices adminServices;

    @Autowired
    private UserLogInLogOutService userLogInLogOutService;


    @PostMapping("/adminLogin")
    public ResponseEntity<String> logInAdminHandler(@RequestBody AdminSignInDTO adminSignInDTO) throws AdminException{
        String result = adminLoginService.logInAdmin(adminSignInDTO);
        if(result != null){
            AdminController.isLogin = true;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/adminLogOut")
    public String logOutAdminHandler(@RequestParam(required = true) String key) throws AdminException{
        String result = adminLoginService.logOutAdmin(key);
        if(result != null){
            AdminController.isLogin = false;
        }
        return result;
    }

    // User Login Logout Controller
    @PostMapping("/userLogin")
    public ResponseEntity<String> logInUserHandler(@RequestBody UserSignInDTO userSignInDTO) throws UserException {
        String result = userLogInLogOutService.logInUser(userSignInDTO);
        if(result != null){
            UserController.isLogin = true;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/userLoggedOut")
    public String logOutUserHandler(@RequestParam(required = true) String key)throws UserException{
        String result = userLogInLogOutService.logOutUser(key);
        if(result != null){
            UserController.isLogin = false;
        }
        return result;
    }
}
