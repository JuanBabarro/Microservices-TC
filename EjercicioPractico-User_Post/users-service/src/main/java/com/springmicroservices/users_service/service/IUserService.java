package com.springmicroservices.users_service.service;

import com.springmicroservices.users_service.dto.UserDTO;

public interface IUserService {

    public UserDTO getUserAndPosts(Long user_id);


}
