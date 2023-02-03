package myy803.courses_mgt_app_skeleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;
import myy803.courses_mgt_app_skeleton.service.StudentRegistrationService;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
class TestStudentRegistrationServiceWithoutMocks {

	@Autowired 
	StudentRegistrationService studentregistrationService;
	
	@Test
	void testStudentRegistrationDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentregistrationService);
	}

	@Test
	void testFindByIdReturnsStudentRegistration() {
		StudentRegistration storedStudentRegistration = studentregistrationService.findById(1);
		Assertions.assertNotNull(storedStudentRegistration);
		Assertions.assertEquals("mia", storedStudentRegistration.getName());
	}

}
