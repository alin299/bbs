package top.alin.bbs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.alin.bbs.entity.User;
import top.alin.bbs.mapper.UserRoleMapper;
import top.alin.bbs.service.UserService;
import top.alin.bbs.utils.Result;
import top.alin.bbs.utils.ResultGenerator;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    //加密对象
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/list")
    public String userList(Model model){
        List<User> userList = userService.selectUserList();
        model.addAttribute("userList",userList);
        return "user/list";
    }

    @GetMapping("/save")
    public String toSave() {
        return "user/list";
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("roleId") int roleId){
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        boolean isSave = userService.save(user);

        if (isSave){
            User userAdded = userService.findByName(username);
            Long userAddedId = userAdded.getId();
            int userId = userAddedId.intValue();
            userRoleMapper.save(userId,roleId);
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("用户名已存在！");
        }
    }

    @GetMapping("/edit")
    public String toEdit() {
        return "user/list";
    }

    @PostMapping("/edit")
    @ResponseBody
    public Result edit(@RequestParam("id") Long id,
                     @RequestParam("username") String username,
                     @RequestParam("password") String password){
        User user = userService.findUserById(id);
        user.setUsername(username);
        user.setPassword(password);
        boolean isEdit = userService.edit(user);
        if (isEdit){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("用户名已存在！");
        }

    }

    @GetMapping("/findUserById")
    @ResponseBody
    public User findUserById(@RequestParam("id") Long id){
        User user = userService.findUserById(id);
        return user;
    }

    @GetMapping("/del")
    public String toDel() {
        return "user/list";
    }

    @PostMapping("/del")
    @ResponseBody
    public Result del(@RequestParam("id") Long id){
        boolean isDel = userService.del(id);
        if (isDel){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("删除失败！");
        }
    }

    @GetMapping("/delSelected")
    public String toDelSelected() {
        return "user/list";
    }

    @PostMapping("/delSelected")
    @ResponseBody
    public Result delSelected(@RequestParam("id") Long[] ids){
        boolean isDel = userService.delSelected(ids);
        if (isDel){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("删除失败！");
        }
    }

    @RequestMapping("/view")
    //pn是每次传回来的当前页
    public String view(Model model,
                       @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn) {
        IPage<User> page = userService.selectByPage2(pn, 5);
        //此处得到的page对象,包含了current（当前页）,pages（总页数），total（总记录数），records（记录，就是查询到的List集合）
        model.addAttribute("page", page);
        model.addAttribute("jumpUrl", "/user/view?pn=");
        return "user/list";
    }

    @RequestMapping("/search")
    public String searchsubmit(String username, Model model,
                               @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn) {
        IPage<User> page = userService.searchByPage(pn, 5, username);
        model.addAttribute("jumpUrl", "/user/search?username="+username+"&pn=");
        model.addAttribute("page", page);
        model.addAttribute("searchArea",username);
        return "user/list";
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String toLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }



}
