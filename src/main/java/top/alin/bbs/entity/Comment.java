package top.alin.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(resultMap = "commentMap")
public class Comment extends Base{

    private Integer id;
    private Integer postId;
    private String content;
    private Integer userId;
    private Integer toUserId;
    private Integer fatherCommentId;
}
