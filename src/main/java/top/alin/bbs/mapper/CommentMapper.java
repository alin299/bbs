package top.alin.bbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.alin.bbs.entity.Comment;

import java.util.List;


@Repository
@Mapper
public interface CommentMapper  extends BaseMapper<Comment> {
    List<Comment> selectAllByMap();
}
