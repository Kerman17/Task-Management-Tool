package com.raul.Collaborative_Task_Management_Tool.dao.impl;

import com.raul.Collaborative_Task_Management_Tool.dao.CommentDao;
import com.raul.Collaborative_Task_Management_Tool.domain.Comment;
import com.raul.Collaborative_Task_Management_Tool.repositories.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentDaoImpl implements CommentDao {

    private final CommentRepository commentRepository;

    public CommentDaoImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment saveComment(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }
}
