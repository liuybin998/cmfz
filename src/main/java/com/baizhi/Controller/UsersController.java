
package com.baizhi.Controller;

import com.baizhi.entity.User;
import com.baizhi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员后台管理用户信息
 * 1.查询所有用户
 * 2.修改用户状态
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 管理员后台 查询所有用户 并做分页处理
     * 从前台会传递过来当前页数和 页面展示条数
     * 以这两个数据作为参数进行到进行查询
     * 并以json个数展示（必须是map格式的）
     * 点击下一页后 在此触发 将新的信息传递过来
     * 查询并展示
     */
    @RequestMapping("/findAllUser")
    @ResponseBody
    private Map<String,Object> findAllUser(Integer page, Integer rows){
        Map<String, Object> result = new HashMap<>();
        List<User> allUser = usersService.findAllUser((page * rows) - rows, rows);
        Integer findcount = usersService.findcount();
        result.put("rows",allUser);
        result.put("total",findcount);
        return result;
    }


    /**
     * 管理员后台 修改用户状态
     *
     * 1.查询单个信息后将数据返回 并自动填充到表格进行展示
     * 2.点击页面开关的时候 对其状态进行修改
     */
    @RequestMapping("/findOneUser")
    @ResponseBody
    public User findOneUser(String id){
        return usersService.findOneUser(id);
    }
    @RequestMapping("/updates")
    public void updateS(User user){
        if(user.getStatus() == null){
            user.setStatus("冻结");
        }
        usersService.modifyUser(user);
    }
}

