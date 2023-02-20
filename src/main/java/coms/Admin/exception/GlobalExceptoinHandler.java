package coms.Admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class GlobalExceptoinHandler {
	
	@ExceptionHandler(GradeAlredyExists.class)
	public ResponseEntity<String> gradeAlredyExists(){
		return new ResponseEntity<String>("Grade alredy exists",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(GradeNotFound.class)
	public ResponseEntity<String> gradeNotFound(){
		return new ResponseEntity<String>("Grade(s) not found.",HttpStatus.NOT_FOUND);
	}

}
