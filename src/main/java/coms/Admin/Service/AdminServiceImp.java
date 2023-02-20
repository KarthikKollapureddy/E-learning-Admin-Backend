package coms.Admin.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.Admin.DAO.GradeDao;
import coms.Admin.DAO.SubjectDao;
import coms.Admin.bean.Grades;
import coms.Admin.exception.GradeAlredyExists;
import coms.Admin.exception.GradeNotFound;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired 
	SubjectDao subjectDaoDao;
	
	@Autowired 
	GradeDao gradeDao;
	
//	grade crud
	
	@Override
	public Grades insertGrade(Grades newGrade) throws GradeAlredyExists {
		// TODO Auto-generated method stub
		Grades grade=gradeDao.findByGradeName(newGrade.getGradeName());
		if(grade == null) {
		   return gradeDao.save(newGrade);
		}
		else {
		
		throw new GradeAlredyExists();
	}

}
	@Override
	public List<Grades> grades() throws GradeNotFound {
		// TODO Auto-generated method stub
		
		List<Grades> grades =  gradeDao.findAll();
		if(grades.size()==0) {
			throw new GradeNotFound();
		}
		return grades; 
	}
	@Override
	public Grades updateGrad(String newGradeName,int gradeId) throws GradeNotFound {
		// TODO Auto-generated method stub
		Optional<Grades> grade=gradeDao.findById(gradeId);
		if(grade.isEmpty()) {
			throw new GradeNotFound();
		}
		grade.get().setGradeName(newGradeName);
		return gradeDao.saveAndFlush(grade.get());
	}
	@Override
	public void deleteGrade(int gradeId) throws GradeNotFound {
		// TODO Auto-generated method stub
		Optional<Grades> grade = gradeDao.findById(gradeId);
		if(grade.isEmpty()) {
			throw new GradeNotFound();
		}
		gradeDao.deleteById(gradeId);
//		9640
	}
	
	
}
