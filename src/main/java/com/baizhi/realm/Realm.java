package com.baizhi.realm;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class Realm extends AuthenticatingRealm {
    @Autowired
    private AdminService adminService;
    /**
     * 获取认证信息方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //强制类型转换
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        //获取用户输入的用户名
        String username = usernamePasswordToken.getUsername();
        //根据username 从数据库中查询
        Admin admin = adminService.findAdmin(username);
        //进行判断
        if(admin.getUsername().equals(username)){
             return new SimpleAccount(admin.getUsername(),admin.getPassword(), UUID.randomUUID().toString());
        }
        return null;
    }
}
