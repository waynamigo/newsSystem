package com.example.news.controller;

import com.example.news.results.Result;
import com.example.news.service.NewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService = new NewsService();
    @ApiOperation(value = "publish", notes = "publish", response = Result.class)
    @PostMapping(value = "/publish/")
    public Result publish(@ApiParam(value = "title" ,required=true ) @RequestParam String title,
                         @ApiParam(value = "content" ,required=true ) @RequestParam String content){
        return newsService.publishnews(title,content);
    }

    @ApiOperation(value = "delete", notes = "delete", response = Result.class)
    @PostMapping(value = "/delete/")
    public  Result delete(@ApiParam(value = "title" ,required=true ) @RequestParam String title){
        return newsService.deletenews(title);
    }

    @ApiOperation(value = "overview", notes = "overview", response = Result.class)
    @PostMapping(value = "/overview/")
    public  Result overview(){
        return newsService.findallnewsR();
    }
}
