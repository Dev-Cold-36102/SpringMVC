package com.codegym.services;

import com.codegym.models.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllComment();
}
