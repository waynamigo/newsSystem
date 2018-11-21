package com.example.news.controller;

import com.example.news.modle.News;
import com.example.news.modle.User;
import com.example.news.repository.UserRepository;
import com.example.news.service.NewsService;
import com.example.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/login/")
    public String login(@RequestParam(value = "username", defaultValue = "null") String name,
                        @RequestParam(value = "password", defaultValue = "null") String password,
                        Model model){//String username, String password,Model model
        try {
            User user = userService.findUser(name,password);
            if (user!=null){
                model.addAttribute("user",user);
                return "redirect:/newspage/";
            }else{
                model.addAttribute("msg","nosuchuser");

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
            //System.out.println(news.size());
            if (news != null) {
                model.addAttribute("news", news);
                return "newspage";
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
