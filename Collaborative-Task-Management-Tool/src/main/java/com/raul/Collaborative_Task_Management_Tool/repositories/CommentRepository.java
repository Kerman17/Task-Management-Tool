package com.raul.Collaborative_Task_Management_Tool.repositories;

import com.raul.Collaborative_Task_Management_Tool.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
