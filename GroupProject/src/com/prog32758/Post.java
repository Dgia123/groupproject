package com.prog32758;
import java.io.Serializable;
import java.util.Date;
public class Post implements Serializable{
  private String postId;
  private Date postDate;
  private String category;
 
  
  public Post() {}
  public Post(String psId, Date psDate, String cat) {
	  this.setPostId(psId);
	  this.setPostDate(psDate);
	  this.setCategory(cat);
	  
  }
public String getPostId() {
	return postId;
}
public void setPostId(String postId) {
	this.postId = postId;
}
public Date getPostDate() {
	return postDate;
}
public void setPostDate(Date postDate) {
	this.postDate = postDate;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

	
}
