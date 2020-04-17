package top.alin.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.alin.bbs.entity.Post;
import top.alin.bbs.mapper.PostMapper;
import top.alin.bbs.service.PostService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public int save(Post post) {
        return postMapper.insert(post);
    }

    @Override
    public int update(Post post) {
        return postMapper.updateById(post);
    }

    @Override
    public int delete(Integer id) {
        return postMapper.deleteById(id);
    }

    @Override
    public Post findById(Integer id) {
        return postMapper.selectById(id);
    }

    @Override
    public List<Post> selectAll(Map map) {
        return postMapper.selectByMap(map);
    }

    @Override
    public Page<Post> selectAll(Integer page, Integer size) {
        Page<Post> postPage = new Page<>(page, size);
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return postMapper.selectPage(postPage, wrapper);
    }
}
