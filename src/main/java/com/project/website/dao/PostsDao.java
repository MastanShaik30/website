package com.project.website.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.project.website.model.Posts;

@Repository
public class PostsDao {

	@Autowired
	JdbcTemplate template;
	
	private static Logger logger = LogManager.getLogger();

	/* Getting all Posts from table */

	public List<Posts> getAllPosts() {

		String sql = "SELECT * FROM posts";
		List<Posts> posts = null;
		RowMapper<Posts> rowMapper = new BeanPropertyRowMapper<Posts>(Posts.class);
		try {
			posts = template.query(sql, rowMapper);
		} catch (Exception e) {
			logger.error("SQL Exception : "+ e.getLocalizedMessage());
		}

		return posts;
	}
	
	/*
	 * class PostsMapper implements RowMapper<Posts> {
	 * 
	 * @Override public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
	 * // TODO Auto-generated method stub Posts post = new Posts();
	 * post.setId(rs.getInt("id")); post.setAuthor(rs.getString("author"));
	 * post.setBody(rs.getString("body")); post.setTopic(rs.getString("topic"));
	 * post.setDatePosted(rs.getDate("datePosted"));
	 * post.setDateEdited(rs.getDate("dateEdited")); return post; } }
	 */
	/* Getting a specific posts by posts id from table */
	/*
	 * public Posts getPosts(int postsId){ Posts posts = null; String query =
	 * "SELECT * FROM ITEM WHERE ID=?"; try{ posts =
	 * template.queryForObject(query,new Object[]{postsId},new
	 * BeanPropertyRowMapper<>(Posts.class)); }catch(Exception e){ throw new
	 * PostsNotFoundException("Posts Not Found : "+postsId); } return posts; }
	 * Adding an posts into database table public int addPosts(Posts posts){ String
	 * query = "INSERT INTO ITEM VALUES(?,?,?)"; return template.update(query,new
	 * Object[] { Integer.valueOf(posts.getId()),posts.getName(),posts.getCategory()
	 * }); } delete an posts from database public int deletePosts(int id){ String
	 * query = "DELETE FROM ITEM WHERE ID =?"; int size = template.update(query,id);
	 * if(size == 0){ throw new
	 * PostsNotFoundException("No Posts Found to delete: "+id); } return size; }
	 * 
	 * update an posts from database public void updatePosts(Posts posts){ String
	 * query = "UPDATE ITEM SET name=?, category=? WHERE id =?";
	 * template.update(query, new Object[] { posts.getName(),posts.getCategory(),
	 * Integer.valueOf(posts.getId()) }); }
	 * 
	 * 
	 * public Posts mapRow(ResultSet rs, int rowNum) { Posts employee = new Posts();
	 * employee.setCountry(rs.getString("country"));
	 * employee.setEmployeeName(rs.getString("employee")); return employee;
	 * 
	 * }
	 */

}
