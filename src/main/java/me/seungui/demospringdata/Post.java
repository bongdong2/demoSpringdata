package me.seungui.demospringdata;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

  @Id @GeneratedValue
  private Long id;

  private String title;

  private Set<Comment> comments = new HashSet<>();

  public void addComment(Comment comment) {
    this.getComments().add(comment);
    comment.setPosts(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<Comment> getComments() {
    return comments;
  }

  public void setComments(Set<Comment> comments) {
    this.comments = comments;
  }
}
