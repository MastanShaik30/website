package com.project.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.website.model.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
