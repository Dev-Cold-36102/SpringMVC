package com.codegym.services;

import com.codegym.models.Comment;
import com.codegym.repositories.ICommentRepository;

import java.util.List;

public class CommentService implements ICommentService {


    public CommentService(ICommentRepository commentRepository) {
    }

    @Override
    public List<Comment> getAllComment() {
        return null;
    }
}
