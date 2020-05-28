package top.alin.bbs.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class User extends Base{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;

    //该属性是user表中不存在的，但是又要用到的
    @TableField(exist = false)
    private List<Role> roles;
}
