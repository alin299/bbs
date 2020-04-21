package top.alin.bbs.utils.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.alin.bbs.entity.SysLog;
import top.alin.bbs.service.SysLogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 日志切面
 */
@Component
@Aspect
@Slf4j
public class LogAop {

    @Autowired
    private SysLogService sysLogService;

    ThreadLocal<Long> time = new ThreadLocal<>();

    // 定义切点
//    @Pointcut("@annotation(cn.magicwindow.mlink.content.annotation.Timer)")
    @Pointcut("execution(* top.alin.bbs.controller..*.*(..))")
    public void controllerLog(){

    }

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint){
        log.info("doBefore");
        time.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        SysLog sysLog = new SysLog();
        sysLog.setUri(request.getRequestURI());
        sysLog.setIp(request.getRemoteAddr());
        sysLog.setMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // TODO 记录操作用户
        // sysLog.setUsername();
        log.info(request.getRequestURI());
        sysLogService.save(sysLog);
    }

    @AfterReturning("controllerLog()")
    public void doAfterRetuing() {
        log.info("doAfterRetuing");
        log.info(String.format("耗时：%s ms", System.currentTimeMillis() - time.get()));
    }


}
