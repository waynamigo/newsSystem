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
    public User findUser(String username,String passwd){
        try{
            System.out.println(username+"end");
            User user = userRepository.findUserByUsername(username);
            if (user!=null) {
                String password = MD5.string(passwd + user.getSalt());
                System.out.println(password+"="+user.getPassword());
                if (password.equals(user.getPassword())){
//                    String token = JwtUtils.createToken(userPassword.getId());
                    return user;
                } else {
                    return null;
                }
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Result findUserR(String username,String passwd) {
        try {
            System.out.println(username + "end");
            User user = userRepository.findUserByUsername(username);
            if (user != null) {
                String password = MD5.string(passwd + user.getSalt());
                System.out.println(password + "=" + user.getPassword());
                if (password.equals(user.getPassword())) {
//                    String token = JwtUtils.createToken(userPassword.getId());
                    return Result.success(user);
                } else {
                    return Result.error("wrong password");
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
