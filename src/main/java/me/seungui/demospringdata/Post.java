package me.seungui.demospringdata;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {

  @Id @GeneratedValue
  private Long id;

  private String title;

  // Fetch 연관관계 엔티티를 어떻게 가져올 것이냐
  // 지금(Eager), 나중에(Lazy)
  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private Set<Comment> comments = new HashSet<>();

  public void addComment(Comment comment) {
    this.getComments().add(comment);
    comment.setPost(this);
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

  @Override
  public String toString() {
    return "Post{" +
        "title='" + title + '\'' +
        '}';
  }
}
