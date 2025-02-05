package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.dao.CommentDao;
import com.raul.Collaborative_Task_Management_Tool.dao.TaskDao;
import com.raul.Collaborative_Task_Management_Tool.domain.Comment;
import com.raul.Collaborative_Task_Management_Tool.domain.Task;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentDao commentDao;
    private final TaskDao taskDao;



    @Autowired
    public CommentService(CommentDao commentDao, TaskDao taskDao) {
        this.commentDao = commentDao;
        this.taskDao = taskDao;
    }


    // ENDPOINTS FOR COMMENT - TASK RELATIONSHIP vvv

    public Comment addCommentToTask(Comment comment,
                                    Long taskId){
        Task task = taskDao.findTaskById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + taskId + " does not exist"));

        comment.setTask(task);

        return commentDao.saveComment(comment);
    }

    // ENDPOINTS FOR COMMENT - TASK RELATIONSHIP ^^^


    public List<Comment> getAllComments(){
        return commentDao.getAllComments();
    }

    public Comment getCommentById(Long id){
        return commentDao.getCommentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + id + " does not exist"));

    }

    public void addNewComment(Comment comment){
        commentDao.saveComment(comment);
    }

    public void deleteCommentById(Long id){

        commentDao.getCommentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + id + " does not exist"));

        commentDao.deleteCommentById(id);

    }

    @Transactional
    public void updateComment(Long comment_id,
                              Long task_id,
                              String comment_text,
                              String commented_by){

        Comment comment = commentDao.getCommentById(comment_id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + comment_id + " does not exist"));

        Task task = taskDao.findTaskById(task_id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id: " + task_id + " does not exist"));


        if(comment_text!=null && comment_text.length()>0 &&
           commented_by!=null && commented_by.length()>0){
            comment.setComment_text(comment_text);
            comment.setCommented_by(commented_by);
        }

    }


}
