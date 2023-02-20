package coms.Admin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Admin.bean.Grades;

@Repository
public interface GradeDao extends JpaRepository<Grades, Integer> {

//	boolean ExistsByGradName(String gradName);
//	Grades findByGradeName(String gradeName);

	Grades findByGradeName(String gradName);

	void deleteByGradeName(String gradName);

}
