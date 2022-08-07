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

    private boolean checkLikeComment(User user, Comment comment, Iterable<LikeComment> likeComments) {
        for (LikeComment i: likeComments) {
            if (i.getComment() == comment && i.getUserLike() == user && i.getId()==null) {
                return false;
            }
        }
        return true;
    }

//    @PostMapping("")
//    public ResponseEntity<LikeComment> likeStatus(@RequestParam Long idComment, @RequestParam Long idUser) {
//        LikeComment likeComment = new LikeComment();
//        Comment comment = commentService.findById(idComment).get();
//        User userOptional = userService.findById(idUser).get();
//        LikeComment likeComments = likeCommentService.findByUserLikeIdAndAndCommentId(userOptional.getId(), comment.getId());
//        if (checkLikeComment(userOptional, comment, likeCommentService.findAll())) {
//            if (likeComments == null) {
//                likeComment.setUserLike(userOptional);
//                likeComment.setComment(comment);
//                likeCommentService.save(likeComment);
//            } else {
//                likeCommentService.delete(likeComments.getId());
//            }
//        }
//        return new ResponseEntity<>(likeComment, HttpStatus.OK);
//    }
}
