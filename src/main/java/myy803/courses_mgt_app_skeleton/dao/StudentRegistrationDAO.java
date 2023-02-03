package myy803.courses_mgt_app_skeleton.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;

@Repository
public interface StudentRegistrationDAO extends JpaRepository<StudentRegistration, Integer>{
	
	public List<StudentRegistration> findRegistrationsByCourseId(int courseid);
	public StudentRegistration findById(int studentid);
	@Query("SELECT finalexam FROM Grades u WHERE u.stid = :studentid")
	public double getgrades(int studentid);
	@Query("SELECT project FROM Grades u WHERE u.stid = :studentid")
	public double getprojecctgrades(int studentid);
}
