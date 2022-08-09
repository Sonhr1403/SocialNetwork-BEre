package com.example.socialnetworkbe.controller;

import com.example.socialnetworkbe.model.*;
import com.example.socialnetworkbe.service.CommentService;
import com.example.socialnetworkbe.service.impl.CommentServiceImpl;
import com.example.socialnetworkbe.service.impl.LikeCommentServiceImpl;
import com.example.socialnetworkbe.service.impl.LikeStatusServiceImpl;
import com.example.socialnetworkbe.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/like-comments")
public class LikeCommentController {

   @Autowired
   LikeCommentServiceImpl likeCommentService;

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("")
    public ResponseEntity<LikeComment> likeStatus(@RequestParam Long idComment, @RequestParam Long idUser) {
        LikeComment likeComment = new LikeComment();
        Comment comment = commentService.findById(idComment).get();
        User userOptional = userService.findById(idUser).get();
        LikeComment likeComments = likeCommentService.findByUserLikeIdAndAndCommentId(userOptional.getId(), comment.getId());
        if (likeComments == null) {
            likeComment.setUserLike(userOptional);
            likeComment.setComment(comment);
            likeCommentService.save(likeComment);
        } else {
            likeCommentService.delete(likeComments.getId());
        }
        return new ResponseEntity<>(likeComment, HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity check(@RequestParam Long idComment, @RequestParam Long idUser) {
        Comment comment = commentService.findById(idComment).get();
        User userOptional = userService.findById(idUser).get();
        LikeComment likeComments = likeCommentService.findByUserLikeIdAndAndCommentId(userOptional.getId(), comment.getId());
        if (likeComments == null) {
            return new ResponseEntity(false, HttpStatus.OK);
        } else
            return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
