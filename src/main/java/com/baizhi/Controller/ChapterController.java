package com.baizhi.Controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 章节相关
 * 1.添加章节
 * 2.下载章节
 * 3.删除单个章节
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private AlbumService albumService;

    //添加章节
    @RequestMapping("/addChapter")
    public void addChapter(Chapter chapter, MultipartFile chap, HttpServletRequest request) throws IOException, EncoderException {
        //获取存放文件的路径
        String realPath = request.getSession().getServletContext().getRealPath("/album/voice");
        //获取文件名
        String originalFilename = chap.getOriginalFilename();
        //上传文件
        File file = new File(realPath, originalFilename);
        chap.transferTo(file);
        //将路径存入chapter
        chapter.setUrl(originalFilename);
        //获取章节大小   转换为string类型  并赋值给chapter
        long dx = chap.getSize();
        if(dx<1024){
            chapter.setSize(dx+"字节");
        }else if(dx<1024*1024){
            chapter.setSize(dx/1024+"KB");
        }else if(dx<1024*1024*1024){
            chapter.setSize(dx/1024/1024+"MB");
        }
        //专辑时长
        Encoder encoder = new Encoder();
        MultimediaInfo m = encoder.getInfo(file);
        long ls = m.getDuration()/1000;
        int minute = (int) (ls%3600)/60;
        String length = minute+"分";
        chapter.setTime(length);
        System.out.println(chapter);
        //添加到数据库
        chapterService.AddChapter(chapter);
        //根据接收到的父类id作为参数 查询出专辑表中 以此id作为父id的数据条数
        Integer count = chapterService.findCount(chapter.getAid());
        albumService.updateCount(chapter.getAid(),count);
    }
    /**
     * 下载
     */
    @RequestMapping("/download")
    public void download(String url, HttpServletResponse response, HttpServletRequest request) throws IOException {

        String realPath = request.getSession().getServletContext().getRealPath("/album/voice");//路径
        //文件输入流
        FileInputStream is = new FileInputStream(new File(realPath,url));
        //设置响应头
        response.setHeader("content-disposition", "attachment;filename="+url);
        //响应流
        ServletOutputStream os = response.getOutputStream();
        //下载
        IOUtils.copy(is, os);
        //关闭资源
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }
    /**
     * 删除单个章节
     *
     * 查询出当前专辑的信息 删除后 查询出有效数据条数 后 修改数据库中的信息
     */
    @RequestMapping("/deleteChap")
    public void deleteChap(String id,String aid){
        System.out.println(id);
        chapterService.removeChap(id);
        //查询出单个专辑
        Album oneAibum = albumService.findOneAibum(aid);
        //根据专辑id  查询出 专辑中的有效数据条数
        Integer count = chapterService.findCount(oneAibum.getId());
        //修改数据
        albumService.updateCount(oneAibum.getId(),count);
    }
}
