package com.springmicroservices.users_service.service;

import com.netflix.discovery.converters.Auto;
import com.springmicroservices.users_service.dto.PostDTO;
import com.springmicroservices.users_service.dto.UserDTO;
import com.springmicroservices.users_service.model.User;
import com.springmicroservices.users_service.repository.IPostAPI;
import com.springmicroservices.users_service.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    IUsersRepository usersRepository;

    @Autowired
    IPostAPI postAPI;

    @Override
    public UserDTO getUserAndPosts(Long user_id) {

        //Paso 1: Busco el usuario en la BD
        User user = usersRepository.findById(user_id).orElse(null);

        //Paso 2: Busco los posteos del User desde la IPostAPI
        List<PostDTO> postsList = postAPI.getPostsByUserId(user_id);

        //Paso 3: Uno el user y el postList en un UserDTO
        UserDTO userDTO = new UserDTO(user.getUser_id(), user.getName(), user.getLastname(), user.getCellphone(), postsList);

        return userDTO;
    }
}
