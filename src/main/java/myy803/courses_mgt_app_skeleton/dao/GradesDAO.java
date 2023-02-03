package myy803.courses_mgt_app_skeleton.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import myy803.courses_mgt_app_skeleton.entity.Grades;

@Repository
public interface GradesDAO  extends JpaRepository<Grades, Integer> {
	
	public  List<Grades>  findById(int stid);
	
}
