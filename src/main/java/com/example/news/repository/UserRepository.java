package com.example.news.repository;
import com.example.news.modle.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByUsernameAndPassword(String username,String password);
    User findUserByUsername(String username);
}