package myy803.courses_mgt_app_skeleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myy803.courses_mgt_app_skeleton.dao.StudentRegistrationDAO;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;
import myy803.courses_mgt_app_skeleton.service.StudentRegistrationService;
import myy803.courses_mgt_app_skeleton.service.StudentRegistrationServiceImpl;
//@SpringBootTest
//@TestPropertySource(
//locations = "classpath:application.properties")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class TestStudentRegistrationService {

	@TestConfiguration
    static class StudentRegistrationServiceImplTestContextConfiguration {
 
        @Bean
        public StudentRegistrationService studentregistrationService() {
            return new StudentRegistrationServiceImpl();
        }
    }
	@Autowired 
	StudentRegistrationService studentregistrationService;
	
	@MockBean
	StudentRegistrationDAO studentregistrationDAO;
	
	@Test
	void testStudentRegistrationDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentregistrationService);
	}

	@Test
	void testFindByIdReturnsStudentRegistration(){
		Mockito.when(studentregistrationDAO.findById(1)).thenReturn(new StudentRegistration(1, "mia",0,0,45));
		StudentRegistration storedStudentRegistration = studentregistrationService.findById(1);
		Assertions.assertNotNull(storedStudentRegistration);
		Assertions.assertEquals("mia", storedStudentRegistration.getName());
	}

}
