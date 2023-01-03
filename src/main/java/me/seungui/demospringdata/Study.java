package me.seungui.demospringdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {

  @Id @GeneratedValue
  private Long id;

  private String name;

  @ManyToOne
  private Account owner;

  //  getter, setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Account getAccount() {
    return owner;
  }

  public void setAccount(Account owner) {
    this.owner = owner;
  }
}
