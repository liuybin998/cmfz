package com.baizhi.Controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 管理员后台专辑相关
 * 1.查询所有的专辑和章节信息
 * 2.添加专辑
 * 3.展示专辑详情
 * 4.删除专辑 以及专辑下的章节
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    //注入Service
    @Autowired
    private AlbumService albumService;

    /**
     * 查询所有章节和专辑
     * 调用底层实现 将数据以json格式传递给 页面
     */
    @RequestMapping("/findAlbum")
    @ResponseBody
    public List<Album> findAlbum(){
        return albumService.findAlbum();
    }
    /**
     * 添加专辑
     * 需要上传专辑的封面
     *  获取到文件的 名字 作为 album中的img相关信息 存入album
     *  此时因为是刚添加的专辑 这里专辑集数 默认填充为 0 （在添加专辑 和 删除专辑后  数据会有相应的改变）
     *  调用方法 添加到数据库中
     */
    @RequestMapping("/addAlbum")
    public void addAlbum(Album album, MultipartFile Album, HttpServletRequest request) throws IOException {
        //获取存放文件的路径
        String realPath = request.getSession().getServletContext().getRealPath("/album/img");
        System.out.println(realPath);
        //获取文件名
        String originalFilename = Album.getOriginalFilename();
        //上传文件
        Album.transferTo(new File(realPath,originalFilename));

        album.setCount(0);
        album.setImg("/"+originalFilename);
        albumService.addAlbum(album);
    }
    /**
     * 展示专辑详细信息
     * 从前台接收到 专辑的id 作为参数
     * 传递到控制器  控制器调用业务 业务调用底层实现
     * 查询出数据   以json形式返回 并进行自动填充 展示
     */
    @RequestMapping("/findOneAlbum")
    @ResponseBody
    public Album findOneAlbum(String id, Model model){
        Album oneAibum = albumService.findOneAibum(id);
        //System.out.println(oneAibum.getImg());
        model.addAttribute("img",oneAibum.getImg());
        return oneAibum;
    }
    /**
     * 删除专辑 以及专辑下的章节
     *
     * 根据传递过来的id作为参数
     * 首先将章节中 aid 为此专辑id的数据删除
     * 然后再根据此id 对专辑进行删除
     */
    @RequestMapping("/deleteAlbum")
    public void deleteAlbum(String id){
        System.out.println(id);
        albumService.removeAlbum(id);
    }

}
