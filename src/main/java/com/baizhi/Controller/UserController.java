package com.baizhi.Controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 用户测试模块
 * 1.用户登录
 * 2.用户注册
 * 3.用户修改信息
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录方法
     */
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User userLogin = userService.findUser(user.getPhone());
        //判断账号是否正确
        if(userLogin != null){
            //MD5加密
            String s = DigestUtils.md5Hex(user.getPassword());
            //判断密码是否正确
            if(s.equals(userLogin.getPassword())){
                session.setAttribute("userLogin",userLogin);
                return "redirect:/User/uus.jsp";
            }else{
                return "redirect:/User/login.jsp";
            }
        }else{
            return "redirect:/User/login.jsp";
        }
    }

    /**
     * 用户注册方法
     */
    @RequestMapping("/register")
    public String register(User user, MultipartFile imgs, HttpServletRequest request) throws IOException {
        //获取存放文件的路径
        String realPath = request.getSession().getServletContext().getRealPath("/User/img");
        //获取文件名
        String originalFilename = imgs.getOriginalFilename();
        //上传文件
        imgs.transferTo(new File(realPath,originalFilename));
        //使用MD5对用户密码进行加密
        String s = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(s);

        user.setImg("../User/img/"+originalFilename);
        userService.register(user);
        return "redirect:/User/login.jsp";
    }

    /**
     * 修改用户信息
     *
     * 先查询出此用户的信息  进行自动填充
     * 然后修改
     */
    @RequestMapping("/findone")
    @ResponseBody
    public User findOne(String id){
        return userService.findOne(id);
    }
    @RequestMapping("/update")
    public String update(User user,HttpSession session){
        //使用MD5对密码进行加密
        String s = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(s);
        userService.update(user);
        session.setAttribute("userLogin",null);
        return "redirect:/User/login.jsp";
    }
}
