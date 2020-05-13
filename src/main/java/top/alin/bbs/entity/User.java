package top.alin.bbs.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


@Data
public class User extends Base{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
}
