package com.springmicroservices.users_service.controller;

import com.springmicroservices.users_service.dto.UserDTO;
import com.springmicroservices.users_service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/posts/{user_id}") //Este endPoint tiene que ser igual al definido en el microservicio post_service en su Controller
    public UserDTO getUserAndPosts (@PathVariable ("user_id") Long user_id){
        return userService.getUserAndPosts(user_id);
    }

}
