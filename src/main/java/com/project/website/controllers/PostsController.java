package com.project.website.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.website.model.Posts;
import com.project.website.service.PostsService;



@RestController
public class PostsController {
	
	private static Logger logger = LogManager.getLogger();
	@Autowired
    PostsService postService;

    @RequestMapping("/posts/getAllPosts")
    @ResponseBody
    public ResponseEntity<Map> getAllItems(){
        List<Posts> posts =  postService.getAllPosts();
        Map<String,Object> postsMap = new HashMap<String,Object>();
        postsMap.put("posts",posts);
        logger.info("Returning the array of posts"+postsMap.get("posts"));
        
        return new ResponseEntity<Map>(postsMap, HttpStatus.OK);
    }

}
