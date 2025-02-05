package com.raul.Collaborative_Task_Management_Tool.dao;

import com.raul.Collaborative_Task_Management_Tool.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDao {
    List<Comment> getAllComments();
    Optional<Comment> getCommentById(Long id);
    void deleteCommentById(Long id);

    Comment saveComment(Comment comment);
}
