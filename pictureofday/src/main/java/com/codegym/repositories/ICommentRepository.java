package com.codegym.repositories;

import com.codegym.models.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> getAllComment();
}
