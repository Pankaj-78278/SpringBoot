package com.ECom.services.user;

import com.ECom.exception.CartException;
import com.ECom.exception.OrderException;
import com.ECom.exception.ProductException;
import com.ECom.exception.UserException;
import com.ECom.model.admin.Product;
import com.ECom.model.user.Cart;
import com.ECom.model.user.CurrentUserSession;
import com.ECom.model.user.Orders;
import com.ECom.model.user.User;
import com.ECom.repository.admin.ProductDao;
import com.ECom.repository.user.CartDao;
import com.ECom.repository.user.OrderDao;
import com.ECom.repository.user.UserDao;
import com.ECom.repository.user.UserSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserSessionDao userSessionDao;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public User regUser(User user) throws UserException {
        User existingUser = userDao.findByMob(user.getMob());
        if(existingUser != null){
            throw new UserException("User already exist with this mobile number : "+user.getMob());
        }
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user,String key) throws UserException {
        CurrentUserSession currentUserSession = userSessionDao.findByUnqID(key);
        if(currentUserSession == null){
            throw new UserException("kindly enter valid key for update user details !");
        }

        if(Objects.equals(user.getUserID(), currentUserSession.getUserID())){
            return userDao.save(user);
        }
        throw new UserException("Invalid key ,kindly login again");
    }

    @Override
    public Cart addProductToCart(Integer userId, Integer productId) throws CartException, UserException, ProductException {
        Optional<User> existingUserOpt = userDao.findById(userId);
        if(existingUserOpt.isEmpty())
            throw new UserException("User does not exist with the userID : "+userId);

        Optional<Product> existingProductOpt = productDao.findById(productId);
        if(existingProductOpt.isEmpty())
            throw new ProductException("Product does not exist with the ProductID : "+productId);


        User user = existingUserOpt.get();
        Cart cart = user.getCart();

        List<Product> productList = cart.getProducts();
        boolean flag = true ;
        for (int i = 0; i < productList.size(); i++) {
            Product el = productList.get(i);
            if (el.getProductID() == productId) {
                if (cart.getProduct_quantity() == null) {
                    cart.setProduct_quantity(1);
                } else {
                    cart.setProduct_quantity(cart.getProduct_quantity() + 1);
                }
                flag = false;
            }
        }
        if(flag){
            cart.getProducts().add(existingProductOpt.get());
        }
        cartDao.save(cart);
        return cart;
    }

    @Override
    public Cart removeProductFromCart(Integer userId, Integer productId) throws CartException, UserException, ProductException {
        Optional<User> opt = userDao.findById(userId);
        if (opt.isEmpty())
            throw new UserException("Customer not found!");

        Optional<Product> itemOpt = productDao.findById(productId);
        if (itemOpt.isEmpty())
            throw new ProductException("Product not found!");
        User user = opt.get();
        Cart cart = user.getCart();
        List<Product> itemList = cart.getProducts();
        boolean flag = false;
        for (int i = 0; i < itemList.size(); i++) {
            Product element = itemList.get(i);
            if (element.getProductID() == productId) {
                itemList.remove(element);
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new CartException("Product not removed from cart");
        }
        cart.setProducts(itemList);
        cartDao.save(cart);
        return cart;
    }

    @Override
    public Cart removeAllProduct(Integer userId) throws CartException, UserException {
        Optional<User> opt = userDao.findById(userId);
        if (opt.isEmpty())
            throw new UserException("Customer not found!");
        Cart c = opt.get().getCart();
        if (c == null) {
            throw new CartException("cart not found");
        }
        c.getProducts().clear();
        return cartDao.save(c);
    }

    @Override
    public Cart increaseProductQuantity(Integer userId, Integer productId) throws CartException, UserException, ProductException {
        Optional<User> opt = userDao.findById(userId);
        if (opt.isEmpty())
            throw new UserException("Customer not found!");

        Optional<Product> itemOpt = productDao.findById(productId);
        if (itemOpt.isEmpty())
            throw new ProductException("Product not found!");

        User user = opt.get();
        Cart cart = user.getCart();
        List<Product> itemList = cart.getProducts();
        boolean flag = true;
        for (int i = 0; i < itemList.size(); i++) {
            Product element = itemList.get(i);
            if (element.getProductID() == productId) {
                cart.setProduct_quantity(cart.getProduct_quantity() + 1);
                flag = false;
            }
        }
        if (flag) {
            cart.getProducts().add(itemOpt.get());
        }

        cartDao.save(cart);
        return cart;

    }

    @Override
    public Cart decreaseProductQuantity(Integer userId, Integer productId) throws CartException, UserException, ProductException {
        Optional<User> opt = userDao.findById(userId);
        if (opt.isEmpty()) throw new UserException("Customer not found!");

        Optional<Product> itemOpt = productDao.findById(productId);
        if (itemOpt.isEmpty())
            throw new ProductException("Product not found!");

        User user = opt.get();
        Cart cart = user.getCart();
        List<Product> itemList = cart.getProducts();
        boolean flag = true;
        if (itemList.size() > 0) {
            for (int i = 0; i < itemList.size(); i++) {
                Product element = itemList.get(i);
                if (element.getProductID() == productId) {
                    cart.setProduct_quantity(cart.getProduct_quantity() + 1);
                    flag = false;
                }
            }
        }

        if (flag) {
            cart.getProducts().add(itemOpt.get());
        }

        cartDao.save(cart);
        return cart;
    }

    @Override
    public Orders addOrder(Integer cid) throws OrderException, UserException, CartException {
        Optional<User> opt = userDao.findById(cid);
        if (opt.isEmpty()) {
            throw new UserException("Customer not found");
        }

        User user = opt.get();
        Cart cart = user.getCart();
        Orders o = new Orders();

        o.setDate(LocalDateTime.now());
        o.setOrderStatus("Pending");
        o.setUser(user);
        if (cart.getProducts().isEmpty()) {
            throw new CartException("add minimum one product to order!");
        } else {
            o.setProductList(new ArrayList<>(cart.getProducts()));
            return orderDao.save(o);
        }

    }

    @Override
    public Orders updateOrder(Orders order) throws OrderException {
        Orders o = orderDao.findById(order.getOrderId()).orElseThrow(() -> new OrderException("Order not found"));
        if (o != null) {
            orderDao.save(order);
        }
        return o;
    }

    @Override
    public Orders viewOrder(Integer orderId) throws OrderException {
        Optional<Orders> o = orderDao.findById(orderId);
        if (o.isPresent()) {
            return o.get();
        } else {
            throw new OrderException("order not present!!");
        }
    }

    @Override
    public List<Orders> viewAllOrder() throws OrderException {
        List<Orders> orders = orderDao.findAll();
        if (orders.size() > 0) {
            return orders;
        } else {
            throw new OrderException("Order not found");
        }
    }

    @Override
    public List<Orders> viewAllOrdersByUserId(Integer userId) throws OrderException {
        List<Orders> orders = userDao.getAllOrderByCid(userId);
        if (orders.size() > 0) {
            return orders;
        } else {
            throw new OrderException("Order not found");
        }
    }


}
