package myy803.courses_mgt_app_skeleton.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="grades")
public class Grades {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stid")
	private int stid;
	@Column(name="finalexam")
	private double finalexam;
	@Column(name="project")
	private double project;
	@Column(name="finalgrade")
	private double finalgrade;
	
	//one to one  relation between student id and grades, student id is a primary foreign key in grades table
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="stid", insertable=false ,updatable=false)
	private StudentRegistration studentregistration;
	
	public Grades() {
		
	}
	
	public Grades(int stid, double finalexam,double project) {
		this.stid = stid;
		this.finalexam = finalexam;
		this.project = project;
	}

	// define getter/setter
	
	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public double getFinalexam() {
		return finalexam;
	}

	public void setFinalexam(double finalexam) {
		this.finalexam = finalexam;
	}


	public double  getProject() {
		return project;
	}

	public void setProject(double project) {
		this.project = project;
	}
	public double  getFinalgrade() {
		return finalgrade;
	}

	public void setFinalgrade(double finalgrade) {
		this.finalgrade = finalgrade;
	}

	// define tostring

	@Override
	public String toString() {
		return "grade [studentid=" + stid +  "]";
	}
		
}
