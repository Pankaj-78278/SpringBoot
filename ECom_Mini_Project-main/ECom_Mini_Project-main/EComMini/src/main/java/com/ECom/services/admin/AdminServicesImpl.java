package com.ECom.services.admin;

import com.ECom.exception.AdminException;
import com.ECom.exception.ProductException;
import com.ECom.model.admin.Admin;
import com.ECom.model.admin.CurrentAdminSession;
import com.ECom.model.admin.Product;
import com.ECom.repository.admin.AdminDao;
import com.ECom.repository.admin.AdminSessionDao;
import com.ECom.repository.admin.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Holder;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServicesImpl implements AdminServices{

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminSessionDao adminSessionDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Admin regAdmin(Admin admin) throws AdminException {
        Admin existingAdmin = adminDao.findByMobileNumber(admin.getMobileNumber());
        if(existingAdmin != null){
            throw new AdminException("Admin with this mobile number already exist");
        }
        return adminDao.save(admin);
    }

    @Override
    public Admin getAdminByID(Integer aid) throws AdminException {
        Optional<Admin> opt = adminDao.findById(aid);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new AdminException("Admin does not exist with Admin ID : " + aid);
    }

    @Override
    public Admin updateAdmin(Admin admin, String key) throws AdminException {
        CurrentAdminSession loggedInUser = adminSessionDao.findByUuid(key);
        if(loggedInUser == null){
            throw new AdminException("Kindly enter valid key to update admin");
        }

        if(admin.getAdminID() == loggedInUser.getAdminID()){
            return adminDao.save(admin);
        }

        throw new AdminException("Invalid admin details, Kindly login again");
    }

    @Override
    public Product addProduct(Product product) throws ProductException {
        Product product1 = productDao.save(product);
        if(product1 != null){
            return  product1;
        }
        throw new ProductException("Something went wrong product has not been added successfully");
    }



    @Override
    public List<Product> getAllProduct() throws ProductException {
        List<Product> allProducts = productDao.findAll();
        if(allProducts.isEmpty()){
            throw new ProductException("No any products found... ");
        }
        return allProducts;
    }

    @Override
    public Product getProductByID(Integer productID) throws ProductException {
        Optional<Product> product = productDao.findById(productID);
        if(product.isPresent()){
            return product.get();
        }

        throw new ProductException("Product does not exist with Product ID : "+productID);
    }

    @Override
    public Product deleteProductByID(Integer productID) throws ProductException {
        Optional<Product> product = productDao.findById(productID);
        if(product.isPresent()){
            productDao.delete(product.get());
            return product.get();
        }
        throw new ProductException("Product does not exist with Product ID : "+productID);
    }
}
