package top.alin.bbs.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.alin.bbs.entity.Post;
import top.alin.bbs.service.PostService;
import top.alin.bbs.utils.Result;
import top.alin.bbs.utils.ResultGenerator;

import java.util.List;

@Controller
@Slf4j
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public String addPost(Post post) {
        postService.save(post);
        return "redirect:/post";
    }

    @PostMapping("/edit")
    public void editPost(Post post) {
        postService.update(post);
    }

    @GetMapping("/post/{id}")
    private String getPost(@PathVariable("id") Integer id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            return "error/404";
        }
        model.addAttribute("post", post);
        return "view/post/show";
    }

    @GetMapping("/post")
    private String getPostList(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer size,
                               Model model) {
        Page<Post> pagination = postService.selectAll(page,size);
        model.addAttribute("pagination", pagination);
        return "view/post/list";
    }

    @DeleteMapping("/post/{id}")
    @ResponseBody
    private Result deletePost(@PathVariable("id") Integer id, Model model) {
        postService.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
