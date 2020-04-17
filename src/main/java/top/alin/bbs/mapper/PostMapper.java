package top.alin.bbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.alin.bbs.entity.Post;
import top.alin.bbs.entity.User;

import java.util.List;

@Repository
@Mapper
public interface PostMapper  extends BaseMapper<Post> {
}
