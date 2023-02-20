package coms.Admin.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coms.Admin.Service.AdminService;
import coms.Admin.bean.Grades;
import coms.Admin.exception.GradeAlredyExists;
import coms.Admin.exception.GradeNotFound;

@RestController
@RequestMapping("/elearning/api/admin")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired 
	AdminService adminService;
	
	@PostMapping("/addGrade")
	public ResponseEntity<Grades> addGrad(@RequestBody Grades grade) throws GradeAlredyExists{		
		return new ResponseEntity<Grades>(adminService.insertGrade(grade),HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@GetMapping("/getGrades")
	public ResponseEntity<List<Grades>> getGrade() throws GradeNotFound{
		
		
		return new ResponseEntity<List<Grades>>(adminService.grades(),HttpStatus.FOUND);
		
	}
	
	@PatchMapping("/editGrade/{gradeId}/{gradeName}")
	public ResponseEntity<Grades> editGrade(@PathVariable String gradeName,@PathVariable int gradeId) throws GradeNotFound{
		
		return new ResponseEntity<>(adminService.updateGrad(gradeName,gradeId),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{gradeId}")
	public ResponseEntity<String> deleteGrade(@PathVariable int gradeId) throws GradeNotFound{
		
		adminService.deleteGrade(gradeId);
		return new ResponseEntity<String>("grade with Id "+gradeId+" deleted",HttpStatus.OK);
		
		
		
	}
	

}
