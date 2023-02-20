package coms.Admin.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import coms.Admin.bean.Grades;
import coms.Admin.exception.GradeAlredyExists;
import coms.Admin.exception.GradeNotFound;
@Service
public interface AdminService {

	Grades insertGrade(Grades gradName) throws GradeAlredyExists;

	List<Grades> grades() throws GradeNotFound;

	Grades updateGrad(String newGrade,int gradeId) throws GradeNotFound;

	void deleteGrade(int gradeId) throws GradeNotFound;

}
