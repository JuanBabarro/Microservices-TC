package com.springmicroservices.posts_service.service;

import com.springmicroservices.posts_service.model.Post;

import java.util.List;

public interface IPostService {

    public List<Post> getPostsByUser(Long id);
}
