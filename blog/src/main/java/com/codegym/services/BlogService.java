package com.codegym.services;

import com.codegym.models.Blog;
import com.codegym.repositories.IBlogRepository;

import java.util.List;

public class BlogService implements IBlogService {
    public BlogService(IBlogRepository blogRepository) {

    }

    @Override
    public List<Blog> getAllBlog() {
        return null;
    }

    @Override
    public Blog addBlog(Blog blog) {
        return null;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return null;
    }
}
