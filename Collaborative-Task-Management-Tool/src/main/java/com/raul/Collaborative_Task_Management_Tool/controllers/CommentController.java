package com.raul.Collaborative_Task_Management_Tool.controllers;

import com.raul.Collaborative_Task_Management_Tool.domain.Comment;
import com.raul.Collaborative_Task_Management_Tool.services.CommentService;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.getCommentById(commentId);
    }

    @PostMapping
    public void addNewComment(@RequestBody Comment comment){
        commentService.addNewComment(comment);
    }

    @DeleteMapping(path = "{commentId}")
    public void deleteCommentById(@PathVariable Long commentId){
        commentService.deleteCommentById(commentId);
    }

    @PutMapping(path = "{commentId}/{taskId}")
    public void updateComment(@PathVariable Long commentId,
                              @PathVariable Long taskId,
                              @RequestParam(required = false) String comment_text,
                              @RequestParam(required = false) String commented_by){

        commentService.updateComment(commentId, taskId, comment_text, commented_by);
    }


}
