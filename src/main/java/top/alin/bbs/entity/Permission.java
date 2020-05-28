package top.alin.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Permission extends Base{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String permissionName;
    private String permissionUrl;
    private int parentId;
}
