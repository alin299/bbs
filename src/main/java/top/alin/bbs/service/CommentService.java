package top.alin.bbs.service;

import top.alin.bbs.entity.Comment;

public interface CommentService {
    int save(Comment Comment);

    int update(Comment Comment);

    int delete(Integer id);

    Comment findById(Integer id);
}
