package com.example.news.repository;

import com.example.news.utils.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
    List<News> findAll();
    News findNewsByTitle(String title);
    News findNewsById(Integer id);
    boolean deleteNewsByid(Integer id);
}
