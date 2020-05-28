package top.alin.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class Role extends Base{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String roleName;
    private String roleDesc;

    @TableField(exist = false)
    private List<User> users;
}
