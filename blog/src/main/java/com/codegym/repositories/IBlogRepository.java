package com.codegym.repositories;

import com.codegym.models.Blog;

import java.util.List;

public interface IBlogRepository {
    public List<Blog> getAllBlog();
    public Blog addBlog( Blog blog);
    public Blog updateBlog(Blog blog);
}
