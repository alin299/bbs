package top.alin.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(resultMap = "commentMap")
public class Comment extends Base{

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer postId;
    private String content;
    private Integer userId;
    private Integer toUserId;
    private Integer fatherCommentId;
}
