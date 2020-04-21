package top.alin.bbs.service;

import top.alin.bbs.entity.Comment;

public interface CommentService {
    int save(Comment comment);

    int update(Comment comment);

    int delete(Integer id);

    Comment findById(Integer id);
}
