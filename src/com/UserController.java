package com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView loginpage() {
		ModelAndView mv=new ModelAndView("Login");
		return mv;
	}
	@RequestMapping(value="/log",method=RequestMethod.GET)
	public ModelAndView logpage() {                                                     
		ModelAndView mv=new ModelAndView("Login");
		return mv;
	}
	@RequestMapping(value="/Error",method=RequestMethod.GET)
	public ModelAndView errorpage() {
		ModelAndView mv=new ModelAndView("Error");
		return mv;
	}
	@RequestMapping(value="/Forgotpass",method=RequestMethod.GET)
	public ModelAndView forgotpasspage() {
		ModelAndView mv=new ModelAndView("Forgotpass");
		return mv;
	}
	@RequestMapping(value="/Studentform",method=RequestMethod.GET)
	public ModelAndView studentpage() {
		ModelAndView mv=new ModelAndView("Studentform");
		return mv;
	}
	@RequestMapping(value="/Home",method=RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView mv=new ModelAndView("Home");
		return mv;
	}
	@RequestMapping(value="/Marks",method=RequestMethod.GET)
	public ModelAndView markspage() {
		ModelAndView mv=new ModelAndView("Marks");
		return mv;
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView loginchk(HttpServletRequest request, HttpServletResponse response,@RequestParam("uname")String username,@RequestParam("pwd")String password) throws ServletException, IOException {
		System.out.println(username);
		System.out.println(password);
		ModelAndView mv;
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		
		String userValidate = UserDao.authenticateUser(user); //Calling authenticateUser function
		 
		if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
		 {
		 request.setAttribute("userName", username); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
		mv=new ModelAndView("Home");//RequestDispatcher is used to send the control to the invoked page.
		 }
		else if(userValidate.equals("error")) {
			mv=new ModelAndView("Error");
		}
		 else
		 {
		 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
		 mv=new ModelAndView("Login");//forwarding the request
		 }
		return mv;
	}
	
	@RequestMapping(value="chgpass", method=RequestMethod.POST)
	public ModelAndView passchk(@RequestParam("npass")String newpass,@RequestParam("cpass")String cpass,@RequestParam("uname")String uname) {
		ModelAndView mv=new ModelAndView();
		User user=new User();
		user.setUsername(uname);
		user.setPassword(cpass);
		
		String passValid=UserDao.passValidate(user);
		if(passValid.equals("success")) {
			mv.setViewName("Login");
		}else {
			mv.setViewName("Forgotpass");
		}
		
		return mv;
	}
	@RequestMapping(value="getdetails",method=RequestMethod.GET)
	public ModelAndView search(HttpServletRequest request,@RequestParam("sname")String name,@ModelAttribute("Student")Student student) {
		System.out.println("name="+	name);
		
		
		ModelAndView mv = new ModelAndView();
		//Student student=new Student();
		student.setStudentname(name);
	
		student=UserDao.getDetails(student);
		
		System.out.println(student.getGrade());
		Marks marks=new Marks();
		int x=student.getRollnumber();
		marks.setRollnumber(x);
		marks=UserDao.getMarksDetails(marks);
		
		if(student.getRollnumber()!=0) {
			mv.addObject(marks);
			mv.addObject(student);
			mv.setViewName("Student");
			//mv=new ModelAndView("Student","Student",student);
			
		}else {
			
			mv=new ModelAndView("Home");
		}
		return mv;
	}

	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView savedetails(HttpServletRequest request, HttpServletResponse response) {
		String rollnumber=request.getParameter("roll");
		String name=request.getParameter("sname");
		String gender=request.getParameter("gender");
		String grade=request.getParameter("grade");
		
		int roll = Integer.parseInt(rollnumber);
		int grad = Integer.parseInt(grade);
		ModelAndView mv;
		Student student=new Student();
		student.setRollnumber(roll);
		student.setStudentname(name);
		student.setGender(gender);
		student.setGrade(grad);
		String savedetail=UserDao.save(student);
		System.out.println("in save ");
		if(savedetail.equals("success")) {
			
			mv=new ModelAndView("Home");
		}else {
			 request.setAttribute("errMessage", savedetail);
			mv=new ModelAndView("Studentform");
		}
		return mv;
	}
	
	@RequestMapping(value="savemarks", method=RequestMethod.POST)
	public ModelAndView savemarksdetails(HttpServletRequest request, HttpServletResponse response) {
		String rollnumber=request.getParameter("roll");
		String english=request.getParameter("english");
		String maths=request.getParameter("maths");
		String science=request.getParameter("science");
		//String =request.getParameter("grade");
		int roll = Integer.parseInt(rollnumber);
		int eng = Integer.parseInt(english);;
		int math = Integer.parseInt(maths);
		int sci = Integer.parseInt(science);
		
		ModelAndView mv;
		Marks m=new Marks();
		m.setRollnumber(roll);
		m.setEnglish(eng);
		m.setMaths(math);
		m.setScience(sci);
		String savedetail=UserDao.savemarks(m);
		System.out.println("in save ");
		if(savedetail.equals("success")) {
			
			mv=new ModelAndView("Home");
		}else {
			 request.setAttribute("errMessage", savedetail);
			mv=new ModelAndView("Studentform");
		}
		return mv;
	}
	@RequestMapping(value="fileupload", method=RequestMethod.POST)
	public ModelAndView processUpload(@RequestParam MultipartFile file) throws IOException, SQLException {
	    ModelAndView mv=new ModelAndView();
		Student student=new Student();
	        student.setFile(file);
	        String upload=UserDao.processFile(student);
	        if(upload.equals("success")) {
	        	mv.setViewName("Home");
	        	
	        }else {
	        	mv.setViewName("Home");
	        }
	        
	        return mv;
	}
}
