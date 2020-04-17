package top.alin.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.alin.bbs.entity.User;
import top.alin.bbs.mapper.UserMapper;
import top.alin.bbs.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }


    @PostMapping("/register")
    public String register(User user, Model model) {
        if (!userService.save(user)) {
            model.addAttribute("msg", "该用户名已被注册");
            return "register";
        }
        model.addAttribute("msg", "注册成功");
        return "login";
    }

    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

}
