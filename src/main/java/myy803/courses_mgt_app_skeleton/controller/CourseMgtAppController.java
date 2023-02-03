package myy803.courses_mgt_app_skeleton.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import myy803.courses_mgt_app_skeleton.dao.UserRepository;
import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.Grades;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;
import myy803.courses_mgt_app_skeleton.entity.User;
import myy803.courses_mgt_app_skeleton.service.CourseService;
import myy803.courses_mgt_app_skeleton.service.GradesService;
import myy803.courses_mgt_app_skeleton.service.StudentRegistrationService;
//import myy803.courses_mgt_app_skeleton.service.CourseServiceImpl;

@Controller
public class CourseMgtAppController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserRepository userrep;
	@Autowired
	private StudentRegistrationService studentService;
	@Autowired
	private GradesService gradesService;
	//@Autowired
	//private CourseServiceImpl courseImpl;
	
	public CourseMgtAppController(CourseService theCourseService) {
		 courseService = theCourseService;
	}
	
	//ModelView for login
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/courses/list", method = RequestMethod.GET)
    public String getUser(Model theModel) {
		//show list of courses for user when logging in
        User user = new User();
       List<Course> course = null ;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            String name = auth.getName(); 
             user =userrep.getUserByUsername(name);
             String username = user.getUsername();
            course = courseService.findByUsrname(username);
            theModel.addAttribute("course", course);
        }
        
        return "courses";
    }
			  

	Set<Course> course = new HashSet<>();
	List<Course> courses;
	@RequestMapping("/courses/showFormForAdd")

	public String showFormForAdd(Model theModel) {
		//Add new course for  current user
	      Course course = new Course();
	      User user = new User();
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	       if (auth != null) {
	           String name = auth.getName();
	             
	           user =userrep.getUserByUsername(name);
	           int id = user.getId();
	           user = userrep.findById(id);
	           user.addCourse(course); 
	           theModel.addAttribute("course", course);
	        }
	           
	        
	        return "course-form";
	}

	@RequestMapping("/courses/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int courseId,Model theModel) {
		//update description of course
		Course course = courseService.findById(courseId);
	    theModel.addAttribute("course", course);
	          
	   
	     return "description-form";
	}
	
	
	@RequestMapping("/courses/save")
	public String information( Course course,User user,Model theModel) {
		//save information on new course
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	       
	      String name = auth.getName();
	      course = courseService.saveCourse(course);
	      user =userrep.getUserByUsername(name);
		  int id = user.getId();
		  user = userrep.findById(id);		
	   // set user as a model attribute to pre-populate the form
		  theModel.addAttribute("user", user);
		  theModel.addAttribute("course", course);
	    }
	
		return "redirect:list";
	}
	

	@RequestMapping("/courses/delete")
	public String delete(@RequestParam("courseId") int id) {
		//delete by course id
		// delete the employee
		courseService.deleteById(id);
		//redirects to /courses/list
		return "redirect:list";
		
	}
	
	@RequestMapping("/courses/savedescription")
	public String descriptioninformation( @RequestParam("courseId") int courseId,@RequestParam("name") String name,@RequestParam("description") String description,Course course,User user,Model theModel) {
		//save updated description for course
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	        	course = courseService.findById(courseId);
	        	course.setDescription(description);
	        	String username = auth.getName();
	        	course = courseService.saveCourse(course);
	        	user =userrep.getUserByUsername(username);
		        int id = user.getId();
		        user = userrep.findById(id);
		        // set user as a model attribute to pre-populate the form
	    		theModel.addAttribute("user", user);
	    		theModel.addAttribute("course", course);
	        	
	        }
	
		return "redirect:list";
	}


	@RequestMapping("/courses/studentRegistrations")
	public String showstudentregistrations(@RequestParam("courseId") int courseId,Grades grade,Model theModel) {
		//show list of student registrations for current course
		List<StudentRegistration> studentregistrations = studentService.findRegistrationsByCourseId(courseId);
		theModel.addAttribute("courseId", courseId);
		theModel.addAttribute("studentregistrations", studentregistrations);
		return "studentregistrations";	
	}
	 
	@RequestMapping(value = "/courses/addstudentRegistrations")
	public String addstudentregistration(@RequestParam("courseId") int courseId,Model theModel) {
		//add new student registration
		StudentRegistration studentregistration = new StudentRegistration();
		Course course = courseService.findById(courseId);
		course.addStudentRegistration(studentregistration);
		theModel.addAttribute("studentregistration", studentregistration);
		return "student-form";	
	} 
	
	@RequestMapping("/courses/deletestudentRegistrations")
	public String deletestudentRegistrations(@RequestParam("studentId") int id) {
		//delete student registration by student id
		studentService.deleteById(id);
		//redirects to /courses/list
		return "redirect:list";
	}
	
	@RequestMapping("/courses/updatestudentRegistrations")
	public String updatestudentRegistrations(@RequestParam("studentId") int studentId,Model theModel) {
		//update student registration fields
	   	StudentRegistration studentregistration = studentService.findById(studentId);
	   	theModel.addAttribute("studentregistration", studentregistration);
	   	return "student-form";
	}
	
	@RequestMapping("/courses/savestudentRegistrations")
	public String savestudentRegistrations( Course course,StudentRegistration studentregistration,Model theModel) {
		//Save new student registration or save updates student registration
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
        	studentregistration = studentService.saveStudentRegistration(studentregistration);
        	theModel.addAttribute("course", course);
        	theModel.addAttribute("studentregistration", studentregistration);
        }
        //redirect to /courses/list
        return "redirect:list";
	}
	
	
	@RequestMapping("/grades")
	public String showStudentGrades(@RequestParam("studentId") int studentId,Course course,Model theModel) {
		//Show student grades
		double weight = course.getFinalexamweight();
		
		List<Grades>  grades = gradesService.findById(studentId);
		double finalexam = studentService.getgrades(studentId);
		double project = studentService.getprojecctgrades(studentId);
	    double finalgrade =gradesService.getWeightedfinalgrade(weight,finalexam,project);
	    if(finalgrade >0) {
	    theModel.addAttribute("finalgrade",finalgrade);
	    }
		theModel.addAttribute("grades", grades);
		return "gradeslist";
	}
	
	@RequestMapping("/grades/updategrades")
	public String updateStudentGrades(@RequestParam("stid") int stid,Model theModel) {
		//update student grades fields
		float finalexam = 0; // default values
		float project = 0;
		Grades grades =gradesService.addStudentGrades(stid, finalexam, project);
    	theModel.addAttribute("grades", grades);
    	return "gradesform";
		
	}
	
	@RequestMapping("/grades/deletegrades")
	public String deleteStudentGrades(@RequestParam("stid") int stid) {
		//delete grades by student id
		gradesService.deleteById(stid);
		return "redirect:/courses/list";
	}
	
	@RequestMapping("/grades/addgrades")
	public String addStudentGrades(Model theModel) {
		//add new student grades, but student has to already exist in table
		int stid = 0;
		float finalexam = 0;
		float project = 0;
		Grades grades =gradesService.addStudentGrades(stid, finalexam, project);
		theModel.addAttribute("grades", grades);
		return "gradesform";
	}
	
	@RequestMapping("/grades/savegrades")
	public String saveStudentGrades(Grades grades,StudentRegistration studentregistration,Model theModel) {
		//save the grades
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	        	grades = gradesService.saveGrades(grades);
	        	theModel.addAttribute("studentregistration", studentregistration);
	        	theModel.addAttribute("grades", grades);
	        }
	        return "redirect:/courses/list";	
	}
	
	Map<String,Double> stats ;
	double skewness;
	@RequestMapping("/courses/statistics")
	@ResponseBody
	public void showCourseStatistics(@RequestParam("courseId") int courseId,@RequestParam("courseName") String courseName,Course course,Model theModel) {
			
	}
	
	
}







