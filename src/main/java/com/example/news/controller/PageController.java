package com.example.news.controller;

import com.example.news.modle.News;
import com.example.news.modle.User;
import com.example.news.repository.UserRepository;
import com.example.news.service.NewsService;
import com.example.news.service.UserService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/login/")
    public String login(@RequestParam(value = "username", defaultValue = "null") String name,
                        @RequestParam(value = "password", defaultValue = "null") String password,
                        Model model){//String username, String password,Model model
        try {
            User user = userService.findUser(name,password);
            if (user!=null){
                model.addAttribute("user",user);
                if(user.getId()==1){
                    isadmin=true;
                }
                return "redirect:/newspage/";
            }else{
                model.addAttribute("msg","nosuchuser");
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
    @PostMapping("/publish/")
    public String publish(@RequestParam(value = "title", defaultValue = "null") String title,
                        @RequestParam(value = "content", defaultValue = "null") String content,
                        Model model){//String username, String password,Model model){
         try {
            if (newsService.publishnews(title,content)==true){
                return "redirect:/newspage/";
            }else{
                model.addAttribute("msg","publish fault");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
