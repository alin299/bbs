package top.alin.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import top.alin.bbs.entity.Post;
import top.alin.bbs.entity.User;

import java.util.List;
import java.util.Map;

public interface PostService {
    int save(Post post);

    int update(Post post);

    int delete(Integer id);

    Post findById(Integer id);

    List<Post> selectAll(Map map);

    Page<Post> selectAll(Integer page, Integer size);
}
