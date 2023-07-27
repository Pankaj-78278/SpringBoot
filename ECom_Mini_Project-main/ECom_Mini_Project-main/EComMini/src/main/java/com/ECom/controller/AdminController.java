package com.ECom.controller;

import com.ECom.exception.AdminException;
import com.ECom.exception.ProductException;
import com.ECom.model.admin.Admin;
import com.ECom.model.admin.Product;
import com.ECom.services.admin.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices;


    static boolean isLogin = true;

    @PostMapping("/registerAdmin")
    public ResponseEntity<Admin> registerAdminHandler(@RequestBody Admin admin)throws AdminException {
        Admin admin1 = adminServices.regAdmin(admin);
        return new ResponseEntity<>(admin1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/admin/{adminID}")
    public ResponseEntity<Admin> getAdminByIDHandler(@PathVariable("adminID") Integer aid){
        Admin admin = adminServices.getAdminByID(aid);
        return new ResponseEntity<>(admin,HttpStatus.OK);
    }

    @PutMapping("/updateAdmin")
    public ResponseEntity<Object> updateAdminHandler(@RequestBody Admin admin,@RequestParam(required = false) String key) throws AdminException{
        if(isLogin){
            Admin updatedAdmin = adminServices.updateAdmin(admin,key);
            return new ResponseEntity<>(updatedAdmin,HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Please login first",HttpStatus.OK);
        }
    }


    @PostMapping("/addProduct")
    public ResponseEntity<Object> addProductHandler(@RequestBody Product product) throws ProductException{
        if(isLogin){
            Product product1 = adminServices.addProduct(product);
            return new ResponseEntity<>(product1,HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>("Please Login First !",HttpStatus.OK);
        }
    }



    @GetMapping("/getAllProducts")
    public  ResponseEntity<Object> getAllProductHandler()throws ProductException{
        if(isLogin){
            List<Product> products = adminServices.getAllProduct();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return new ResponseEntity<>("Please Login First ! ",HttpStatus.OK);
    }

    @GetMapping("/getProductDetails/{productID}")
    public ResponseEntity<Object> getProductDetailsByIDHandler(@PathVariable("productID") Integer productID) throws ProductException{
        if(isLogin){
            Product product = adminServices.getProductByID(productID);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>("Please Login First ! ",HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{productID}")
    public ResponseEntity<Object> deleteProductByIDHandler(@PathVariable("productID") Integer productID) throws ProductException{
        if(isLogin){
            Product product = adminServices.getProductByID(productID);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>("Please Login First ! ",HttpStatus.OK);
    }
}
