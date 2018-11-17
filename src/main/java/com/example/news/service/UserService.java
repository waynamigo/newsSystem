package com.example.news.service;

import com.example.news.repository.UserRepository;
import com.example.news.results.Result;
import com.example.news.modle.User;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.news.tools.MD5;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Result addUser(String username, String passwd) {
        try {
            String salt= RandomStringUtils.randomAlphanumeric(7);
            User user = new User(username,MD5.string(passwd+salt),salt);
            userRepository.save(user);
            return Result.success("success signup");
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    public Result findUser(String username,String passwd){
        try{
            User user= userRepository.findUserByUsername(username);
            if (user!=null) {
                String password = MD5.string(passwd + user.getSalt());
                System.out.println(password+"="+user.getPassword());
                if (password.equals(user.getPassword())){
//                    String token = JwtUtils.createToken(userPassword.getId());
                    return Result.success("ok.shebao");
                } else {
                    return Result.error("login denied");
                }
            }else {
                return Result.error("not exist:"+username);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("need to debug");
        }
    }
}
