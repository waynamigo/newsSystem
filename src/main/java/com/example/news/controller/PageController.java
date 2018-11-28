package com.example.news.controller;

import com.example.news.modle.News;
import com.example.news.modle.User;
import com.example.news.repository.UserRepository;
import com.example.news.service.NewsService;
import com.example.news.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import weatherExtra.Weather;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by waynamigo on 2018/11/18.
 */
@Controller
public class PageController {
    @Autowired
    UserService userService=new UserService();
    @Autowired
    NewsService newsService=new NewsService();

    boolean isadmin = false;
    private static Logger logger = Logger.getLogger(PageController.class);

    @RequestMapping("/login/")
    public String login(@RequestParam(value = "username", defaultValue = "null") String name,
                        @RequestParam(value = "password", defaultValue = "null") String password,
                        Model model){//String username, String password,Model model
        try {
            User user = userService.findUser(name,password);
            if (user!=null){
                model.addAttribute("user",user);
                if(user.getId()==1){
                    logger.info("admin status");
                    isadmin=true;
                }
                logger.info("login success:username="+name);
                return "redirect:/newspage/";
            }else{
                model.addAttribute("msg","nosuchuser");
                logger.info("login failed:no such user");
               // return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/newspage/")
    public String getNews(Model model) {
        try {
            List<News> news = newsService.findallnews();
            if (news != null) {
                System.out.println(news.size());
                if(isadmin){
                    model.addAttribute("news", news);

                    return "newspage";
                }else{
                    List<News> newslist = newsService.viewallnews();
                    model.addAttribute("news",newslist);
                    logger.info("get news list");
                    return "viewerpage";
                }
            } else {
                System.out.println("null");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
    @GetMapping("/delete/{id}")
    public String deleteNews(@PathVariable("id") Integer id) {
        System.out.println("debug delete");
        try {
            if (newsService.deletenews(id)) {
                logger.info("delete news by id="+id);
                return "redirect:/newspage/";
            } else {
                System.out.println("null");
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
    @GetMapping("/review/{news}")
    public String reviewNews(@PathVariable("news") News news) {
        System.out.println("debug review");
        try {
            if (newsService.admitnews(news)) {
                logger.info("check news(id="+news.getId()+") admit");
                return "redirect:/newspage/";
            } else {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
    @PostMapping("/publish/")
    public String publish(@RequestParam(value = "title", defaultValue = "null") String title,
                        @RequestParam(value = "content", defaultValue = "null") String content,
                        Model model){//String username, String password,Model model){
         try {
            if (newsService.publishnews(title,content)==true){
                logger.info("publish success:title="+title);
                return "redirect:/newspage/";
            }else{
                logger.info("publish fault");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
//    @PostMapping("/weather/")
//    public String weather(Model model){//String username, String password,Model model){
//        try{
//            Weather weather = (Weather) Naming.lookup("rmi://localhost:8888/weather");
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
