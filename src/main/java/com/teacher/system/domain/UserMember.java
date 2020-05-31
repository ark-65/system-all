package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserMember {
    @Id
    Integer id;
    String username;
    String password;
}
