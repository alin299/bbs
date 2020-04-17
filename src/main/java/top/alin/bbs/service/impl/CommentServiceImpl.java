package top.alin.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.alin.bbs.entity.Comment;
import top.alin.bbs.mapper.CommentMapper;
import top.alin.bbs.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int save(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int update(Comment comment) {
        return commentMapper.updateById(comment);
    }

    @Override
    public int delete(Integer id) {
        return commentMapper.deleteById(id);
    }

    @Override
    public Comment findById(Integer id) {
        return commentMapper.selectById(id);
    }
}
