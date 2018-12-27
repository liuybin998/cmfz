package com.baizhi.Controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 上师模块
 * 1.查询所有
 * 2.删除
 * 3.添加上师
 * 4.编辑上师信息
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    //查询所有
    @RequestMapping("/findAllGuru")
    @ResponseBody
    public Map<String,Object> findallGuru(Integer page, Integer rows){
        Map<String, Object> result = new HashMap<>();

        List<Guru> addGuru = guruService.findAddGuru((page*rows)-rows, rows);
        Integer findcount = guruService.findcount();
        result.put("rows",addGuru);
        result.put("total",findcount);
        return result;
    }

    //删除
    @RequestMapping("/deleteguru")
    public void deleteGuru(String id){
        guruService.removeGuru(id);
    }

    //添加
    @RequestMapping("/addGuru")
    public void addGuru(Guru guru,MultipartFile photos, HttpServletRequest request) throws Exception{
        if(guru.getState() == null){
            guru.setState("封禁");
        }
        if(guru.getGender() == null){
            guru.setGender("女");
        }
        //获取存放文件的路径
        String realPath = request.getSession().getServletContext().getRealPath("/Guru");
        //获取文件名
        String originalFilename = photos.getOriginalFilename();
        //上传文件
        photos.transferTo(new File(realPath,originalFilename));
        guru.setPhoto("/cmfz_lyb/Guru/"+originalFilename);
        guruService.addGuru(guru);
    }

    //修改
    @RequestMapping("/showOneGuru")
    @ResponseBody
    public Guru ShowOneGuru(String id){
        return guruService.findid(id);
    }
    @RequestMapping("/updateGuru")
    public void Upadatesad(Guru guru){
        if(guru.getState() == null){
            guru.setState("封禁");
        }
        if(guru.getGender() == null){
            guru.setGender("女");
        }
        guruService.modifyGuru(guru);
    }


}
