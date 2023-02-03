package myy803.courses_mgt_app_skeleton.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import myy803.courses_mgt_app_skeleton.entity.Course;


@SpringBootTest
@TestPropertySource(
locations = "classpath:application.properties")
@AutoConfigureMockMvc
class TestController {

		@Autowired
	    private WebApplicationContext context;
		
		@Autowired
		private MockMvc mockMvc;
		
		@Autowired
		CourseMgtAppController appController;

		@BeforeEach
	    public void setup() {
			mockMvc = MockMvcBuilders
	          .webAppContextSetup(context)
	          .build();
	    }
		
		@Test
		void testEmployeeControllerIsNotNull() {
			
			Assertions.assertNotNull(appController);
		}
		
		@Test
		void testMockMvcIsNotNull() {
			Assertions.assertNotNull(mockMvc);
		}
		
		@Test
		@WithMockUser(username = "admin", authorities = { "ADMIN" })
		void testListCourses() throws Exception {
			mockMvc.perform(get("/courses/list")).
			andExpect(status().isOk()).
			andExpect(model().attributeExists("course")).
			andExpect(view().name("courses"));		
			
		}

		@Test
		@WithMockUser(username = "admin", authorities = { "ADMIN"})
		void testSaveCourses() throws Exception {
		    Course course = new Course("Texn", "ylh 5 kefalaia","anaptyksi web app","Zarras","admin");    
		    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		    multiValueMap.add("name", course.getName());
		    multiValueMap.add("syllabus", course.getSyllabus());
		    multiValueMap.add("description", course.getDescription());
		    multiValueMap.add("teacher", course.getTeacher());
		    multiValueMap.add("usrname", course.getUsrname());
		    
			mockMvc.perform(
					post("/courses/save").
				    params(multiValueMap)).
					andExpect(status().isFound()).
					andExpect(view().name("redirect:list"));	
		}

		private String toString(int year) {
			// TODO Auto-generated method stub
			return null;
		}
		
	

}
