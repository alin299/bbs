package top.alin.bbs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.alin.bbs.utils.Result;
import top.alin.bbs.utils.ResultCode;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Result handleCustomException(RuntimeException e) {
        Result result = new Result();
        if (e instanceof ServiceException) {
            result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
        } else {
            // TODO 完善其他异常
            result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("服务器竟然出错了");
            e.printStackTrace();
        }
        return result;
    }
}
