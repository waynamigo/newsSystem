package com.example.news.service;

import com.example.news.repository.NewsRepository;
import com.example.news.repository.UserRepository;
import com.example.news.results.Result;
import com.example.news.utils.News;
import com.example.news.utils.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Result addUser(String username, String passwd) {
        try {
            String salt  = "";
            User user = new User(username,passwd,salt);
            userRepository.save(user);
            return Result.success("注册成功");
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    public Result findUser(String username,String passwd){
        try{
            if(userRepository.findUserByUsernameAndPassword(username,passwd)!=null){
                return Result.success(userRepository.findUserByUsernameAndPassword(username,passwd));
            }else{
                return Result.error("denied");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("need to debug");
        }
    }
}
