package top.alin.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.alin.bbs.entity.ResultInfo;
import top.alin.bbs.service.UserService;

@Controller

public class LoginController {
    @Autowired
    private UserService userService;

    ResultInfo info = new ResultInfo();

    @RequestMapping("user/login")
    public ResultInfo login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            info.setFlag(true);

            return info;
        }else{
            info.setFlag(false);
            //info.setErrorMsg("用户名或密码错误");

            return info;
        }
    }


}
