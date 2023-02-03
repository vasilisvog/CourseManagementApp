package myy803.courses_mgt_app_skeleton.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_registrations")
public class StudentRegistration {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// define fields
	@Column(name="studentid")
	private int studentid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="yearreg")
	private int yearreg;
	
	@Column(name="currentsemester")
	private int currentsemester;
		
	@Column(name="id")
	private int id;
	
	//maps relation between studentregistration and course, many students in one course, course id(id) as foreign key
	@ManyToOne
    @JoinColumn(name="id", insertable=false ,updatable=false)
	private Course course;
	// define constructors

	public StudentRegistration() {
		
	}
	
	public StudentRegistration(int studentid, String name,int yearreg,int currentsemester,int id) {
		this.studentid = studentid;
		this.name = name;
		this.yearreg = yearreg;
		this.currentsemester= currentsemester;
		this.id= id;
	}


	public StudentRegistration(String name) {
		this.name = name;
	}

	// define getter/setter
	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int  getYearreg() {
		return yearreg;
	}

	public void setYearreg(int yearreg) {
		this.yearreg = yearreg;
	}
	public int  getCurrentsemester() {
		return currentsemester;
	}

	public void setCurrentsemester(int currentsemester) {
		this.currentsemester = currentsemester;
	}

	public int  getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// define tostring

	@Override
	public String toString() {
		return "student [studentid=" + studentid +  "]";
	}
	
		
}
