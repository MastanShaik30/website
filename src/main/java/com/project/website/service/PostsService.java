package com.project.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.website.dao.PostsDao;
import com.project.website.model.Posts;

@Service
public class PostsService {
	
	@Autowired
	PostsDao postDao;
	
	public List<Posts> getAllPosts(){
		return postDao.getAllPosts();
	}
	

}
