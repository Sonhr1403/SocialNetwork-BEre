package com.example.socialnetworkbe.controller;

import com.example.socialnetworkbe.model.Comment;
import com.example.socialnetworkbe.model.Image;
import com.example.socialnetworkbe.model.Status;
import com.example.socialnetworkbe.service.CommentService;
import com.example.socialnetworkbe.service.LikeCommentService;
import com.example.socialnetworkbe.service.StatusService;
import com.example.socialnetworkbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    StatusService statusService;
    @Autowired
    LikeCommentService likeCommentService;

    @GetMapping
    public ResponseEntity<Iterable<Comment>> findAllComment() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment) {
        comment.setCreateAt(LocalDateTime.now());
        commentService.save(comment);
        return new ResponseEntity(commentService, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id) {
        return new ResponseEntity(commentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Comment> oldCommentsOptional = commentService.findById(id);
        if (!oldCommentsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setId(oldCommentsOptional.get().getId());
        comment.setCreateAt(oldCommentsOptional.get().getCreateAt());
        comment.setActive(oldCommentsOptional.get().getActive());
        comment.setUserComment(oldCommentsOptional.get().getUserComment());
        comment.setStatus(oldCommentsOptional.get().getStatus());
        comment.setComment(oldCommentsOptional.get().getComment());
        commentService.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping("/find-all-by-status")
    public ResponseEntity<ArrayList<?>> findAllByStatus(@RequestParam Long statusId) {
        ArrayList<Iterable> result = new ArrayList<>();
        Iterable<Comment> listComment = commentService.findAllByStatus(statusId);
        result.add(listComment);
        ArrayList<Integer> listNumberOfLike = new ArrayList<>();
        for (Comment comment : listComment) {
            Integer numberOfLike = likeCommentService.findNumberOfLikeCommentOfComment(comment.getId());
            if (numberOfLike == null) {
                numberOfLike = 0;
            }
            listNumberOfLike.add(numberOfLike);
        }
        result.add(listNumberOfLike);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> delete(@PathVariable Long id) {
        commentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
