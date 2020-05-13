package top.alin.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.alin.bbs.entity.ResultInfo;
import top.alin.bbs.entity.User;
import top.alin.bbs.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultInfo login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session
    ) {
        //返回的结果
        ResultInfo info = new ResultInfo();
        //查找用户
        User user = userService.findByName(username);
        String name = user.getUsername();
        String pwd = user.getPassword();
        //判断账号密码是否正确
        if(name.equals(username)&&pwd.equals(password)){
            //将登录的用户存入session中
            session.setAttribute("loginUser",username);
            info.setFlag(true);
            return info;
        }else{
            info.setFlag(false);
            return info;
        }
    }
}
