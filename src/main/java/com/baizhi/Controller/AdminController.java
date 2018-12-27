package com.baizhi.Controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.ValidateImageCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * 后台管理员相关
 * 1.管理员登录
 * 2.修改管理员密码
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String adminLogin(Admin admin, HttpSession session,String code,boolean rememberMe){

        //获取验证码   判断验证码是否正确
        String vcs = (String) session.getAttribute("code");
        if(vcs.equals(code)){

            //调用业务方法 查询出当前对象
            Admin admin1 = adminService.findAdmin(admin.getUsername());
            try {
                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(admin.getUsername(),admin.getPassword(),rememberMe));

            } catch(UnknownAccountException uae){
                return "redirect:/login.jsp?xx=usernameError";
            }catch(IncorrectCredentialsException ice){
                return "redirect:/login.jsp?xx=passwordError";
            }
            catch (AuthenticationException e) {
                //e.printStackTrace();
                return "redirect:/login.jsp?xx=allError";
            }
            session.setAttribute("login",admin1);
            return "redirect:/main/main.jsp";
        }else{
            return "redirect:/login.jsp?xx=coodError";
        }
    }

    //使用cookie登录 欢迎用户
    @RequestMapping("/welcome")
    public void welcome(String username,HttpSession session){
        Admin admin1 = adminService.findCookieAdmin(username);
        session.setAttribute("login",admin1);
    }


    @RequestMapping("/captcha")
    //验证码
    public String captcha(HttpSession session, HttpServletResponse response) throws Exception{
        //获取验证码随机数
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //将securityCode存入session作用域
        session.setAttribute("code", securityCode);
//			ValueStack vs = ActionContext.getContext().getValueStack();
//			vs.setValue("#session.code", securityCode);
        //创建验证码图片，参数为securityCode
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
//			//将验证码图片通过输出流响应到客户端，先获取response，再获取输出流
//			HttpServletResponse response = ServletActionContext.getResponse();
//			ServletOutputStream out = response.getOutputStream();
        ServletOutputStream out = response.getOutputStream();
        //调用神奇方法
        /**
         * 第一个参数： 验证码图片对象
         * 第二个参数： 图片的格式
         * 第三个参数： 输出字节流
         */
        ImageIO.write(image, "png", out);
        return null;
    }

    @RequestMapping("/update")
    public String update(Admin admin,HttpSession session){
        adminService.modifyPassword(admin);
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/logout")
    public String logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/login.jsp";
    }
}
