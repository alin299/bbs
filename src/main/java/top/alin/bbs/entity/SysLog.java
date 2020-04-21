package top.alin.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("syslog")
public class SysLog  extends Base{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String username;
    private String ip;
    private String uri;
    private String method;
}
