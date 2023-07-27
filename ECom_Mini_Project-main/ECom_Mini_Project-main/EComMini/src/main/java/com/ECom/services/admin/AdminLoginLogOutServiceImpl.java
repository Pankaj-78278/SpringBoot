package com.ECom.services.admin;

import com.ECom.exception.AdminException;
import com.ECom.model.admin.Admin;
import com.ECom.model.admin.AdminSignInDTO;
import com.ECom.model.admin.CurrentAdminSession;
import com.ECom.repository.admin.AdminDao;
import com.ECom.repository.admin.AdminSessionDao;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminLoginLogOutServiceImpl implements AdminLoginLogOutService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminSessionDao adminSessionDao;

    @Override
    public String logInAdmin(AdminSignInDTO adminSignInDTO) throws AdminException {

        Admin existingAdmin = adminDao.findByMobileNumber(adminSignInDTO.getMobile());
        if(existingAdmin == null){
            throw new AdminException("Please enter valid email or password");
        }

        Optional<CurrentAdminSession> validAdminSessionOpt = adminSessionDao.findById(existingAdmin.getAdminID());
        if(validAdminSessionOpt.isPresent()){
            throw new AdminException("User already logged in with this mobile number");
        }

        if(existingAdmin.getPassword().equals(adminSignInDTO.getPassword())) {
            String key = RandomString.make(6);
            CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminID(), key, LocalDateTime.now());
            adminSessionDao.save(currentAdminSession);
            return "Kindly note this UUID for future reference : " + currentAdminSession.getUuid();
        }
        throw new AdminException("Kindly enter valid password");
    }

    @Override
    public String logOutAdmin(String key) throws AdminException {
        CurrentAdminSession currentAdminSession = adminSessionDao.findByUuid(key);
        if(currentAdminSession == null){
            throw new AdminException("User not logged In with this mobile number yet");
        }

        adminSessionDao.delete(currentAdminSession);
        return "Logged Out !";
    }
}
