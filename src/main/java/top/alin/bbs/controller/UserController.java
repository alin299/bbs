package top.alin.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.alin.bbs.entity.User;
import top.alin.bbs.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/save")
    public String toSave() {
        return "admin/list";
    }

    @PostMapping("/save")
    public void save(@RequestParam("username") String username,
                     @RequestParam("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.save(user);
    }

    //查询所有用户
    @RequestMapping("/list")
    public String userList(Model model){
        List<User> userList = userService.selectUserList();
        model.addAttribute("userList",userList);
        return "admin/list";
    }



}
