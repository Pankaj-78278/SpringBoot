package com.ECom.services.admin;

import com.ECom.exception.AdminException;
import com.ECom.model.admin.AdminSignInDTO;

public interface AdminLoginLogOutService {
    public String logInAdmin(AdminSignInDTO adminSignInDTO) throws AdminException;
    public String logOutAdmin(String key) throws AdminException;
}
