package top.alin.bbs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.alin.bbs.entity.Role;
import top.alin.bbs.entity.User;
import top.alin.bbs.service.RoleService;
import top.alin.bbs.service.UserService;
import top.alin.bbs.utils.Result;
import top.alin.bbs.utils.ResultGenerator;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/save")
    public String toSave() {
        return "role/list";
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestParam("rolename") String rolename,
                       @RequestParam("roledesc") String roledesc){
        Role role = new Role();
        role.setRoleName(rolename);
        role.setRoleDesc(roledesc);
        boolean isSave = roleService.save(role);
        if (isSave){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("角色名称已存在！");
        }
    }

    @GetMapping("/edit")
    public String toEdit() {
        return "role/list";
    }

    @PostMapping("/edit")
    @ResponseBody
    public Result edit(@RequestParam("id") Long id,
                       @RequestParam("rolename") String rolename,
                       @RequestParam("roledesc") String roledesc){
        Role role = roleService.findRoleById(id);
        role.setRoleName(rolename);
        role.setRoleDesc(roledesc);
        boolean isEdit = roleService.edit(role);
        if (isEdit){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("角色名称已存在！");
        }

    }

    @GetMapping("/findRoleById")
    @ResponseBody
    public Role findUserById(@RequestParam("id") Long id){
        Role role = roleService.findRoleById(id);
        return role;
    }

    @GetMapping("/del")
    public String toDel() {
        return "role/list";
    }

    @PostMapping("/del")
    @ResponseBody
    public Result del(@RequestParam("id") Long id){
        boolean isDel = roleService.del(id);
        if (isDel){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("删除失败！");
        }
    }

    @GetMapping("/delSelected")
    public String toDelSelected() {
        return "role/list";
    }

    @PostMapping("/delSelected")
    @ResponseBody
    public Result delSelected(@RequestParam("id") Long[] ids){
        boolean isDel = roleService.delSelected(ids);
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
        IPage<Role> page = roleService.selectByPage(pn, 5);
        //此处得到的page对象,包含了current（当前页）,pages（总页数），total（总记录数），records（记录，就是查询到的List集合）
        model.addAttribute("page", page);
        model.addAttribute("jumpUrl", "/role/view?pn=");
        return "role/list";
    }
    @RequestMapping("/search")
    public String searchsubmit(String rolename, Model model,
                               @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn) {
        IPage<Role> page = roleService.searchByPage(pn, 5, rolename);
        model.addAttribute("jumpUrl", "/role/search?rolename="+rolename+"&pn=");
        model.addAttribute("page", page);
        model.addAttribute("searchArea",rolename);
        return "role/list";
    }
}
