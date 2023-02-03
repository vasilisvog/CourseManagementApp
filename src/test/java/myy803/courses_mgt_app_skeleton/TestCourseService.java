package myy803.courses_mgt_app_skeleton;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import myy803.courses_mgt_app_skeleton.dao.CourseDAO;
import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.service.CourseService;
import myy803.courses_mgt_app_skeleton.service.CourseServiceImpl;

import org.junit.jupiter.api.Test;
//@SpringBootTest
//@TestPropertySource(
//  locations = "classpath:application.properties")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)

class TestCourseService {

	@TestConfiguration
    static class CourseServiceImplTestContextConfiguration {
 
        @Bean
        public CourseService courseService() {
            return new CourseServiceImpl();
        }
    }

	@Autowired 
	CourseService courseService;
	
	@MockBean
	CourseDAO courseDAO;
	
	@Test
	void testCourseDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}

	@Test
	void testFindByIdReturnsCourse(){
		Mockito.when(courseDAO.findById(1)).thenReturn(new Course(1, "Texn","",0,0,"","","",0));
		Course storedCourse = courseService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Texn", storedCourse.getName());
	}

}
