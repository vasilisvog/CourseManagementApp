package myy803.courses_mgt_app_skeleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import myy803.courses_mgt_app_skeleton.dao.StudentRegistrationDAO;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;


@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
class TestStudentRegistrationDAOJpa {


	@Autowired 
	StudentRegistrationDAO studentregistrationDAO;
	
	@Test
	void testStudentRegistrationDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentregistrationDAO);
	}

	@Test
	void testFindByIdReturnsStudentRegistration() {
		StudentRegistration storedStudentRegistration = studentregistrationDAO.findById(1);
		Assertions.assertNotNull(storedStudentRegistration);
		Assertions.assertEquals("mia", storedStudentRegistration.getName());
	}
}
