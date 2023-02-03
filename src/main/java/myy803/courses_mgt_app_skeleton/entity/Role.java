package myy803.courses_mgt_app_skeleton.entity;

import javax.persistence.*;
//<html lang="en" xmlns:th="http://www.thymeleaf.org">
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    
  
    public int getId() {
        return id;
    }
    public void setId(int id) {
    	this.id= id;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
     
    // remaining getters and setters   
}