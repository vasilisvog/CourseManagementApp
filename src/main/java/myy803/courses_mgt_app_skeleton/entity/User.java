package myy803.courses_mgt_app_skeleton.entity;
import java.util.*;


import javax.persistence.*;

import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.Role;
@Entity
@Table(name="users")

public class User {
 
	    @Id
	    @Column(name = "user_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
		@Column(unique = true,name="username")
	    private String username;
		@Column(name="password")
	    private String password;
		@Column(name="enabled")
	    private boolean enabled;
	    
		//Relation between user_id and course_id many professor can be linked to the same course_id , mapped by joined table users_courses
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinTable(name = "users_courses",
					joinColumns = @JoinColumn(name="user_id"),
					inverseJoinColumns = @JoinColumn(name="course_id"))
		private Set<Course> courses = new HashSet<>();
		//Relation between user_id and role_id mapped by joined table user_roles
	    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id")
	            )
	    private Set<Role> roles = new HashSet<>();
	    
	    public User() {
	    	
	    }
	    public User(int id, String username, String password, boolean enabled) {
			this.id = id;
			this.username= username;
			this.password= password;
			this.enabled = enabled;
		}

		public int getId() {
	        return id;
	    }

		public  String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public Set<Role> getRoles() {
		
			return roles;
		}
		
		public Set<Course> getCourses() {
			return courses;
		}

		public void setCourses(Set<Course> courses) {
			this.courses = courses;
		}
		
		public boolean addCourse(Course course) {
			return courses.add(course);
		}

		public boolean removeCourse(Course course) {
			return courses.remove(course);
		}

		public void saveUserCourse(Set<Course> course) {
			// TODO Auto-generated method stub
			
		}

		public User save(User user) {
			return user.save(user);
			
		}
	

		
	
	}

