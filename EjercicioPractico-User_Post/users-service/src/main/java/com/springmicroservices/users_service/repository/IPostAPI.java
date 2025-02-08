package com.springmicroservices.users_service.repository;

import com.springmicroservices.users_service.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="posts-service")
public interface IPostAPI {

    @GetMapping("/posts/{user_id}") //Este endPoint es el que está definido en el Controller de Post
    public List<PostDTO> getPostsByUserId(@PathVariable ("user_id") Long user_id);

}
