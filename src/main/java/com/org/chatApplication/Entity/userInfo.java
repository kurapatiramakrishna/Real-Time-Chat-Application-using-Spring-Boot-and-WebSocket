package com.org.chatApplication.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="User_Information")
public class userInfo 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
}
