package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.domain.Comment;
import com.raul.Collaborative_Task_Management_Tool.domain.Task;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.CommentRepository;
import com.raul.Collaborative_Task_Management_Tool.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;


    @Autowired
    public CommentService(CommentRepository commentRepository, TaskRepository taskRepository) {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id){
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + id + " does not exist"));

    }

    public void addNewComment(Comment comment){
        commentRepository.save(comment);
    }

    public void deleteCommentById(Long id){

        commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + id + " does not exist"));

        commentRepository.deleteById(id);

    }

    @Transactional
    public void updateComment(Long comment_id,
                              Long task_id,
                              String comment_text,
                              String commented_by){

        Comment comment = commentRepository.findById(comment_id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + comment_id + " does not exist"));

        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id: " + task_id + " does not exist"));


        if(comment_text!=null && comment_text.length()>0 &&
           commented_by!=null && commented_by.length()>0){
            comment.setComment_text(comment_text);
            comment.setCommented_by(commented_by);
        }

    }


}
