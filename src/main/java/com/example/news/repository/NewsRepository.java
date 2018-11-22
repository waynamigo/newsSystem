package com.example.news.repository;

import com.example.news.modle.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
    List<News> findAll();
    News findNewsByTitle(String title);
    News findNewsById(Integer id);
    List<News> findByIdIs(Integer reviewed);
    @Transactional
    Integer deleteNewsById(Integer id);
    @Transactional
    Boolean deleteNewsByTitle(String title);
//

}
