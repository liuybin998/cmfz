package com.baizhi.Controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
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
 * 轮播图相关控制器
 * 1.展示所有轮播图
 * 2.删除
 * 3.修改
 * 4.添加
 * 5.以用户视角 查看状态为展示的 轮播图
 */
@Controller
@RequestMapping("/carousel")
public class CarouselController {
    //注入service
    @Autowired
    private CarouselService carouselService;

    /**
     * 展示所有轮播图
     */
    @RequestMapping("/findallcarousel")
    @ResponseBody
    public Map<String,Object> findAllCarousel(Integer page, Integer rows){
        Map<String, Object> result = new HashMap<>();
        long findcount = carouselService.findcount();
        List<Carousel> allCarousel = carouselService.findAllCarousel((page*rows)-rows, rows);
        result.put("rows",allCarousel);
        result.put("total",findcount);
        return result;
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void deletes(String id){
        carouselService.removeCarousel(id);
    }
    /**
     * 修改
     * 先根据id查对应项的信息 自动填充到页面
     * 然后根据此id修改
     */
    @RequestMapping("/showid")
    @ResponseBody
    public Carousel showid(String id){
        return carouselService.findid(id);
    }
    @RequestMapping("/update")
    public void update(Carousel carousel){
        if(carousel.getStatus() == null){
            carousel.setStatus("不展示");
        }
        carouselService.modifyCarousel(carousel);
    }
    /**
     * 添加（上传）
     * 上传轮播图的同时   将轮播图的信息添加到数据库
     */
    @RequestMapping("/addcarousel")
    public void add(Carousel carousel, MultipartFile aa, HttpServletRequest request)throws Exception{
        //判断 状态是否为空
        if(carousel.getStatus() == null){
            carousel.setStatus("不展示");
        }
        //获取存放文件的路径
        String realPath = request.getSession().getServletContext().getRealPath("/Carousel");
        //获取文件名
        String originalFilename = aa.getOriginalFilename();
        //上传文件
        aa.transferTo(new File(realPath,originalFilename));
        carousel.setUrl("/cmfz_lyb/Carousel/"+originalFilename);
        carouselService.addCarousel(carousel);
    }
    /**
     * 用户视角
     * 查看轮播图
     */
    @RequestMapping("/findimg")
    @ResponseBody
    public List<Carousel> findimg(){
        return carouselService.findimg();
    }
}
