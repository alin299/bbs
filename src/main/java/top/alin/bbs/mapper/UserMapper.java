package top.alin.bbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.alin.bbs.entity.User;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
