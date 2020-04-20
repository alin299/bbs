package top.alin.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;

@Data
@TableName(resultMap = "postMap")
public class Post extends Base{

    @TableId(type=IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private List<Comment> commentList;
}
