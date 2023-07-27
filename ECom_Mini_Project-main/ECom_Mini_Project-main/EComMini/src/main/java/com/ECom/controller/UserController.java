package com.ECom.controller;

import com.ECom.exception.CartException;
import com.ECom.exception.OrderException;
import com.ECom.exception.ProductException;
import com.ECom.exception.UserException;
import com.ECom.model.admin.Product;
import com.ECom.model.user.Cart;
import com.ECom.model.user.Orders;
import com.ECom.model.user.User;
import com.ECom.repository.user.OrderDao;
import com.ECom.repository.user.UserDao;
import com.ECom.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;
    static boolean isLogin = true;
    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    @PostMapping("/registerUser")
    public ResponseEntity<User> registerNewUserHandler(@RequestBody User user) throws UserException{
        User user1 = userServices.regUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Object> updateUserHandler(@RequestBody User user,@RequestParam(required = false) String key) throws UserException{
        if(isLogin){
            User user1 = userServices.updateUser(user,key);
            return new ResponseEntity<>(user1,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Please Login First ! ",HttpStatus.OK);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<Object> addToCartHandler(@RequestParam("userID") Integer userID,@RequestParam("productID") Integer productID) throws ProductException,UserException, CartException {
        if(isLogin){

            return new ResponseEntity<>(userServices.addProductToCart(userID,productID),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Please Login First ! ",HttpStatus.OK);
    }

    @DeleteMapping("/remove/{cartId}/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable("cartId") Integer cartId,
                                                      @PathVariable("productId") Integer productId) throws CartException, UserException, ProductException {
        return new ResponseEntity<Cart>(userServices.removeProductFromCart(cartId, productId), HttpStatus.OK);
    }
    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<Cart> removeAllProduct(@PathVariable("cartId") Integer cartId) throws CartException, UserException {
        return new ResponseEntity<Cart>(userServices.removeAllProduct(cartId), HttpStatus.OK);
    }

    @PutMapping("/increase/{cartId}/{productId}")
    public ResponseEntity<Cart> increaseProductQuantity(@PathVariable("cartId") Integer cartId, @PathVariable("productId") Integer productId) throws CartException, UserException, ProductException {
        return new ResponseEntity<Cart>(userServices.increaseProductQuantity(cartId, productId), HttpStatus.OK);
    }

    @PutMapping("/decrease/{cartId}/{productId}")
    public ResponseEntity<Cart> decreaseProductQuantity(@PathVariable("cartId") Integer cartId, @PathVariable("productId") Integer productId) throws CartException, UserException, ProductException {
        return new ResponseEntity<Cart>(userServices.decreaseProductQuantity(cartId, productId), HttpStatus.OK);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Orders> addOrder(@RequestParam("userId") Integer userId)
            throws OrderException, UserException, CartException {
        return new ResponseEntity<Orders>(userServices.addOrder(userId), HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) throws OrderException {
        return new ResponseEntity<Orders>(userServices.updateOrder(order), HttpStatus.OK);
    }

    @GetMapping("/viewOrder/{id}")
    public ResponseEntity<Orders> viewOrderById(@PathVariable("id") Integer orderId) throws OrderException {
        return new ResponseEntity<Orders>(userServices.viewOrder(orderId), HttpStatus.OK);
    }
    @GetMapping("/viewListOfOrder")
    public ResponseEntity<List<Orders>> viewAllOrder() throws OrderException {
        return new ResponseEntity<List<Orders>>(userServices.viewAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/viewOrder/{userId}")
    public ResponseEntity<List<Orders>> viewOrderByUserId(@PathVariable("userId") Integer userId)
            throws OrderException {
        return new ResponseEntity<List<Orders>>(userServices.viewAllOrdersByUserId(userId), HttpStatus.OK);
    }
}
