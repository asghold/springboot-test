package com.test.trupper.springboot_test.entities;

import com.test.trupper.springboot_test.model.UserRoles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private UserRoles name;

  public Role() {

  }

  public Role(UserRoles name) {
    this.name = name;
  }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserRoles getName() {
        return this.name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }

}
