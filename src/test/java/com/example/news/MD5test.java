package com.example.news;

import com.example.news.modle.User;
import com.example.news.repository.UserRepository;
import com.example.news.results.Result;
import com.example.news.tools.MD5;
import org.junit.Test;

public class MD5test {
    UserRepository userRepository;

    @Test
    public void testfind(){
        String username ="testab";
        String passwd = "123456";

        User user = userRepository.findUserByUsernameAndPassword("admin","877089");

        String password = MD5.string(passwd + user.getSalt());
        System.out.println(password+"="+user.getPassword());
        if (password.equals(user.getPassword())){

        } else {
        }
    }
}
