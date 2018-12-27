package com.baizhi.test;

import com.baizhi.Controller.AlbumController;
import com.baizhi.dao.*;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Album;
import com.baizhi.entity.Carousel;
import com.baizhi.entity.Menu;
import com.baizhi.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
    public class Tests {

    @Autowired
    private AdminService adminService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private AlbumDao aDao;
    @Autowired
    private CarouselDao asDao;
    @Autowired
    private CarouselService carouselService;

    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private AlbumService albumService;

    @Autowired
    private GuruDao guruDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private GuruService guruService;
    @Autowired
    private ChapterDao chapterDao;

    @Autowired
    private UsersService userService;

    @Autowired
    private DataDao dataDao;




   /* @Test
    public void sda(){

        Map<String, Datas> stringDatasMap = dataDao.data1();
        for (Map.Entry<String, Datas> stringDatasEntry : stringDatasMap.entrySet()) {
            System.out.println(stringDatasEntry);
        }

    }*/

    @Test
    public void TestCarousel(){
        Carousel asd = carouselService.findid("asd");
        System.out.println(asd);
        /*Carousel carousel = new Carousel();
        carousel.setDescrib("asdasdadasdasdadadada");
        carousel.setHeadline("asdad");
        carousel.setStatus("aaa111111");
        carousel.setId("asd");
        carousel.setUrl("asdad");
        asDao.update(carousel);*/

        /*List<Carousel> carousels = carouselService.findAllCarousel();
        for (Carousel carousel : carousels) {
            System.out.println("---"+carousel);
        }*/

    }
    @Test
    public void TestAdmin(){
        Admin admin = adminService.findAdmin("admin");
        System.out.println(admin);
    }
    @Test
    public void TestMenu(){
        List<Menu> menu = menuService.findMenu();
        //List<Menu> menus = menuDao.queryAll();
        /*MenuController menuController = new MenuController();
        List<Menu> menu = menuController.findMenu();*/

        for (Menu ss : menu) {
            System.out.println(ss);
        }

    }
    @Test
    public void TestAlbun(){
        List<Album> albums = aDao.queryAll();
        System.out.println(albums);
    }
    @Test
    public void TestAas(){
        AlbumController albumController = new AlbumController();
        List<Album> album = albumController.findAlbum();
        System.out.println(album);
    }
}
