package top.alin.bbs.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.alin.bbs.constants.Constants;
import top.alin.bbs.entity.Post;
import top.alin.bbs.service.PostService;
import top.alin.bbs.utils.Result;
import top.alin.bbs.utils.ResultGenerator;
import top.alin.bbs.exception.ServiceException;


@Slf4j
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping()
    public Result addPost(@RequestBody Post post) {
        postService.save(post);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping()
    public Result editPost(@RequestBody Post post) {
        postService.update(post);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    private Result getPost(@PathVariable("id") Integer id) {
        Post post = postService.findById(id);
        if (post == null) {
            throw new ServiceException("post不存在");
        }
        return ResultGenerator.genSuccessResult(post);
    }

    @GetMapping()
    private Result getPostList(@RequestParam(defaultValue = Constants.DEFAULT_PAGE) Integer page,
                               @RequestParam(defaultValue = Constants.DEFAULT_PAGE_SIZE) Integer size) {
        Page<Post> pagination = postService.selectAll(page,size);
        return ResultGenerator.genSuccessResult(pagination);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    private Result deletePost(@PathVariable("id") Integer id) {
        postService.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
