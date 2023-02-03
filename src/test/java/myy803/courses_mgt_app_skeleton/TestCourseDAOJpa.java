package myy803.courses_mgt_app_skeleton;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import myy803.courses_mgt_app_skeleton.dao.*;
import myy803.courses_mgt_app_skeleton.entity.Course;
@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
class TestCourseDAOJpa {

	

		@Autowired 
		CourseDAO courseDAO;
		
		@Test
		void testCourseDAOJpaImplIsNotNull() {
			Assertions.assertNotNull(courseDAO);
		}

		@Test
		void testFindByIdReturnsCourse() {
			Course storedCourse = courseDAO.findById(1);
			Assertions.assertNotNull(storedCourse);
			Assertions.assertEquals("Texn", storedCourse.getName());
		}
}
