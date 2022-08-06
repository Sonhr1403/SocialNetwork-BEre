package com.example.socialnetworkbe.controller;

import com.example.socialnetworkbe.model.LikeStatus;
import com.example.socialnetworkbe.model.Status;
import com.example.socialnetworkbe.model.User;
import com.example.socialnetworkbe.service.impl.LikeStatusServiceImpl;
import com.example.socialnetworkbe.service.impl.StatusServiceImpl;
import com.example.socialnetworkbe.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/like-statuses")
public class LikeStatusController {
    @Autowired
    LikeStatusServiceImpl likeStatusService;

    @Autowired
    StatusServiceImpl statusService;

    @Autowired
    UserServiceImpl userService;

    private boolean checkLikeStatus(User user, Status status, Iterable<LikeStatus> likeStatuses) {
        for (LikeStatus i : likeStatuses) {
            if (i.getStatus() == status && i.getUserLike() == user && i.getId()==null) {
                return false;
            }
        }
        return true;
    }

    @PostMapping("")
    public ResponseEntity<LikeStatus> likeStatus(@RequestParam Long idStatus, @RequestParam Long idUser) {
        LikeStatus likeStatus = new LikeStatus();
        Status status = statusService.findById(idStatus).get();
        User userOptional = userService.findById(idUser).get();
        LikeStatus likeStatuses = likeStatusService.findByUserLikeIdAndAndStatusId(userOptional.getId(), status.getId());
        if (checkLikeStatus(userOptional, status, likeStatusService.findAll())) {
            if (likeStatuses == null) {
                likeStatus.setUserLike(userOptional);
                likeStatus.setStatus(status);
                likeStatusService.save(likeStatus);
            } else {
                likeStatusService.delete(likeStatuses.getId());
            }
        }
        return new ResponseEntity<>(likeStatuses, HttpStatus.OK);
    }

}
