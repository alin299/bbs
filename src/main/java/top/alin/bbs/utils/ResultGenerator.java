package top.alin.bbs.utils;

/**
 * 响应结果生成
 * @author alin
 */

public class ResultGenerator {
    // 默认消息
    private static final String DEFAULT_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS).setMessage("sdfsdf");
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
