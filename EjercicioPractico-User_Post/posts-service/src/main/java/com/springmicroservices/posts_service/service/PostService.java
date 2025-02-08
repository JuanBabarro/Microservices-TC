package com.springmicroservices.posts_service.service;

import com.springmicroservices.posts_service.model.Post;
import com.springmicroservices.posts_service.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{

    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<Post> getPostsByUser(Long id) {
        return postRepository.findPostByUserId(id);
    }
}
