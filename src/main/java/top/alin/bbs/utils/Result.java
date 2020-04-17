package top.alin.bbs.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 响应结果封装
 * @author alin
 */

@Data
@Accessors(chain = true)  // 链式
public class Result {
    private int code;
    private String message;
    private Object data;
    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }
}
