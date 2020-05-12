package top.alin.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.alin.bbs.entity.User;
import top.alin.bbs.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @GetMapping("/add")
    public void add(User user){
        userService.add(user);
    }

    //查询所有用户
    @GetMapping("/selectUserList")
    public List<User> selectUserList(){
        List<User> userList = userService.selectUserList();
        return userList;
    }



}
