package com.codegym.repositories;

import com.codegym.models.Blog;

import java.util.List;

public interface IBlogRepository {
    public List<Blog> getAllBlog();
    public Blog addBlog( Blog blog);
    public void updateBlog(Blog blog);
    public void remoteBlog(Blog blog);
}
