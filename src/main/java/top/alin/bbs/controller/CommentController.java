package top.alin.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.alin.bbs.entity.Comment;
import top.alin.bbs.entity.Post;
import top.alin.bbs.service.CommentService;
import top.alin.bbs.service.PostService;
import top.alin.bbs.utils.Result;
import top.alin.bbs.utils.ResultGenerator;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("")
    private Result addComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return ResultGenerator.genSuccessResult();
    }


}
