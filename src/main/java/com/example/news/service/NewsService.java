package com.example.news.service;

import com.example.news.repository.NewsRepository;
import com.example.news.results.ErrorResult;
import com.example.news.results.Result;
import com.example.news.results.SuccessResult;
import com.example.news.modle.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    public Result publishnews(String title, String content) {
        try {
            News anews = new News(title, content);
            newsRepository.save(anews);
            return Result.success("发布成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("有毒 滚去debug");
        }
    }
    
    public Result editnews(Integer id,String title,String content){
        try{
            if(newsRepository.findNewsById(id)!=null){
                newsRepository.deleteNewsByid(id);
                newsRepository.save(new News(title,content));
                return Result.success("修改成功");
            }
            else {
                return Result.error();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("有毒 滚去debug");
        }
    }
    public Result deletenews(Integer id){
        try {
            if (newsRepository.deleteNewsByid(id) ==true) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("有毒 滚去debug");
        }
    }
    public Result findnews(String title){
        try {
            if (newsRepository.findNewsByTitle(title) != null) {
                return Result.success("查找成功");
            } else{
                return Result.error("无此新闻");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.error("有毒 滚去debug");
        }
    }


    public Result findallnews(){
        try {
            List<News> newsList = newsRepository.findAll();
            if (newsList == null)
                return new ErrorResult();
//            return Result.success(newsList);
            return new SuccessResult(newsList);
        }
        catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
