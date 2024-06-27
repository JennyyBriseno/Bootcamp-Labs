package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProductDao;
import org.yearup.data.ShoppingCartDao;
import org.yearup.data.UserDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.models.User;

import java.security.Principal;

// convert this class to a REST controller
@RestController
@RequestMapping("/cart")
// only logged-in users should have access to these actions
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class ShoppingCartController
{
    // a shopping cart requires
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    //WORKS
    @GetMapping
    // each method in this controller requires a Principal object as a parameter
    public ResponseEntity<ShoppingCart> getCart(Principal principal)
    {
            // get the currently logged-in username
            String userName = principal.getName();
            // find database user by userId
            User user = userDao.getByUserName(userName);
            int userId = user.getId();
            // use the shoppingCartDao to get all items in the cart and return the cart
            var shoppingCartOfUser = shoppingCartDao.getByUserId(userId);
            if(shoppingCartOfUser == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CART IS EMPTY");
            }
            return new ResponseEntity<>(shoppingCartOfUser, HttpStatus.OK);
        }

    //WORKS
    // add a POST method to add a product to the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be added
    @PostMapping("/products/{id}")
    public ResponseEntity<ShoppingCart> addProduct(Principal principal, @PathVariable int id) {

        String userName = principal.getName();
        User user = userDao.getByUserName(userName);
        int userId = user.getId();

        var productAdded = shoppingCartDao.addItemToCart(userId, id);
        return new ResponseEntity<>(productAdded, HttpStatus.CREATED);
    }
    //WORKS
    // add a PUT method to update an existing product in the cart - the url should be
    @PutMapping("/products/{id}")
    // https://localhost:8080/cart/products/15 (15 is the productId to be updated)
    // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated
    public ResponseEntity<ShoppingCart> updateQuantity(Principal principal, @RequestBody ShoppingCartItem item, @PathVariable int id){
        String userName = principal.getName();
        User user = userDao.getByUserName(userName);
        int userId = user.getId();

        var updatedProduct = shoppingCartDao.updateItemQuantity(userId,id,item);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    //WORKS
    // add a DELETE method to clear all products from the current users cart
    // https://localhost:8080/cart
    @DeleteMapping
    public void deleteProducts(Principal principal){
        String userName = principal.getName();
        User user = userDao.getByUserName(userName);
        int userId = user.getId();

        shoppingCartDao.deleteShoppingCart(userId);

    }
}
