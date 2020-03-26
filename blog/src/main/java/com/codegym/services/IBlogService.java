package com.codegym.services;

import com.codegym.models.Blog;

import java.util.List;

public interface IBlogService {
    public List<Blog> getAllBlog();
    public Blog addBlog( Blog blog);
    public Blog updateBlog(Blog blog);
}
