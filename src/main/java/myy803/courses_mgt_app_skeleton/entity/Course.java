package myy803.courses_mgt_app_skeleton.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.Table;


@Entity
@Table(name="course")

public class Course {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="syllabus")
	private String syllabus;
	
	@Column(name="year")
	private int year;
	
	@Column(name="semester")
	private int semester;
		
	@Column(name="description")
	private String description;
	
	@Column(name="teacher")
	private String teacher;
	
	@Column(name="usrname")
	private  String usrname;
	
	@Column(name="finalexamweight")
	private double finalexamweight;
	
	//users_courses relation mapping
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "users_courses",
				joinColumns = @JoinColumn(name="course_id"),
				inverseJoinColumns = @JoinColumn(name="user_id"))
	private static Set<User> users = new HashSet<>();
	
	//One to Many relation with StudentRegistrations according to requirments
	@OneToMany(mappedBy="course")
	private List<StudentRegistration> StudentRegistrations;
	 
	// define constructors
	
	public Course() {
		
	}

	public Course(int id, String name, String syllabus,int year,int semester,String description,String teacher,String usrname,double finalexamweight) {
		this.id = id;
		this.name = name;
		this.syllabus = syllabus;
		this.year = year;
		this.semester= semester;
		this.teacher = teacher;
		this.usrname = usrname;
		this.finalexamweight = finalexamweight;
	}


	public Course(String name, String syllabus, String description,String teacher,String usrname) {
		this.name = name;
		this.syllabus = syllabus;
		this.description = description;
		this.teacher = teacher;
		this.usrname = usrname;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public int  getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public int  getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public  String getUsrname() {
		return usrname;
	}
	public  void setUsrname(String usrname) {
		this.usrname= usrname;
	}
	public double getFinalexamweight() {
		return finalexamweight;
	}
	public void setFinalexamweight(double finalexamweight) {
		this.finalexamweight= finalexamweight;
	}
	//private static Set<User> users = new HashSet<>();
	
	// define tostring

	@Override
	public String toString() {
		return "Course [id=" + id +  "]";
	}
	public  Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public boolean addStudentRegistration(StudentRegistration studentregistration) {
		return StudentRegistrations.add(studentregistration);
		
	}
		
}
