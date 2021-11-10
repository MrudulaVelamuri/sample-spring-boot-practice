package com.example.student.profile;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.student.profile.excelExport.UserExcelExporter;
import com.example.student.profile.model.StudentsDetails;
import com.example.student.profile.repo.StudentProfileRepo;
import com.example.student.profile.repo.StudentsInfoRepo;

@Controller
public class HomeController {
	@Autowired
	StudentsInfoRepo repo;
	
	@Autowired
	StudentProfileRepo studentRepo;
	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addStudent")
	public String addAlien(StudentsDetails student) {
		repo.save(student);
		return "home.jsp";
	}
	
	@RequestMapping("/getStudent")
	public ModelAndView getAlien(@RequestParam String studentId) {
		
		ModelAndView mv = new ModelAndView("getstudent.jsp");
		System.err.println("Student Id"+ studentId);
		StudentsDetails alien = repo.findById(studentId).orElse(new StudentsDetails());
		alien=studentRepo.findById(studentId).orElseThrow();
		mv.addObject(alien);
		return mv;
	}
	
	/*
	 * @RequestMapping("/getStudents") public ModelAndView getAlien() {
	 * 
	 * ModelAndView mv = new ModelAndView("getstudent.jsp"); repo.findAll(); //
	 * mv.addObject(alien); return mv; }
	 * 
	 * @RequestMapping("/deleteStudent") public String deleteAlien(@RequestParam int
	 * studentId) {
	 * 
	 * //ModelAndView mv = new ModelAndView("getstudent.jsp");
	 * repo.deleteById(studentId); repo.findById(studentId).isEmpty(); return
	 * "home.jsp";
	 * 
	 * }
	 */
	
	@GetMapping("/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException{
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename = studentinfo.xlsx";
	response.setHeader(headerKey, headerValue)	;
	List<StudentsDetails> listStudent = studentRepo.findAll();
	UserExcelExporter exp = new UserExcelExporter(listStudent);
	exp.export(response);
	}
	
}
