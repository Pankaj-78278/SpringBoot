package com.ECom.services.user;


import com.ECom.exception.CartException;
import com.ECom.exception.OrderException;
import com.ECom.exception.ProductException;
import com.ECom.exception.UserException;
import com.ECom.model.admin.Product;
import com.ECom.model.user.Cart;
import com.ECom.model.user.Orders;
import com.ECom.model.user.User;

import java.util.List;

public interface UserServices {
    public User regUser(User user)throws UserException;
    public User updateUser(User user,String key) throws UserException;

    public Cart addProductToCart(Integer userId, Integer productId) throws CartException, UserException, ProductException;

    public Cart removeProductFromCart(Integer userId, Integer productId) throws CartException, UserException, ProductException;

    public Cart removeAllProduct(Integer userId) throws CartException, UserException;
    public Cart increaseProductQuantity(Integer userId, Integer productId) throws CartException, UserException, ProductException;
    public Cart decreaseProductQuantity(Integer userId, Integer productId) throws CartException, UserException, ProductException;
    public Orders addOrder(Integer cid) throws OrderException, UserException, CartException;

    public Orders updateOrder(Orders order) throws OrderException;

    public Orders viewOrder(Integer orderId) throws OrderException;

    public List<Orders> viewAllOrder() throws OrderException;

    public List<Orders> viewAllOrdersByUserId(Integer userId) throws OrderException;

}
