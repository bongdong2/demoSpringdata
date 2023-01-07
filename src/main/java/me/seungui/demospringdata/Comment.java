package me.seungui.demospringdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

  @Id @GeneratedValue
  private Long id;

  private String comment;

  @ManyToOne()
  private Post post;

  private String title;

  private int likeCount = 0;

  public int getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(int like) {
    this.likeCount = like;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }


}
