package com.blueasdfg.turling;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {

     @Id
     @GeneratedValue
     private Integer id;
     private String username;
     private String likeeat;

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getLikeeat() {
          return likeeat;
     }

     public void setLikeeat(String likeeat) {
          this.likeeat = likeeat;
     }

     public Users() {

     }
}
