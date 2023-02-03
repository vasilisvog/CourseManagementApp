package myy803.courses_mgt_app_skeleton.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import myy803.courses_mgt_app_skeleton.entity.Course;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {

	public Course findById(int id);

	public List<Course> findByUsrname(String usrname);//correlates to findCourseByInstructorLogin(string)
	@Query("SELECT id FROM Course u WHERE u.usrname = :usrname")
	public int getCourseIdByUsrname(String usrname);//query to get courseId by username



	
	
	
}
