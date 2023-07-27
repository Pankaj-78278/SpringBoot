package com.ECom.services.admin;

import com.ECom.exception.AdminException;
import com.ECom.exception.CartException;
import com.ECom.exception.ProductException;
import com.ECom.exception.UserException;
import com.ECom.model.admin.Admin;
import com.ECom.model.admin.Product;
import com.ECom.model.user.Cart;

import java.util.List;

public interface AdminServices {
    public Admin regAdmin(Admin admin)throws AdminException;
    public Admin getAdminByID(Integer aid) throws AdminException;
    public Admin updateAdmin(Admin admin,String key) throws AdminException;
    public Product addProduct(Product product) throws ProductException;

    public List<Product> getAllProduct() throws ProductException;
    public Product getProductByID(Integer productID) throws ProductException;
    public Product deleteProductByID(Integer productID) throws ProductException;
}
