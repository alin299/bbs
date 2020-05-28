package top.alin.bbs.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.alin.bbs.entity.Role;
import top.alin.bbs.entity.User;

import java.util.List;

@Mapper
@Repository
public interface UserRoleMapper {

    List<Role> findRolesByUserName(String username);

    User findUserByUsername(String username);

    void save(int user_id, int role_id);
}
